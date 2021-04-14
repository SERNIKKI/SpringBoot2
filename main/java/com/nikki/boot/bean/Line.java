package com.nikki.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Line {
    private String sentence;
    private String writer;
    private String book;
    private String time;
    private int cate;
    private int id;
}
