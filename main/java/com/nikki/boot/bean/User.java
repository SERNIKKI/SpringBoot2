package com.nikki.boot.bean;

public class User {
    private String uname;
    private int age;
    private Pet pet;
    public User() {
    }
    public User(String uname, int age) {
        this.uname = uname;
        this.age = age;
    }
    public User(String uname, int age, Pet pet) {
        this.uname = uname;
        this.age = age;
        this.pet = pet;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age='" + age + '\'' +
                ", pet=" + pet +
                '}';
    }
}
