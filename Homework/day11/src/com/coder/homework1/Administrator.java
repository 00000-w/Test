package com.coder.homework1;

public class Administrator {
    private String name;

    Administrator(String name) {
        this.name = name;
    }
    Administrator() {}

    public void checkCard(Student student) {
        System.out.println("管理员" + name + "检查了" + student.getName() + "的借书证");
    }
}
