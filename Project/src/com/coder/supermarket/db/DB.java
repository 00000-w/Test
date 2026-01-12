package com.coder.supermarket.db;

import com.coder.supermarket.bean.*;

import java.util.ArrayList;
import java.util.HashMap;

public class DB {
    public static HashMap<String, ArrayList> db = new HashMap<>();
    public static void init() {
        db.put("logDB", new ArrayList<Log>());
        db.put("cashierDB", new ArrayList<Cashier>());
        db.put("productDB", new ArrayList<Product>());
        db.put("productTypeDB", new ArrayList<ProductType>());
        db.put("orderDB", new ArrayList<Order>());
        db.put("loginCashier", new ArrayList<Cashier>());

        boolean containsNullKey = db.containsKey(null);
        System.out.println("Contains null key? " + containsNullKey);
        //随机生成5个收银员
        ArrayList<Cashier> cashiers = DB.db.get("cashierDB");
        for (int i = 0; i < 5; i++) {
            Cashier randomCashier = Cashier.getRandom();
            cashiers.add(randomCashier);
        }
        /*cashiers.add(Cashier.getRandom());
        cashiers.add(Cashier.getRandom());
        cashiers.add(Cashier.getRandom());
        cashiers.add(Cashier.getRandom());
        cashiers.add(Cashier.getRandom());*/
        //添加商品类型
        ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");
        productTypes.add(new ProductType("食品类"));
        productTypes.add(new ProductType("日用品类"));
        productTypes.add(new ProductType("文具类"));
        productTypes.add(new ProductType("水果类"));
        productTypes.add(new ProductType("饮料类"));
        productTypes.add(new ProductType("数码类"));
        //添加商品
        ArrayList<Product> products = DB.db.get("productDB");
        products.add(new Product("小米11", 5999.99, 6));
        products.add(new Product("康师傅冰红茶", 3.00, 5));
        products.add(new Product("新疆进口西瓜", 10.00, 4));
        products.add(new Product("中性笔", 1.00, 3));
        products.add(new Product("保温杯", 15.00, 2));
        products.add(new Product("康佳锅巴", 3.00, 1));
        ArrayList<Order> orders = DB.db.get("orderDB");
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1, 1);
        integerIntegerHashMap.put(2, 2);
        integerIntegerHashMap.put(3, 3);
        orders.add(new Order(1, integerIntegerHashMap));
    }
}
