package com.nikki.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
//@TableName //指明映射的是那张表
//@TableField(exist = false) //用在属性上表示当前属性在表中不存在
public class Line {
    private String sentence;
    private String writer;
    private String book;
    private String time;
    private int cate;
    private int id;
}
