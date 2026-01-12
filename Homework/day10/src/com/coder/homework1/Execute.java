package com.coder.homework1;

public class Execute {
    public static void main(String[] args) {
        PersonnelManager personnelManager = new PersonnelManager("李白", "人事主管");
        Programmer programmer = new Programmer("杜甫", "程序员");
        TestPersonnel testPersonnel = new TestPersonnel("白居易", "测试人员");
        ArtStaff artStaff = new ArtStaff("李商隐", "美工人员");
        FinacialStaff finacialStaff = new FinacialStaff("李清照", "财会");

        Employee[] employees = new Employee[4];
        employees[0] = personnelManager;
        employees[1] = programmer;
        employees[2] = testPersonnel;
        employees[3] = artStaff;

        for (int i = 1; i < employees.length; i++) {
            personnelManager.expel(employees[i]);
            finacialStaff.settleVage(employees[i].getName());
        }
    }
}
