package com.coder.supermarket.bean;

import java.util.Objects;

public class ProductType {
    private static int count = 0;

    private int id;
    private String name;

    public ProductType(String name) {
        this.id = ++count;
        this.name = name;
    }

    public ProductType() {
        this.id = ++count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ProductType.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
