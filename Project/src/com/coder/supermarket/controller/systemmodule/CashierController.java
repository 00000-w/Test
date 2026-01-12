package com.coder.supermarket.controller.systemmodule;

import com.coder.supermarket.bean.Cashier;
import com.coder.supermarket.service.CashierService;
import com.coder.supermarket.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class CashierController {
    public static void menu() {
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("---------------------收银员管理模块-----------------------");
            System.out.println("1、收银员列表\t\t2、新增收银员\t\t3、移除收银员\t\t4.返回上一级");
            System.out.println("---------------------收银员管理模块-----------------------");
            System.out.println("请输入选择：");
            int select = InputUtils.inputInt(1, 4);
            switch (select) {
                case 1:
                    printAll();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    isEnd = true;
                    break;
            }
        }
    }

    public static void add() {
        System.out.println("----------------------新增收银员------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号：");
        String account = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入性别：");
        String sex = scanner.next();
        System.out.println("请输入年龄：");
        int age = InputUtils.inputInt(18, 50);
        System.out.println("请输入家庭住址：");
        String address = scanner.next();
        System.out.println("请输入手机号：");
        String phoneNumber = scanner.next();
        Cashier cashier = new Cashier(account, password, name, sex, age, address, phoneNumber);
        CashierService.add(cashier);
        System.out.println("添加成功！");
    }

    public static void remove() {
        System.out.println("请输入要移除的收银员的ID：");
        int id = new Scanner(System.in).nextInt();
        CashierService.remove(id);
    }

    public static void printAll() {
        ArrayList<Cashier> all = CashierService.getAll();
        System.out.println("-------------------收银员列表---------------------");
        System.out.println("\tID\t账号\t\t\t\t密码\t\t\t\t性别\t\t年龄\t\t姓名\t\t联系方式\t\t\t\t地址");
        for (Cashier cashier : all)
            System.out.println(cashier);
        System.out.println("-------------------收银员列表---------------------");
        System.out.println("共计" + all.size() + "条收银员数据");
    }
}
