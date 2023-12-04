package cn.edu.hqu.ex2.model;

public class Course {
    private String name;

    // 构造函数
    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    // getters 和 setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}