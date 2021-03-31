package com.nikki.boot.bean;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private String uname;
    private int age;
    private Pet pet;
    public User(String uname, int age) {
        this.uname = uname;
        this.age = age;
    }
}
