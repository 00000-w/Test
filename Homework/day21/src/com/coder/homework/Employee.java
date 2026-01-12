package com.coder.homework;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private String gender;
    private int age;
    private int salary;
    private String department;
    private LocalDate enrollmentDate;

    Employee(String id, String name, String gender, int age, int salary, String department, LocalDate enrollmentDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.enrollmentDate = enrollmentDate;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }
}
