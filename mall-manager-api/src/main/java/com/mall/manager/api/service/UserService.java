package com.mall.manager.api.service;

import com.zh.mall.common.bean.User;

import java.util.List;

public interface UserService {

    List<User> queryAll();

    User queryLoginUser(User user);
}
