package com.mybs.service;

import com.mybs.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by AceCream on 2018/3/13.
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    Long addUser(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User getUserByNameAndPsw(@Param("username")String username, @Param("password")String password);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 是否已存在username
     * @param username
     * @return
     */
    User getUserByUsername(String username);

}
