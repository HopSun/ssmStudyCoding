package com.ww.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ww.pojo.User;
import com.ww.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class AjaxController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/loginA1",produces = "application/json;charset=utf-8")
    public String ajax(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String msg="";
        if(userService.queryUserByName(user.getUsername())!=null){
            msg="用户名被注册，请重新输入用户名！";

        }
        else{
            msg="用户名可以使用";
        }
        msg=mapper.writeValueAsString(msg);
        return msg;
    }
}
