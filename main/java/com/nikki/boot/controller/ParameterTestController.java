package com.nikki.boot.controller;

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
}
