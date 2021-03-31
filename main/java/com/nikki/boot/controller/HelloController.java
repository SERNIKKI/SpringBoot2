package com.nikki.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody 表示告诉浏览器直接返回的是内容而不是跳转到别的页面
//@Controller
@RestController //相当于ResponseBody和Controller
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello Spring Boot2";
    }
}
