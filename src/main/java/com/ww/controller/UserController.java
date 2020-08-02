package com.ww.controller;

import com.ww.pojo.User;
import com.ww.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    //跳转到登陆页面
    @RequestMapping("/jumplogin")
    public String t(HttpSession session){

        return "login";
    }
    //跳转到成功页面
    @RequestMapping("/jumpSuccess")
    public String jumpSuccess() throws Exception {
        return "redirect:/book/allBook";
    }

    @RequestMapping("login")
    public String checkUser(HttpSession session,User user){

        if(session.getAttribute("username")!=null){
            session.removeAttribute("username");
        }
        if(userService.checkUser(user)!=null){
            session.setAttribute("username",user.getUsername());
        }
        return "redirect:/book/allBook";
    }
    //退出登陆
    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.invalidate();
        return "login";
    }

    /*@RequestMapping("/checkUserName")
    public String check(String username){

    }*/

    //注册一个用户
    @RequestMapping("/loginAdd")
    public String addUser(User user){
        userService.addUser(user);
        return "login";
    }

    @RequestMapping("/loginA")
    public String t1(HttpSession session){
        return "register";
    }


}
