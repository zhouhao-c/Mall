package com.zh.mall.manager.service.impl;


import com.mall.manager.api.service.UserService;
import com.zh.mall.common.bean.User;
import com.zh.mall.manager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public User queryLoginUser(User user) {
        return userDao.queryLoginUser(user);
    }
}
