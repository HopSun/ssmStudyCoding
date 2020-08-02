package com.ww.dao;

import com.ww.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询用户是否存在
    User checkUser(User user);

    int addUser(User user);
    User queryUserByName(String username);

}
