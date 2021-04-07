package com.nikki.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller //用于页面跳转
@RestController
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功");
        request.setAttribute("code",200);
        return "forward:/success"; //跳转到/success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String,Object> success(@RequestAttribute("msg") String msg,
                                      @RequestAttribute("code") String code,
                                      HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        map.put("msg",msg);
        map.put("code",code);
        map.put("msg1",msg1);
        map.put("code1",code1);
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
}
