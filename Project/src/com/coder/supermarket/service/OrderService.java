package com.coder.supermarket.service;

import com.coder.supermarket.bean.Log;
import com.coder.supermarket.bean.Order;
import com.coder.supermarket.db.DB;

import java.util.ArrayList;

public class OrderService {
    private static ArrayList<Order> orders = DB.db.get("orderDB");
    public static ArrayList<Order> getAll() {
        LogService.log("查找所有", "查看了所有的订单", true, Log.LogType.收银员管理模块日志, "无");
        return orders;
    }
    public static void add(Order order) {
        LogService.log("下单", "添加了一个订单, 订单ID为" + order.getId(), true, Log.LogType.商品模块日志, "无");
                orders.add(order);
    }
    public static Order getByld(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                LogService.log("查询订单", "查询到1个订单，ID为" + id, true, Log.LogType.商品模块日志, "无");
                return order;
            }
        }
        return null;
    }
}


