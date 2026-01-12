package com.coder.homework1;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private String gender;
    private int age;
    private LocalDate hireDay;
    private double salary;
    private String workPlace;
    private String department;

    Employee() {}

    public Employee(String id, String name, String gender, int age, LocalDate hireDay, double salary, String workPlace) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hireDay = hireDay;
        this.salary = salary;
        this.workPlace = workPlace;
        this.department = whichDepartment(id);
    }

    public String whichDepartment(String id) {
        if (id.startsWith("T"))
            return "测试部门";
        else if (id.startsWith("C"))
            return "研发部门";
        else
            return "未知部分";
    }

    @Override
    public String toString() {
        return  "\nEmployee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", hireDay=" + hireDay +
                ", salary=" + salary +
                ", workPlace='" + workPlace + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
