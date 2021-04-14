package com.nikki.boot.service;

import com.nikki.boot.bean.Line;
import com.nikki.boot.mapper.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService {
    @Autowired
    LineMapper rhesisMapper;
    public List<Line> getRhesisMapper(int id) {
        id = id * 500;
        return rhesisMapper.getAll(id);
    }
    public int count(){
        return rhesisMapper.count();
    }

    public Line getByID(int id){
        return rhesisMapper.selectById(id);
    }
}
