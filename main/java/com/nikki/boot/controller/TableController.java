package com.nikki.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nikki.boot.bean.Line;
import com.nikki.boot.bean.User;
import com.nikki.boot.exception.ManyUsersException;
import com.nikki.boot.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

//处理有关table页面的请求
@Controller
public class TableController {
    @Autowired
    LineService lineService;
    @GetMapping("/basic_table")
    public String basic_table(Model model){
        List<User> users = Arrays.asList(new User("zhangsan", 18), new User("lisi", 17),
                new User("wangwu", 20));
        model.addAttribute("users",users);
        if(users.size()>100)
            throw new ManyUsersException();
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "page",defaultValue = "1",required = false) Integer page,
                                @RequestParam(value = "limit",defaultValue = "10",required = false) Integer limit,
                                Model model){
        List<Line> list = lineService.getRhesisMapper(0);
        model.addAttribute("lines",list);
        //分页查询数据
//        Page<Line> linePage= new Page<>(page,limit);
//        Page<Line> page1 = lineService.page(linePage, null);
//        model.addAttribute("page",page1);
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
