package com.ww.service;

import com.ww.pojo.User;

import java.util.List;

public interface UserService {
    User checkUser(User user);

    int addUser(User user);

    User queryUserByName(String username);
}
