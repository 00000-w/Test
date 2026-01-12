package com.coder.homework;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(6);
        employees.add(new Employee("Y1012", "李白", "男", 29, 12000, "研发部", LocalDate.of(2016, 10, 10)));
        employees.add(new Employee("C2404", "杜甫", "男", 28, 14000, "产品部", LocalDate.of(2017, 9, 5)));
        employees.add(new Employee("Y1035", "白居易", "男", 27, 11000, "研发部", LocalDate.of(2018, 5, 21)));
        employees.add(new Employee("Y1089", "李商隐", "男", 29, 15000, "研发部", LocalDate.of(2016, 3, 19)));
        employees.add(new Employee("C2675", "李清照", "女", 24, 8000, "产品部", LocalDate.of(2021, 7, 16)));
        employees.add(new Employee("X3021", "陆游", "男", 32, 18000, "项目部", LocalDate.of(2014, 12, 20)));

        productSalary(employees);
        isResearchAllMan(employees);
        printFilterResearch(employees);
        notProjectDepartment(employees);
        maxSalary(employees);
        minResearchAge(employees);
        getResearchFirstLetter(employees);
    }

    public static List<Employee> productDepartment(List<Employee> employees) {
        return employees.stream().filter(e -> "研发部".equals(e.getDepartment()))
                .collect(Collectors.toList());
    }

    public static void productSalary(List<Employee> employees) {
        boolean isOver10000 = productDepartment(employees).stream().filter(e -> "研发部".equals(e.getDepartment()))
                .allMatch(e -> e.getSalary() > 10000);
        if (isOver10000)
            System.out.println("产品部所有员工工资超过 10000 元");
        else
            System.out.println("并非所有产品部员工工资超过 10000 元");
    }

    public static List<Employee> researchDepartment(List<Employee> employees) {
        return employees.stream().filter(e -> "研发部".equals(e.getDepartment()))
                .collect(Collectors.toList());
    }

    public static void isResearchAllMan(List<Employee> employees) {
        boolean isAllMan = researchDepartment(employees).stream()
                .allMatch(e -> "男".equals(e.getGender()));
        if (isAllMan)
            System.out.println("研发部所有员工都是男性");
        else
            System.out.println("不是所有研发部员工都是男性");
    }

    public static void printFilterResearch(List<Employee> employees) {
        List<Employee> filterResearches = researchDepartment(employees).stream().filter(e -> e.getSalary() > 10000)
                .filter(e -> ChronoUnit.YEARS.between(e.getEnrollmentDate(), LocalDate.now()) >= 5)
                .collect(Collectors.toList());
        System.out.println("所有研发部工资超过 10000 元，入职 5 年(含)以上的员工信息如下:");
        filterResearches.forEach(System.out::println);
    }

    public static void notProjectDepartment(List<Employee> employees) {
        long projectCount = employees.stream().filter(e -> "项目部".equals(e.getDepartment())).count();
        long allCount = employees.size();
        System.out.println("不是项目部的员工数量为 " + (allCount - projectCount));
    }

    public static void maxSalary(List<Employee> employees) {
        Optional<Employee> max = employees.stream().filter(e -> ChronoUnit.YEARS.between(e.getEnrollmentDate(), LocalDate.now()) >= 5)
                .max(Comparator.comparing(Employee::getSalary));
        max.ifPresent(e -> System.out.println("入职五年以上的员工的最高薪资为 " + e.getSalary()));
    }

    public static void minResearchAge(List<Employee> employees) {
        Optional<Employee> ageMin = researchDepartment(employees).stream().min(Comparator.comparing(Employee::getAge));
        System.out.println("研发部年龄最小的员工信息如下:");
        System.out.println(ageMin);
    }
    public static void getResearchFirstLetter(List<Employee> employees) {
        researchDepartment(employees).stream().findFirst().ifPresent(employee -> {
            char first = employee.getId().charAt(0);
            System.out.println("研发部门编号开头字母为 " + first);
        } );
    }
}
