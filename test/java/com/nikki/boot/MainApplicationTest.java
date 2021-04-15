package com.nikki.boot;


import com.nikki.boot.bean.Line;
import com.nikki.boot.mapper.LineMapper;
import com.nikki.boot.service.LineService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.util.List;

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
    public void test(){
//        List<Line> all = lineMapper.getAll(0);
//        Line line = lineMapper.selectById(20);
//        log.info("lint:{}",line.toString());
        long begin = System.currentTimeMillis();
        List<Line> list = lineService.list();
        long end = System.currentTimeMillis();
        log.info("查询全表所用时间为:{}ms",end-begin);
    }


}
