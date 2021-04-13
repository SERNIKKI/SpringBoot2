package com.nikki.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.nikki.boot.bean.Car;
import com.nikki.boot.bean.Pet;
import com.nikki.boot.bean.User;
import com.nikki.boot.servletApi.MyFilter;
import com.nikki.boot.servletApi.MyServlet;
import com.nikki.boot.servletApi.MyServletContextListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//1.使用bean标签注册组件，默认为单实例
//2.配置类本身也是组件
//3.proxyBeanMethods代理bean的方法
//  Full(proxyBeanMethods = true):表示每个bean不管被调用多少次返回的都是单实例的
//  Lite(proxyBeanMethods = false):表示每个bean方法每次被调用都是新创建的
//  组件依赖必须是Full默认，其他为Lite模式
//4.@Import给容器中自动创建类型的组件,默认组件的名字为全类名
//5.@ImportResource(classpath:*)导入配置文件令其生效,为在resources中的文件
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true) //告诉SpringBot这是一个配置类
//@ConditionalOnBean(User.class)//当存在名字为pet的组件时，才在容器中注入user,加在类上面表示如果没有则类中所有bean都不注入
@ConditionalOnMissingBean(name = "pet")
@EnableConfigurationProperties(Car.class)//开启Car的属性配置功能，并把Car自动注入到容器中。可以不用@Component标签将car注入到容器中
public class MyConfig {

    @Bean("user")
    public User user(){
        return new User("张三",18,pet());
    }
    @Bean("pet")
    public Pet pet(){
        return new Pet("tomcat","8");
    }

    /**
     * 注入servlet、filter和listener
     */
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean<>(myServlet,"/test01");
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter(){
        MyFilter myFilter = new MyFilter();
        return new FilterRegistrationBean<>(myFilter,myServlet());
    }
    
    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean<>(myServletContextListener);
    }
}
