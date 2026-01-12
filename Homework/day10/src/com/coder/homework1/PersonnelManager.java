package com.coder.homework1;

public class PersonnelManager extends Employee {
    PersonnelManager(String name, String position) {
        super(name, position);
    }
    PersonnelManager() {}


    public void expel (Employee employee) {
        System.out.print ("人事主管" + super.getName() + "要开除" + employee.getPosition() + employee.getName());
        if (employee.getPosition().equals("程序员"))
            System.out.println("因为编码出现Bug,后来因为程序员比较难招聘，所以给" + employee.getName() + "一次机会");
        if (employee.getPosition().equals("测试人员"))
            System.out.println("因为bug未测试出来");
        if (employee.getPosition().equals("美工人员"))
            System.out.println("因为设计不合理");
    }
}
