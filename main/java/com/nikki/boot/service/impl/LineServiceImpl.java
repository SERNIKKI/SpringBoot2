package com.nikki.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nikki.boot.bean.Line;
import com.nikki.boot.mapper.LineMapper;
import com.nikki.boot.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImpl extends ServiceImpl<LineMapper,Line> implements LineService {
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
