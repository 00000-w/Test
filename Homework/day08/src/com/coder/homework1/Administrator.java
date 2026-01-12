package com.coder.homework1;
//创建一个网管类
public class Administrator {
    String name;

    Administrator() {
        name = "白居易";
    }

    public void check(Student student) {
        System.out.println("经网管" + name + "确认后" + student.name + (student.age > 18 ? "可上网" : "不可上网"));
    }
}
