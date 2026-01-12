package com.coder.homework3;

import java.util.LinkedList;
import java.util.Queue;

public class Delivery {
    private final Queue<String> process;
    private String current;

    public Delivery() {
        process = new LinkedList<>();
        process.add("货品已出库");
        process.add("上门收取快递");
        process.add("送到快递分包中心");
        process.add("货物运输途中");
        process.add("货物已由快递员送货到小区分配中心");
        process.add("货物已被取走");
        current = process.element();
    }

    public Queue<String> getProcess() {
        return process;
    }

    public void processNext() {
        process.poll();
        current = process.peek();
    }

    public String getCurrent() {
        return current;
    }

}
