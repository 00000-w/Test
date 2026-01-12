package com.coder.homework1;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        register();
    }

    @Test
    public void test1() {
        register();
    }

    public static void register() {
        System.out.println("用户名：");
        String userName = scanner.next();
        System.out.println("密码：");
        String password = scanner.next();

        File users = new File("D:/users/" + userName);
        File parentFile = users.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            System.out.println("注册失败，无法创建目录");
            return;
        }
        if (users.exists())
            System.out.println("注册失败，用户已存在");
        else {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(users))) {
                oos.writeObject(user);
                System.out.println("注册成功");
            } catch (IOException e) {
                System.out.println("注册失败" + e.getMessage());
            }
        }
    }

    @Test
    public void test2() {
        login();
    }

    public static void login() {
        System.out.println("用户名：");
        String loginUserName = scanner.next();
        System.out.println("密码：");
        String loginPassword = scanner.next();
        File user = new File("d:/users/" + loginUserName);
        if (!user.exists()) {
            System.out.println("用户不存在");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(user))) {
            User loginUser = (User) ois.readObject();
            if (loginUser.getPassword().equals(loginPassword)) {
                System.out.println("登录成功");
            } else {
                System.out.println("密码错误");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("登陆失败" + e.getMessage());
        }
    }

}
