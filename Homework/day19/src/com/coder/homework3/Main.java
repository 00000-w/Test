package com.coder.homework3;

public class Main {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();

        while (!delivery.getProcess().isEmpty()) {
            System.out.print("当前状态: ");
            System.out.println(delivery.getCurrent());
            if (delivery.getProcess().size() == 1) {
                return;
            }
            System.out.println("执行业务--->");
            delivery.processNext();
        }
    }
}
