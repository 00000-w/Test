package com.coder.homework2;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        FinancialManagementImpl financialManagement = new FinancialManagementImpl();
        UserManagementImpl userManagement = new UserManagementImpl();

        FinancialManagement financialProxy = (FinancialManagement) Proxy.newProxyInstance(
                FinancialManagement.class.getClassLoader(),
                new Class[]{FinancialManagement.class},
                new MyHandler(financialManagement)
        );

        UserManagement userProxy = (UserManagement) Proxy.newProxyInstance(
                UserManagement.class.getClassLoader(),
                new Class[]{UserManagement.class},
                new MyHandler(userManagement)
        );
        System.out.println("=== 测试财务管理 ===");
        financialProxy.financialOperation();
        System.out.println("\n=== 测试用户管理 ===");
        userProxy.userManagement();

        // 测试登录失败情况
        System.out.println("\n=== 测试错误登录 ===");
        FinancialManagement anotherFinancialProxy = (FinancialManagement) Proxy.newProxyInstance(
                FinancialManagement.class.getClassLoader(),
                new Class[]{FinancialManagement.class},
                new MyHandler(new FinancialManagementImpl())
        );
        anotherFinancialProxy.financialOperation();
    }
}
