package com.coder.homework2;

public class Student {
    private String name;
    private int chinese;
    private int math;
    private int english;
    private int geography;

    Student(String name, int chinese, int math, int english, int geography) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.geography = geography;
    }

    public String getName() {
        return name;
    }

    public int allScoreSum() {
        return chinese + math + english + geography;
    }

    public double average() {
        return allScoreSum() * 1.0 / 4;
    }

    public int getChinese() {
        return chinese;
    }

    public int getMath() {
        return math;
    }

    public int getEnglish() {
        return english;
    }

    public int getGeography() {
        return geography;
    }

    @Override
    public String toString() {
        return "\n Student{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", geography=" + geography +
                '}';
    }
}
