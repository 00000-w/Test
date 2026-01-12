package com.coder.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {
        List<String> phoneNumbers = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            phoneNumbers.add(generatePhoneNumber());
        }
        List<String> drawNumbers = draw(phoneNumbers);
        System.out.println("中奖号码如下：");
        for (int i = 0; i < drawNumbers.size(); i++) {
            System.out.println(hideNumber(drawNumbers.get(i)));
        }
    }

    public static String generatePhoneNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append(secondNumber());
        for (int i = 0; i < 9; i++) {
            stringBuilder.append(restNumber());
        }
        return stringBuilder.toString();
    }

    public static int secondNumber() {
        int[] x = {3, 5, 7, 8, 9};
        int index = random.nextInt(x.length);
        return x[index];
    }

    public static int restNumber() {
        return random.nextInt(10);
    }

    public static List<String> draw(List<String> phoneNumbers) {
        int[] index = new int[4];
        index[0] = random.nextInt(phoneNumbers.size());
        index[1] = random.nextInt(phoneNumbers.size());
        index[2] = random.nextInt(phoneNumbers.size());
        index[3] = random.nextInt(phoneNumbers.size());
        List<String> drawPhoneNumber = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            drawPhoneNumber.add(phoneNumbers.get(index[i]));
        }
        return drawPhoneNumber;
    }

    public static String hideNumber(String number) {
/*        char[] n = new char[11];
        for (int i = 0; i < 11; i++) {
            n[i] = number.charAt(i);
        }
        for (int i = 3; i < 7; i++) {
            n[i] = '*';
        }
        return new String(n);*/
        //优化
        return number.substring(0, 3) + "****" + number.substring(7);
    }
}
