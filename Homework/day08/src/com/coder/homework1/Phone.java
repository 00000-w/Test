package com.coder.homework1;

//创建一个手机类，包括颜色、品牌、厂家、重量等属性
//具有打电话、发短信方法设计类的属性和方法
//将属性私有
//并提供公有的 getter 和 setter 方法
public class Phone {
    private String color;
    private String brand;
    private String factory;
    private String height;

    Phone() {
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setFactory(String factory) {
        this.factory = factory;
    }
    public void setHeight(String height) {
        this.height = height;
    }


    public String getColor() {
        return color;
    }
    public String getBrand() {
        return brand;
    }
    public String getFactory() {
        return factory;
    }
    public String getHeight() {
        return height;
    }


    public void call() {
        System.out.println("重量为" + height + "的" + color + brand + factory + "打电话");
    }
    public void send() {
        System.out.println("重量为" + height + "的" + color + brand + factory + "发短信");
    }
}
