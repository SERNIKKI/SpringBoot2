package com.nikki.boot.controller;

import com.nikki.boot.bean.Car;
import com.nikki.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody 表示告诉浏览器直接返回的是内容而不是跳转到别的页面
//@Controller
@Slf4j//注入日志类
@RestController //相当于ResponseBody和Controller
public class HelloController {

    @Autowired
    private Car car;
    @Autowired
    private Person person;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }
    @RequestMapping("/hello")
    public String handle01(){
        log.info("正在处理hello请求...");
        return "Hello Spring Boot2";
    }
    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
