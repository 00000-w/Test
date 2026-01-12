package com.coder.supermarket.controller.cashregistermodule;

import com.coder.supermarket.bean.Cashier;
import com.coder.supermarket.db.DB;
import com.coder.supermarket.service.CashierService;
import com.coder.supermarket.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class CashRegisterModule {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        Cashier cashier = null;
        while (true) {
            System.out.println("请输入您的收银员账号：");
            String account = scanner.next();
            System.out.println("请输入您的收银员密码：");
            String password = scanner.next();
            System.out.println("登录中....");
            cashier = CashierService.login(account, password);
            if (cashier != null)
                break;
            System.out.println("账号或密码输入错误，请重新输入");
        }
        ArrayList<Cashier> cashiers = new ArrayList<>();
        cashiers.add(cashier);
        System.out.println("用户" + cashier.getName() + "成功登录");
        DB.db.put("loginCashier", cashiers);
        menu();
    }
    public static void menu() {
        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("--------------收银模块--------------");
            System.out.println("1、新增订单\t\t2、订单列表\t\t3、查找订单\t\t4、返回上一级");
            System.out.println("请选择模块：");
            int select = InputUtils.inputInt(1, 4);

            switch (select) {
                case 1:
                    OrderController.add();
                    break;
                case 2:
                    OrderController.printAll();
                    break;
                case 3:
                    OrderController.find();
                    break;
                case 4:
                    return;
            }
        }
    }
}
