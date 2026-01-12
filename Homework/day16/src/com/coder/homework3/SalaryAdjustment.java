package com.coder.homework3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SalaryAdjustment {
    public static void main(String[] args) {
        SalaryAdjustment adjustment = new SalaryAdjustment();
        Employee[] employees = {
            new Employee("李白", LocalDate.of(2018, 2, 4), 8000),
            new Employee("杜甫", LocalDate.of(2012, 5, 6), 12000),
            new Employee("白居易", LocalDate.of(2014, 4, 10), 10000),
            new Employee("陆游", LocalDate.of(2016, 10, 11), 9000),
        };

        for (Employee employee : employees) {
            if (adjustment.months(employee.getHireDay()) > 100)
                employee.setSalary(employee.getSalary() + 1000);
        }

        for (Employee e : employees) {
            System.out.println("调整后" + e.getHireDay() + "入职的" + e.getName() + "的" + "薪水为 " + e.getSalary() + " 元");
        }
    }

    public long months(LocalDate date) {
        return ChronoUnit.MONTHS.between(date, LocalDate.now());
    }
}
