package com.coder.supermarket.controller;

import com.coder.supermarket.controller.cashregistermodule.CashRegisterModule;
import com.coder.supermarket.controller.productmodule.ProductModule;
import com.coder.supermarket.controller.systemmodule.SystemModule;
import com.coder.supermarket.utils.InputUtils;

public class IndexController {
    public static void run() {
        System.out.println("\t\t\t~~~~~~~~~ xxx超市管理系统~~~~~~~~~");
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("1、收银模块\t\t2、商品模块\t\t3、系统模块\t\t4、退出系统");
            System.out.println("----------------------------------------------------------------");
            System.out.println("请选择模块：");

            int select = InputUtils.inputInt(1, 4);

            switch (select) {
                case 1:
                    CashRegisterModule.login();
                    break;
                case 2:
                    ProductModule.menu();
                    break;
                case 3:
                    SystemModule.menu();
                    break;
                case 4:
                    isEnd = true;
                    break;
            }
        }
    }
}
