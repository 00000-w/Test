package com.coder.supermarket.controller.systemmodule;

import com.coder.supermarket.bean.Log;
import com.coder.supermarket.service.LogService;

import java.util.List;

public class LogController {
    public static void menu() {
        printAll();
    }

    public static void printAll() {
        System.out.println("----------------------日志记录--------------------------");
        List<Log> all = LogService.getAll();
        all.stream().forEach(System.out::println);
        System.out.println("----------------------日志记录--------------------------");
        System.out.println("共计" + all.size() + "条日志记录数据");
    }
}
