package com.nikki.boot.controller;

import com.nikki.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

//处理有关table页面的请求
@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(Model model){
        List<User> users = Arrays.asList(new User("zhangsan", 18), new User("lisi", 17),
                new User("wangwu", 20));
        model.addAttribute("users",users);
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(){
        return "table/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
