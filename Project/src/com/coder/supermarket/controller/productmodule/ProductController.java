package com.coder.supermarket.controller.productmodule;

import com.coder.supermarket.bean.Product;
import com.coder.supermarket.bean.ProductType;
import com.coder.supermarket.service.ProductService;
import com.coder.supermarket.service.ProductTypeService;
import com.coder.supermarket.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
    public static void menu() {
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("--------------------------------------------商品管理模块--------------------------------------------");
            System.out.println("1、商品列表\t\t2、新增商品\t\t3、移除商品\t\t4、返回上一级");
            System.out.println("--------------------------------------------商品管理模块--------------------------------------------");
            System.out.println("请输入您的选择：");
            int select = InputUtils.inputInt(1,4);

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
    public static void remove() {
        printAll();
        System.out.println("请输入要移除的商品的ID：");
        int id = new Scanner(System.in).nextInt();
        ProductService.remove(id);
    }

    public static void printAll() {
        ArrayList<Product> all = ProductService.getAll();
        System.out.println("--------------------------------------------商品列表--------------------------------------------");
        System.out.println("\t编号\t\t名称\t\t\t\t价格\t\t数量\t\t所属类别");
        for (Product product : all)
            System.out.println(product);
        System.out.println("--------------------------------------------商品列表--------------------------------------------");
        System.out.println("共计" + all.size() + "条商品数据");
    }

    public static void add() {
        System.out.println("----------新增商品----------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名称：");
        String name = scanner.next();
        System.out.println("请输入商品价格：");
        Double price = scanner.nextDouble();

        ArrayList<ProductType> all = ProductTypeService.getAll();
        for (ProductType productType : all)
            System.out.println(productType);
        System.out.println("请输入商品类型编号：");
        int typeId = scanner.nextInt();
        Product product = new Product(name, price, typeId);
        ProductService.add(product);
        System.out.println("商品" + name + "添加成功");
    }
}
