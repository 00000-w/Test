package com.coder.supermarket.service;

import com.coder.supermarket.bean.Log;
import com.coder.supermarket.bean.Product;
import com.coder.supermarket.db.DB;

import java.util.ArrayList;

public class ProductService {
    private static ArrayList<Product> products = DB.db.get("productDB");

    public static ArrayList<Product> getAll() {
        LogService.log("查找所有", "查看所有商品", true, Log.LogType.商品模块日志, "无");
        return products;
    }

    public static void add(Product product) {
        LogService.log("添加商品", "添加1个商品: " + product.getName(), true, Log.LogType.商品模块日志, "无");
        products.add(product);
    }

    public static void remove(int id) {
        Product product = new Product();
        product.setId(id);
        boolean remove = products.remove(product);
        if (remove) {
            System.out.println("移除商品成功");
            LogService.log("移除商品", "移除了ID为 " + id + "的商品", true, Log.LogType.商品模块日志, "无");
        } else {
            System.out.println("移除失败，商品不存在");
            LogService.log("移除商品", "尝试移除ID为 " + id + "的商品", false, Log.LogType.商品模块日志, "该ID商品不存在");
        }
    }

    public static Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }
}
