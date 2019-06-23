package com.itheima.web.controller;

import com.itheima.domain.User;
import com.itheima.domain.Userlogin;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录功能
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpSession session,String username,String password,String verifycode,Model model){
        String checkcode = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (verifycode == null || verifycode == "" || !verifycode.equalsIgnoreCase(checkcode)){
            model.addAttribute("errorMsg","验证码不正确,请重新输入...");
            return "login";
        }
        //验证码正确,验证用户名和密码
        Userlogin userlogin = userService.login(username, password);
        if (userlogin == null){
            model.addAttribute("errorMsg","用户名或密码不正确,请重新输入...");
            return "login";
        }
        //用户名密码正确,跳转index页面
        session.setAttribute("logined",userlogin);
        return "index";
    }

    /**
     * 查询所有用户功能
     * @param model
     * @return
     */
    @RequestMapping("/all")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
}
