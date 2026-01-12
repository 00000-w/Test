package com.coder.supermarket.bean;

import com.coder.supermarket.db.DB;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    private static int count = 0;

    private int id;
    private String name;
    private double price;
    private int typeId;

    public Product(String name, double price, int typeId) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
    }

    public Product() {
        this.id = ++count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");
        String productTypeName = null;
        for (ProductType productType : productTypes) {
            if (this.typeId == productType.getId()) {
                productTypeName = productType.getName();
            }
        }
        return new StringJoiner("\t ", "\t" + id + "\t\t", "")
                .add(name)
                .add("\t"+price + "￥")
                .add( "\t10个")
                .add("" + productTypeName)
                .toString();
    }
}
