package com.coder.supermarket.bean;

import com.coder.supermarket.service.CashierService;
import com.coder.supermarket.service.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Order {
    private static int count = 0;

    private int id;
    private int cashierId;
    private HashMap<Integer, Integer> products = null;
    private double totalPrice;
    private String dateTime;

    public Order(int id, int cashierId, HashMap<Integer, Integer> products, double totalPrice, String dateTime) {
        this.id = ++count;
        this.cashierId = cashierId;
        this.products = products;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

    public Order() {
        this.id = ++count;
    }

    public Order(int id, HashMap<Integer, Integer> products) {
        this.id = id;
        this.products = products;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        double totalPrice = 0;
        String product = "===================";
        Set<Map.Entry<Integer, Integer>> entries = products.entrySet();
        for (Map.Entry entry : entries) {
            Product p = ProductService.getById((Integer) entry.getKey());
            totalPrice += p.getPrice() * (Integer) entry.getValue();
            product += "\n\t" + p.getName() + "\t单价:" + p.getPrice() + "\t数量:" + entry.getValue() + "\t\t";
        }
        product += "\n=================== 商 品 列 表 ===================";
        this.totalPrice = totalPrice;

        return new StringJoiner("\t\t", "--------------" + id + "号订单-------------\n", "--------------" + id + "号订单-------------\n")
                .add("收银员:" + CashierService.getById(cashierId).getName())
                .add("\n=================== 商 品 列 表 " + product + "\n")
                .add("总价:" + this.totalPrice + "\t")
                .add("下单日期:" + dateTime + "\n")
                .toString();
    }
}
