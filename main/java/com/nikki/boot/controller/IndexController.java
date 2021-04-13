package com.nikki.boot.controller;

import com.nikki.boot.bean.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping(value = {"/login"})
    public String login(HttpSession session,Model model) {
        Object msg = session.getAttribute("msg");
        if(msg!=null)
            model.addAttribute("msg",msg);
        return "login";
    }

    @PostMapping("/login")
    public String index(Admin admin, HttpSession session, Model model){
        if(admin.getUserName().equals("nikki")&&admin.getPassword().equals("123456")){
            //保存登录成功的用户
            session.setAttribute("loginUser",admin);
            session.setMaxInactiveInterval(36000);
            //重定向到main
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账号或密码错误");
        return "login";
    }
    //重定向处理登陆成功
    //Model
    @GetMapping("/main.html")
    public String goTOMain(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null)
            return "main";
        model.addAttribute("msg","会话超时，请重新登录");
        return "login";
    }
}
