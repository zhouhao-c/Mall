package com.zh.mall.manager.dao;


import com.zh.mall.common.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from t_user")
    List<User> queryAll();

    User queryLoginUser(User user);
}
