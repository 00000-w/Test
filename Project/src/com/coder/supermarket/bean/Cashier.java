package com.coder.supermarket.bean;

import java.util.Objects;
import java.util.StringJoiner;

public class Cashier {
    //累加ID器
    private static int count = 0;

    private int id;
    private String account;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String phoneNumber;

    public Cashier(String account, String password, String name, String sex, int age, String address, String phoneNumber) {
        this.id = ++count;
        this.account = account;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Cashier() {
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner("\t\t", "\t" + id + "\t", "")
                .add(account)
                .add(password)
                .add(sex + "")
                .add(age + "岁")
                .add(name)
                .add(phoneNumber)
                .add(address)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return id == cashier.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //随机生成实例
    public static Cashier getRandom() {
        Cashier user = new Cashier(PersonInfoSource.account(), PersonInfoSource.password(), PersonInfoSource.randomChineseName(), PersonInfoSource.gender(), PersonInfoSource.age(), "暂定", "暂定");
        /*Cashier user = new Cashier();
        user.name = PersonInfoSource.randomChineseName();
        user.sex = PersonInfoSource.gender();
        user.age = PersonInfoSource.age();
        user.address = "待定";
        user.phoneNumber = "待定";
        user.account = PersonInfoSource.account();
        user.password = PersonInfoSource.password();*/
        return user;
    }
}
