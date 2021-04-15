package com.nikki.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nikki.boot.bean.Line;
import com.nikki.boot.mapper.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LineService extends IService<Line> {
    List<Line> getRhesisMapper(int id);
    int count();
    Line getByID(int id);
}
