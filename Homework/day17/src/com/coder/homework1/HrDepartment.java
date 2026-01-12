package com.coder.homework1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class HrDepartment {
    private String department = "人事部门";

    public String getDepartment() {
        return department;
    }

    public void dissolution(List<Employee> employees) {
        employees.removeIf(employee -> employee.getWorkPlace().contains("上海"));
    }

    public void salaryAdjustment(List<Employee> employees) {
        LocalDate localDate = LocalDate.now();
        for (Employee e : employees) {
            if (ChronoUnit.MONTHS.between(e.getHireDay(), localDate) > 70)
                e.setSalary(Math.round(e.getSalary() * 1.1));
        }
    }
}
