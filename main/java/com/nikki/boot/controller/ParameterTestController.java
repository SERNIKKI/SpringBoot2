package com.nikki.boot.controller;

import com.nikki.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    //PathVariable路径变量注解
    //RequestHeader获取请求头
    //RequestParam获取请求参数
    //CookieValue获取cookie的值
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getUser(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String,String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String,String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String,String> params){
//        @CookieValue("_ga") String _ga,
//        @CookieValue("_ga") Cookie cookie
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",name);
        map.put("pv",pv);
        map.put("User-Agent",userAgent);
        map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
//        map.put("_ga",_ga);
//        map.put("cookie",cookie.getValue());
        return map;
    }

    //RequestBody获取请求数据
    @PostMapping("/save")
    public Map<String,Object> postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    //MatrixVariable获取矩阵变量中的值
    // 语法:/cars/sell;low=20;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public  Map<String,Object> carsSell(@MatrixVariable(value = "low",pathVar = "path") Integer low,
                                        @MatrixVariable(value = "brand",pathVar = "path") List<String> brand,
                                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
    //测试自动封装POJO
    //页面提交的属性(GET、POST都可以和对象属性进行绑定)
    @PostMapping("/saveUser")
    public Person saveUser(Person person){
        return person;
    }
}