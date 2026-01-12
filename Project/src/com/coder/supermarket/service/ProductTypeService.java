package com.coder.supermarket.service;

import com.coder.supermarket.bean.Log;
import com.coder.supermarket.bean.ProductType;
import com.coder.supermarket.db.DB;

import java.util.ArrayList;

public class ProductTypeService {
    private static ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");

    public static ArrayList<ProductType> getAll() {
        LogService.log("查找所有", "查看所有商品类型", true, Log.LogType.商品模块日志, "无");
        return productTypes;
    }

    public static void add(ProductType productType) {
        LogService.log("添加商品类型", "添加1个商品类型: " + productType.getName(), true, Log.LogType.商品模块日志, "无" );
        productTypes.add(productType);
    }

    public static void remove(int id) {
        ProductType productType = new ProductType();
        productType.setId(id);
        boolean remove = productTypes.remove(productType);
        if (remove) {
            System.out.println("移除成功");
            LogService.log("移除商品类型", "移除了ID为 " + id + "的商品类型", true, Log.LogType.商品模块日志, "无");
        } else {
            System.out.println("移除失败，该商品类型不存在!");
            LogService.log("移除商品类型", "尝试删除ID为 " + id + "的商品类型", false, Log.LogType.商品模块日志, "该ID的商品类型不存在");
        }
    }
}