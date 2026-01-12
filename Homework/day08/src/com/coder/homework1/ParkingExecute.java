package com.coder.homework1;

import java.util.Scanner;

//创建一个停车场收费系统，按照驶入和离开时间，以及车型进行收费
public class ParkingExecute {
    public static void main(String[] args) {
        System.out.println("请输入驶入时间（0-24）、离开时间（0-24）、车型（大 or 小）:");
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        int out = scanner.nextInt();
        int time = out - in;
        boolean b = time >= 1;
        boolean d = time <= 24;
        String type = scanner.next();
        if (!b || !d) {
            System.out.print("请确保您的驶入时间、离开时间填入正确\t");
            if (!type.equals("大") && !type.equals("小")) {
                System.out.println("请确保您输入的车型正确");
                return;
            }
            return;
        }
        if (!type.equals("大") && !type.equals("小")) {
            System.out.println("请确保您输入的车型正确");
            return;
        }
        Car car = new Car();
        car.charge(time, type);
    }
}
