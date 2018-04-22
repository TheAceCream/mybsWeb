package com.mybs.controller;

import com.mybs.exception.APICode;
import com.mybs.exception.APIException;
import com.mybs.po.Manager;
import com.mybs.pub.BaseResultMap;
import com.mybs.service.ManagerService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by AceCream on 2018/3/14.
 */
@Controller
@RequestMapping("/managers")
public class ManagerController {

    @Resource
    private ManagerService managerService;

    /**
     * 添加管理员——注册
     * @param manager
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addManager",method = RequestMethod.POST,produces = "application/json")
    public BaseResultMap addManager(@RequestBody Manager manager, HttpServletRequest request){
        BaseResultMap resultMap = new BaseResultMap();
        try {
            //注册前先测是否已经存在
            Manager oldManager = managerService.getManagerByUsername(manager);
            if (oldManager==null) {
                Long userId = managerService.addManager(manager);
                resultMap.setAPICode(APICode.OK);
                resultMap.setData(userId);
            }else {
                resultMap.setAPICode(APICode.USER_ADD_FAILED);
            }
        }catch (APIException e){
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        }catch (Exception e){
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }

    /**
     * 管理员登录
     * @param manager
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getManager",method = RequestMethod.POST,produces = "application/json")
    public BaseResultMap getManager(@RequestBody Manager manager, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Manager theManager = managerService.getManager(manager);
            if (theManager != null) {
                //放入session中
                HttpSession session = request.getSession();
                session.setAttribute("manager",theManager);
                resultMap.setData(theManager);
                resultMap.setAPICode(APICode.OK);
            } else {
                resultMap.setAPICode(APICode.LOGIN_FAILED);
            }
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }

    /**
     * 管理员退出登录
     * @param request
     */
    @RequestMapping(value = "/managerLogout",method = RequestMethod.GET)
    public void managerLogout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("manager");
        try {
            response.sendRedirect("/index.do");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
