package com.coder.homework2;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(10);
        employees.add(new Employee("T1032", "李白", "男", 25, LocalDate.of(2021, 12, 20), 10000, "吉林省长春市"));
        employees.add(new Employee("C1048", "杜甫", "女", 30, LocalDate.of(2017, 10, 10), 12000, "江苏省南京市"));
        employees.add(new Employee("C1052", "白居易", "男", 28, LocalDate.of(2019, 5, 22), 15000, "江苏省苏州市"));
        employees.add(new Employee("T1035", "李清照", "女", 31, LocalDate.of(2015, 4, 12), 14000, "吉林省吉林市"));
        employees.add(new Employee("C1066", "陆游", "男", 40, LocalDate.of(2009, 6, 15), 20000, "江苏省南京市"));
        employees.add(new Employee("C1088", "贺知章", "男", 35, LocalDate.of(2012, 3, 30), 16000, "上海市"));
        //测试薪水降序
        employees.add(new Employee("C1088", "贺知章", "男", 35, LocalDate.of(2012, 3, 30), 9000, "上海市"));

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getHireDay().compareTo(o2.getHireDay()) == 0) {
                    return Double.compare(o2.getSalary(), o1.getSalary());
                }
                return o1.getHireDay().compareTo(o2.getHireDay());
            }
        });

        employees = employees.subList(0, 3);
        for (Employee employee : employees)
            System.out.print(employee);

    }
}
