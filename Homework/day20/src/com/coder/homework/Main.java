package com.coder.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, Integer, Student> studentGenerate = Student::new;
        Student student1 = studentGenerate.apply("张三", 23);
        Student student2 = studentGenerate.apply("李四", 25);
        Student student3 = studentGenerate.apply("王五", 22);

        List<Student> students = new ArrayList<>(3);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        students.sort(Comparator.comparing(Student::getAge));
        students.forEach(System.out::println);
        System.out.println(students);
    }
}
