package com.coder.supermarket.controller.productmodule;

import com.coder.supermarket.bean.ProductType;
import com.coder.supermarket.service.ProductTypeService;
import com.coder.supermarket.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTypeController {
    public static void menu() {
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("------------------商品类型管理模块---------------");
            System.out.println("1、类型列表\t\t2、新增类型\t\t3、移除类型\t\t4、返回上一级");
            System.out.println("------------------商品类型管理模块---------------");
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

    public static void printAll() {
        ArrayList<ProductType> all = ProductTypeService.getAll();
        System.out.println("-------------------商品类型列表--------------------");
        System.out.println("\tID\t名称");
        for (ProductType productType : all)
            System.out.println(productType);
        System.out.println("-------------------商品类型列表--------------------");
        System.out.println("共计" + all.size() + "条商品类型数据");
    }


    public static void add() {
        System.out.println("--------------新增商品类型---------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品类型名称：");
        String name = scanner.next();
        ProductType productType = new ProductType(name);
        ProductTypeService.add(productType);
        System.out.println("已将" + name + "添加入商品类型中");
    }

    public static void remove() {
        printAll();
        System.out.println("请输入要移除类型的ID：");
        int id = new Scanner(System.in).nextInt();
        ProductTypeService.remove(id);
    }
}
