package com.nikki.boot;

import com.nikki.boot.bean.Pet;
import com.nikki.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//SpringBoot的核心
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan//默认为主配置文件所在的包
//@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器中的组件
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String name : beanDefinitionNames) {
//            System.out.println(name);
//        }

        boolean user = run.containsBean("user");
        System.out.println("是否存在user:" + user);
        boolean pet = run.containsBean("pet");
        System.out.println("是否存在pet:" + pet);
    }
}
