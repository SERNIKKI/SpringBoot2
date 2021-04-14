package com.nikki.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nikki.boot.bean.Line;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LineMapper extends BaseMapper<Line> {
    //select * from a where id > 0 order by id limit 10000;
    @Select("SELECT * FROM line WHERE id > #{begin} order by id limit 500")
    List<Line> getAll(int id);

    @Select("SELECT COUNT(*) FROM line")
    int count();
}
