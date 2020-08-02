package com.ww.service;

import com.ww.dao.UserMapper;
import com.ww.pojo.User;
import lombok.Data;

import java.util.List;


public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User checkUser(User user) {
        return userMapper.checkUser(user);
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
