package com.coder.homework3;

import java.time.LocalDate;

public class Employee {
    private String name;
    private LocalDate hireDay;
    private int salary;

    Employee() {}

    Employee(String name, LocalDate hireDay, int salary) {
        this.name = name;
        this.hireDay = hireDay;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
