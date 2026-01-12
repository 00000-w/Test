package com.coder.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>(6);
        list.add(new Employee("Y1012", "李白", "男", 29, 12000, "研发部", LocalDate.of(2016, 10, 10)));
        list.add(new Employee("C2404", "杜甫", "男", 28, 14000, "产品部", LocalDate.of(2017, 9, 5)));
        list.add(new Employee("Y1035", "白居易", "男", 27, 11000, "研发部", LocalDate.of(2018, 5, 21)));
        list.add(new Employee("Y1089", "李商隐", "男", 29, 15000, "研发部", LocalDate.of(2016, 3, 19)));
        list.add(new Employee("C2675", "李清照", "女", 24, 8000, "产品部", LocalDate.of(2021, 7, 16)));
        list.add(new Employee("X3021", "陆游", "男", 32, 18000, "项目部", LocalDate.of(2014, 12, 20)));

        departments(list);
        earliest(list);
        sumAndAverage(list);
        firstNameIsLee(list);
        ageThenSalarySort(list);
        enrollDayReverse(list);
        grouping(list);
        salaryAdd(list);
        order(list);
        nameString(list);
    }
    List<Employee> list = null;

    @BeforeEach
    public void init(){
        list = new ArrayList<>(6);
        list.add(new Employee("Y1012", "李白", "男", 29, 12000, "研发部", LocalDate.of(2016, 10, 10)));
        list.add(new Employee("C2404", "杜甫", "男", 28, 14000, "产品部", LocalDate.of(2017, 9, 5)));
        list.add(new Employee("Y1035", "白居易", "男", 27, 11000, "研发部", LocalDate.of(2018, 5, 21)));
        list.add(new Employee("Y1089", "李商隐", "男", 29, 15000, "研发部", LocalDate.of(2016, 3, 19)));
        list.add(new Employee("C2675", "李清照", "女", 24, 8000, "产品部", LocalDate.of(2021, 7, 16)));
        list.add(new Employee("X3021", "陆游", "男", 32, 18000, "项目部", LocalDate.of(2014, 12, 20)));
        System.out.println("Before each");
    }


    @Test
    public void test1(){
        departments(list);
    }

    @Test
    public void test2(){
        earliest(list);
    }

    @Test
    public void test3(){
        sumAndAverage(list);
    }

    public static void departments(List<Employee> list) {
        System.out.println(
                list.stream()
                        .map(Employee::getDepartment)
                        .distinct()
                        .collect(Collectors.joining(",", "公司设立的部门有：", ""))
        );

    }

    public static void earliest(List<Employee> list) {
        System.out.println("入职最早的员工信息为 ");
        Optional<Employee> min = list.stream()
                .min(Comparator.comparing(Employee::getEnrollmentDate));
        System.out.println(min);
    }

    public static void sumAndAverage(List<Employee> list) {
        int sum = list.stream()
                .filter(e -> "研发部".equals(e.getDepartment()))
                .mapToInt(Employee::getSalary)
                .sum();

        long count = list.stream()
                .filter(e -> "研发部".equals(e.getDepartment()))
                .count();

        System.out.println("研发部的总工资为 " + sum + "\t平均工资为 " + sum / count);
    }

    public static void firstNameIsLee(List<Employee> list) {
        long count = list.stream()
                .filter(e -> e.getName().startsWith("李"))
                .count();

        System.out.println("姓李的员工人数为 " + count);
    }

    public static void ageThenSalarySort(List<Employee> list) {
        System.out.println("根据年龄、薪资进行排序的员工信息如下：");
        list.stream()
                .sorted(Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);
    }

    public static void enrollDayReverse(List<Employee> list) {
        System.out.println("按入职日期降序排列得到的员工信息如下：");
        list.stream()
                .sorted(Comparator.comparing(Employee::getEnrollmentDate))
                .forEach(System.out::println);
    }

    public static void grouping(List<Employee> list) {
        Map<Integer, List<Employee>> collect = list.stream()
                .collect(Collectors.groupingBy(e -> e.getName().length()));
        System.out.println("姓名为2个字的员工：");
        collect.getOrDefault(2, new ArrayList<>()).forEach(System.out::println);
        System.out.println("姓名为3个字的员工：");
        collect.getOrDefault(3, new ArrayList<>()).forEach(System.out::println);
    }

    public static void salaryAdd(List<Employee> list) {
        list.stream()
                .filter(e -> e.getSalary() < 10000)
                .forEach(e -> e.setSalary(e.getSalary() + 1000));
        System.out.println("对工资未满10000元的员工加薪1000后员工信息更改为：");
        list.forEach(System.out::println);
    }

    public static void order(List<Employee> list) {
        System.out.println("按照员工编号开头字母顺序排序后的员工信息为");
        list.stream()
                .sorted(Comparator.comparing(Employee::getId))
                .forEach(System.out::println);
    }

    public static void nameString(List<Employee> list) {
        String[] strings = list.stream()
                .map(Employee::getName)
                .toArray(String[]::new);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
