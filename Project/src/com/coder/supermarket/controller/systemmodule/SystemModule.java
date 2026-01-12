package com.coder.supermarket.controller.systemmodule;

import com.coder.supermarket.utils.InputUtils;

public class SystemModule {
    public static void menu() {
        while (true) {
            System.out.println("-----------------系统管理----------------");
            System.out.println("1、收银员管理\t\t2、日志管理\t\t3、返回上级");
            System.out.println("-----------------系统管理----------------");
            System.out.println("请输入选择：");
            int select = InputUtils.inputInt(1, 3);
            switch (select) {
                case 1:
                    CashierController.menu();
                    break;
                case 2:
                    LogController.menu();
                    break;
                case 3:
                    return;
            }
        }
    }
}
