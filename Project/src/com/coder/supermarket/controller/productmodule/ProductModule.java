package com.coder.supermarket.controller.productmodule;

import com.coder.supermarket.utils.InputUtils;

public class ProductModule {
    public static void menu() {
        System.out.println("-----------------商品模块----------------");
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("1、商品管理\t\t2、商品类型管理\t\t3、返回上级");
            System.out.println("-----------------商品模块----------------");
            System.out.println("请输入选择：");
            int select = InputUtils.inputInt(1, 3);
            switch (select) {
                case 1:
                    ProductController.menu();
                    break;
                case 2:
                    ProductTypeController.menu();
                    break;
                case 3:
                    isEnd = true;
                    return;
            }
        }
    }
}
