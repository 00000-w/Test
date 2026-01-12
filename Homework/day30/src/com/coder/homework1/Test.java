package com.coder.homework1;

public class Test {
    @Homework1(value = "小王")
    private String name;
    @Homework1(value = "19")
    private int age;

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
