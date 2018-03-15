package com.mybs.controller;

import com.mybs.exception.APICode;
import com.mybs.exception.APIException;
import com.mybs.po.Manager;
import com.mybs.pub.BaseResultMap;
import com.mybs.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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









}
