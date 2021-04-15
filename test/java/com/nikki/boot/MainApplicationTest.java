package com.nikki.boot;


import com.nikki.boot.bean.Line;
import com.nikki.boot.mapper.LineMapper;
import com.nikki.boot.service.LineService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * junit5注解含义
 * 1、DisplayName:为测试类或测试方法设置一个名称
 * 2、BeforeEach：在每个测试方法之前执行
 * 3、AfterEach:在每个测试方法之后执行
 * 4、BeforeAll:在所有测试开始之前执行
 * 5、AfterAll:在所有测试开始之后执行
 * 6、Tag:表示单元测试类别，类似于JUnit4中的@Categories
 * 7、Disabled:表示测试类或测试方法不执行，类似于JUnit4中的@Ignore
 * 8、Timeout:表示测试方法运行如果超过了指定时间将会返回错误
 * 9、ExtendWith:为测试类或测试方法提供扩展类引用
 */
@Slf4j
@SpringBootTest
public class MainApplicationTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    LineMapper lineMapper;
    @Autowired
    LineService lineService;
    @Test
    @Timeout(value = 5,unit = TimeUnit.SECONDS)
    public void test(){
//        List<Line> all = lineMapper.getAll(0);
//        Line line = lineMapper.selectById(20);
//        log.info("lint:{}",line.toString());
        long begin = System.currentTimeMillis();
        List<Line> list = lineService.list();
        long end = System.currentTimeMillis();
        log.info("查询全表所用时间为:{}ms",end-begin);
    }



    @Test
    @DisplayName("测试DisplayName")
    void testDisplayName(){
        System.out.println(1);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试开始执行...");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试执行结束...");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试开始之前执行...");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试开始之后执行...");
    }
}
