package com.coder.supermarket.service;

import com.coder.supermarket.bean.Cashier;
import com.coder.supermarket.bean.Log;
import com.coder.supermarket.db.DB;

import java.util.ArrayList;

public class CashierService {
    private static ArrayList<Cashier> cashiers = DB.db.get("cashierDB");

    public static Cashier login(String account, String password) {
        for (Cashier cashier : cashiers) {
            try {
                Thread.sleep(1000);
                System.out.println(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cashier.getAccount().equals(account) && cashier.getPassword().equals(password)) {
                LogService.log("尝试登录", "使用账号 " + account + " 使用密码" + password + "登录", true, Log.LogType.收银员登录日志, "账号密码正确");
                return  cashier;
            }
        }
        LogService.log("尝试登录", "使用账号 " + account + "使用密码" + password + "登录", false, Log.LogType.收银员登录日志, "账号密码验证错误");
        return null;
    }

    public static Cashier getById(int id) {
        for (Cashier cashier : cashiers) {
            if (cashier.getId() == id) {
                return cashier;
            }
        }
        return null;
    }

    public static ArrayList<Cashier> getAll() {
        LogService.log("查看所有", "查看所有收银员信息", true, Log.LogType.收银员管理模块日志, "无");
        return cashiers;
    }

    public static void add(Cashier cashier) {
        LogService.log("添加收银员", "添加1个收银员", true, Log.LogType.收银员管理模块日志, "无");
        cashiers.add(cashier);
    }

    public static void remove(int id) {
        Cashier cashier = new Cashier();
        cashier.setId(id);
        boolean remove = cashiers.remove(cashier);
        if (remove) {
            LogService.log("移除收银员", "移除1个收银员， 其ID为 " + id, true, Log.LogType.收银员管理模块日志, "无");
            System.out.println("移除成功");
        } else {
            System.out.println("移除失败");
            LogService.log("移除收银员", "尝试移除ID为 " + id + "的收银员", false, Log.LogType.收银员管理模块日志, "该ID的收银员不存在");
        }
    }
}
