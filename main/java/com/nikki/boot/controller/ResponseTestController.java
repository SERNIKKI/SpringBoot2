package com.nikki.boot.controller;

import com.nikki.boot.bean.Person;
import com.nikki.boot.bean.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

//测试响应
@Controller
public class ResponseTestController {
    @ResponseBody
    @GetMapping("/test/person")
    public Person gerPerson(){
        Person person = new Person();
        person.setAge(18);
        person.setUserName("张三");
        person.setBirth(new Date());
        person.setPet(new Pet("瘦瘦","1"));
        return person;
    }
}
