package com.coder.homework1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(10);
        employees.add(new Employee("T1032", "李白", "男", 25, LocalDate.of(2021, 12, 20), 10000, "吉林省长春市"));
        employees.add(new Employee("C1048", "杜甫", "女", 30, LocalDate.of(2017, 10, 10), 12000, "江苏省南京市"));
        employees.add(new Employee("C1052", "白居易", "男", 28, LocalDate.of(2019, 5, 22), 15000, "江苏省苏州市"));
        employees.add(new Employee("T1035", "李清照", "女", 31, LocalDate.of(2015, 4, 12), 14000, "吉林省吉林市"));
        employees.add(new Employee("C1066", "陆游", "男", 40, LocalDate.of(2009, 6, 15), 20000, "江苏省南京市"));
        employees.add(new Employee("C1088", "贺知章", "男", 35, LocalDate.of(2012, 3, 30), 16000, "上海市"));

        FinacialDepartment finacialDepartment = new FinacialDepartment();
        HrDepartment hrDepartment = new HrDepartment();
        System.out.println("按" + finacialDepartment.getDepartment() + "要求统计得" + "测试部门的总工资为 " + finacialDepartment.sumT(employees) + " 元" + "，平均工资为 " + finacialDepartment.averageT(employees) + " 元");
        System.out.println("按" + finacialDepartment.getDepartment() + "要求统计得" + "研发部门的总工资为 " + finacialDepartment.sumC(employees) + " 元" + "，平均工资为 " + finacialDepartment.averageC(employees) + " 元");
        System.out.println(hrDepartment.getDepartment() + "撤销上海市办公地点，剩下的员工信息如下\n " + leftWorkers(employees).toString());
        System.out.println(hrDepartment.getDepartment() + "调整工作时长超70个月的员工薪资，员工信息更改为如下\n" + workersNewInformation(employees));

    }

    public static List<Employee> leftWorkers(List<Employee> employees) {
       HrDepartment hrDepartment = new HrDepartment();
       hrDepartment.dissolution(employees);
       return employees;
    }

    public static String workersNewInformation(List<Employee> employees) {
        HrDepartment hrDepartment = new HrDepartment();
        hrDepartment.salaryAdjustment(leftWorkers(employees));
        return employees.toString();
    }
}

