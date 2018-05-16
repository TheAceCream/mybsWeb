package com.mybs.service.impl;

import com.mybs.dao.UserDao;
import com.mybs.po.User;
import com.mybs.service.UserService;
import com.mybs.utils.UniqueIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AceCream on 2018/3/13.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserDao userDao;

    @Override
    public Long addUser(User user) {
        user.setId(UniqueIDUtils.getUniqueID());
        userDao.addUser(user);
        return user.getId();
    }

    @Override
    public User getUserByNameAndPsw(String username, String password) {
        return userDao.getUserByNameAndPsw(username,password);
    }

    @Override
    public int updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public int countList() {
        return userDao.countList();
    }
}
