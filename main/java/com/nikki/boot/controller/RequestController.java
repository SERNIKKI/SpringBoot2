package com.nikki.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller //用于页面跳转
//@RestController
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功");
        request.setAttribute("code",200);
        return "forward:/success"; //跳转到/success请求
    }

    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("Hello","World666");
        model.addAttribute("World","Hello666");
        request.setAttribute("message","Hello World");
        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String,Object> success(@RequestAttribute(value = "msg",required = false) String msg,
                                      @RequestAttribute(value = "code",required = false) String code,
                                      HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        Object hello = request.getAttribute("Hello");
        Object world = request.getAttribute("World");
        Object message = request.getAttribute("message");
        map.put("msg",msg);
        map.put("code",code);
        map.put("msg1",msg1);
        map.put("code1",code1);
        map.put("hello",hello);
        map.put("world",world);
        map.put("message",message);
        return map;
    }
}
