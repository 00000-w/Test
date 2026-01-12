package com.coder.homework;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String gender;
    private String department;
    private String id;
    private int age;
    private int salary;
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

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
    
    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }
}
