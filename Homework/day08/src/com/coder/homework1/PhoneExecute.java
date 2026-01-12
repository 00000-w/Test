package com.coder.homework1;

public class PhoneExecute {
    //创建两个类的对象
    //创建一个黑色华为 Mate40 手机，重量为 200g，调用打电话方法
    //创建一个白色荣耀 v70 手机，重量为 189g，调用发短信方法
    public static void main(String[] args) {
        Phone phoneMate40 = new Phone();
        phoneMate40.setBrand("华为");
        phoneMate40.setFactory("Mate40");
        phoneMate40.setColor("黑色");
        phoneMate40.setHeight("200g");
        phoneMate40.call();

        Phone phoneV70 = new Phone();
        phoneV70.setFactory("V70");
        phoneV70.setBrand("荣耀");
        phoneV70.setColor("白色");
        phoneV70.setHeight("189g");
        phoneV70.send();
    }
}
