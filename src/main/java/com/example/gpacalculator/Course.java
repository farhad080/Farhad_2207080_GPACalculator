package com.example.gpacalculator;

public class Course {
    public String name;
    public String code;
    public double credit;
    public String teacher1;
    public String teacher2;
    public String grade;

    public Course(String name, String code, double credit, String t1, String t2, String grade) {
        this.name = name;
        this.code = code;
        this.credit = credit;
        this.teacher1 = t1;
        this.teacher2 = t2;
        this.grade = grade;
    }
}
