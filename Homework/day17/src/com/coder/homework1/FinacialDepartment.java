package com.coder.homework1;

import java.util.List;

public class FinacialDepartment {
    private String department = "财务部门";

    public String getDepartment() {
        return department;
    }

    public int sumT(List<Employee> employees) {
        int sum = 0;
        for (Employee e : employees) {
            if (e.getId().startsWith("T")) {
                sum += e.getSalary();
            }
        }
        return sum;
    }

    public int sumC(List<Employee> employees) {
        int sum = 0;
        for (Employee e : employees) {
            if (e.getId().startsWith("C"))
                sum += e.getSalary();
        }
        return sum;
    }

    public int howMuchT(List<Employee> employees) {
        int t = 0;
        for (Employee e : employees) {
            if (e.getId().startsWith("T"))
                t++;
        }
        return t;
    }

    public int howMuchC(List<Employee> employees) {
        int c = 0;
        for (Employee e : employees) {
            if (e.getId().startsWith("C"))
                c++;
        }
        return c;
    }

    public double averageT(List<Employee> employees) {
        double average = sumT(employees) / howMuchT(employees);
        return average;
    }

    public double averageC(List<Employee> employees) {
        double average = sumC(employees) / howMuchC(employees);
        return average;
    }
}
