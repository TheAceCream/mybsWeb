package com.mybs.controller;

import com.mybs.exception.APICode;
import com.mybs.exception.APIException;
import com.mybs.po.User;
import com.mybs.pub.BaseResultMap;
import com.mybs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by AceCream on 2018/3/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 添加用户——注册
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addUser",method = RequestMethod.POST,produces = "application/json")
    public BaseResultMap addUser(@RequestBody User user, HttpServletRequest request){
        BaseResultMap resultMap = new BaseResultMap();
        try {
            //注册前先测是否存在username
            User oldUser = userService.getUserByUsername(user.getUsername());
            if (oldUser==null) {
                Long userId = userService.addUser(user);
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
     * 用户登录
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST,produces = "application/json")
    public BaseResultMap login(@RequestBody User user, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            User theUser = userService.getUserByNameAndPsw(user.getUsername(), user.getPassword());
            if (theUser != null) {
                resultMap.setAPICode(APICode.OK);
            } else {
                resultMap.setAPICode(APICode.LOGIN_FAILED);
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
     * 更新用户信息
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateUser",method = RequestMethod.POST,produces = "application/json")
    public BaseResultMap updateUser(@RequestBody User user, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            int i = userService.updateUserById(user);
            if (i!=0){
                resultMap.setAPICode(APICode.OK);
            }else {
                resultMap.setAPICode(APICode.UNKNOW_EXECEPTION);
            }
        }catch (APIException e){
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        }catch (Exception e){
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }




}
