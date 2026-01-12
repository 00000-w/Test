package com.coder.homework1;

public class FinacialStaff extends Employee {
    FinacialStaff(String name, String position) {
        super(name, position);
    }
    FinacialStaff() {}

    public void settleVage(String name) {
        System.out.print(this.getPosition() + this.getName() + "为" + name + "结算本月工资");
        if (name.equals("白居易"))
            System.out.println(",18000元");
        if (name.equals("杜甫"))
            System.out.println(",10000元,因为导致客户使用软件出现损失，扣除测试人员 1000 元");
        if (name.equals("李商隐"))
            System.out.println(",7000元");
    }
}
