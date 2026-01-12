package com.coder.homework3;

import java.io.DataOutputStream;
import java.io.IOException;

public class Teacher {
    private String name;
    private int age;

    public  Teacher() {}

    public  Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void teacherInformation(DataOutputStream dos) throws IOException {
        dos.writeUTF(name);
        dos.writeInt(age);
    }
}
