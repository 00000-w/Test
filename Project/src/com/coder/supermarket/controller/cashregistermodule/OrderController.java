package com.coder.supermarket.controller.cashregistermodule;

import com.coder.supermarket.bean.Cashier;
import com.coder.supermarket.bean.Order;
import com.coder.supermarket.controller.productmodule.ProductController;
import com.coder.supermarket.db.DB;
import com.coder.supermarket.service.OrderService;
import com.coder.supermarket.utils.InputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OrderController {
    public static void printAll() {
        ArrayList<Order> all = OrderService.getAll();
        System.out.println("-------------------------订单列表-------------------------");
        for (Order order : all)
            System.out.println(order);
        System.out.println("-------------------------订单列表-------------------------");
        System.out.println("\t共计" + all.size() + "条订单");
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        ProductController.printAll();
        while (true) {
            System.out.println("请输入想购买的商品编号：");
            int productId = scanner.nextInt();
            System.out.println("请输入购买数量：");
            int count = scanner.nextInt();
            map.put(productId, count);
            System.out.println("是否继续？(y/n)：");
            if (!InputUtils.inputBoolean())
                break;
        }

        ArrayList<Cashier> arrayList = DB.db.get("loginCashier");
        Cashier cashier = arrayList.get(0);
        Order order = new Order(cashier.getId(), map);
        System.out.println("下单成功，您的购物车如下：");
        System.out.println(order);

        System.out.println("请付款");
        System.out.println("模拟付款....");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("付款成功");
        OrderService.add(order);
    }

    public static void find() {
        System.out.println("请输入您要查找的订单的编号");
        int id = new Scanner(System.in).nextInt();
        Order order = OrderService.getByld(id);
        if (order != null) {
            System.out.println("订单信息如下：");
            System.out.println(order);
        } else
            System.out.println("订单不存在");
    }
}
