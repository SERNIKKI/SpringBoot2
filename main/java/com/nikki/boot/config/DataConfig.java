package com.nikki.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;

@Deprecated
//@Configuration
public class DataConfig {
    /**
     * 数据库相关配置
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("${url}");
        dataSource.setUsername("${username}");
        dataSource.setPassword("${password}");
        dataSource.setFilters("stat,wall");
        return dataSource;
    }
    //Druid的监控页配置
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServlet = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        statViewServletServlet.addInitParameter("loginUsername","admin");
        statViewServletServlet.addInitParameter("loginPassword","admin0602");
        return statViewServletServlet;
    }
    //防火墙配置
    @Bean
    public FilterRegistrationBean<Filter> webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<Filter> filterFilter = new FilterRegistrationBean<>(webStatFilter);
        filterFilter.setUrlPatterns(Collections.singletonList("/*"));
        filterFilter.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterFilter.addInitParameter("profileEnable","true");
        return filterFilter;
    }
    //配置_Druid和Spring关联监控配置
    @Bean
    public DruidStatInterceptor getDruidStatInterceptor(){
        return new DruidStatInterceptor();
    }
    @Bean
    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut(DruidStatInterceptor druidStatInterceptor){
        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        jdkRegexpMethodPointcut.setPatterns("com.nikki.boot.*");
        return jdkRegexpMethodPointcut;
    }
}
