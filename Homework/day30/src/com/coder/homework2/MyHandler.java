package com.coder.homework2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

public class MyHandler implements InvocationHandler {
    private Object target;
    static boolean isLoggedIn = false;

    public MyHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        isLoggedIn = login();
        if (!isLoggedIn) {
            System.out.println("登陆失败，跳过");
            return null;
        }
        Object result = method.invoke(target, args);

        if (target instanceof FinancialManagement) {
            FinancialManagement fm = (FinancialManagement) target;
            String logMessage = String.format(
                    "用户: %s, 时间: %s, 方法: %s, 类名: %s",
                    fm.userName(),
                    fm.systemTime(),
                    method.getName(),
                    target.getClass().getName()
            );
            System.out.println("[财务日志] " + logMessage);
        }
        return result;
    }
    private boolean login() {
        System.out.println("请输入账户：");
        Scanner scanner = new Scanner(System.in);
        String userName, password;
        userName = scanner.nextLine();
        System.out.println("请输入密码：");
        password = scanner.nextLine();
        String[] login = {userName, password};
        Class<?> clazz = User.class;
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Login annotation = fields[i].getDeclaredAnnotation(Login.class);
            String value = annotation.value();
            if (!Objects.equals(login[i], value)) {
                System.out.println("登录失败");
                break;
            } else {
                System.out.println("登录成功");
                isLoggedIn = true;
                break;
            }
        }
        return isLoggedIn;
    }

}
