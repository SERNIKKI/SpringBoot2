package com.nikki.boot.controller;

import com.nikki.boot.bean.Car;
import com.nikki.boot.bean.Line;
import com.nikki.boot.bean.Person;
import com.nikki.boot.service.LineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ResponseBody 表示告诉浏览器直接返回的是内容而不是跳转到别的页面
//@Controller
@Slf4j//注入日志类
@RestController //相当于ResponseBody和Controller
public class HelloController {

    @Autowired
    private Car car;
    @Autowired
    private Person person;
//    @RequestMapping("/car")
//    public Car car(){
//        return car;
//    }
    @RequestMapping("/hello")
    public String handle01(){
        log.info("正在处理hello请求...");
        return "Hello Spring Boot2";
    }
    @Autowired
    LineService lineService;
    @RequestMapping(value = "/rhesis",produces = "application/json")
    @ResponseBody
    public List<Line> getAll(){
//        long begin = System.currentTimeMillis();
//        List<Line> lineList = lineService.getRhesisMapper(1);
//        long end = System.currentTimeMillis();
        List<Line> list = lineService.list();

//        log.info("全页面查询时间为:{}",end-begin);
        return list;
    }
    @RequestMapping("/person")
    public Person person(){
        return person;
    }

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-NIKKI";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-NIKKI";
    }
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT-NIKKI";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE-NIKKI";
    }
}
