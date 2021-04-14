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
    private String line_sentence;
    private String line_writer;
    private String line_book;
    private String input_time;
    private int cate;
    private int id;
}
