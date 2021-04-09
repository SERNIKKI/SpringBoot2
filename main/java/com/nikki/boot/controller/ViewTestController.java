package com.nikki.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//测试视图
@Controller
public class ViewTestController {
    @GetMapping("/nikki")
    public String goToNIKKI(@RequestParam("msg") String msg,
                            @RequestParam("link") String link,
                            Model model){
        //model中的数据会被放在请求域中，相当于request.setAttribute;
        model.addAttribute("msg",msg);
        model.addAttribute("link",link);
        return "success";
    }
}
