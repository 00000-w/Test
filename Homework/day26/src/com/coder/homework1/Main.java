package com.coder.homework1;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Thread studentThread = new Thread(student, "学生");
        Teacher teacher = new Teacher(studentThread);
        Thread teacherThread = new Thread(teacher, "老师");
        studentThread.start();
        teacherThread.start();
    }
}
