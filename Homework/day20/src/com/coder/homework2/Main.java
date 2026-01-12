package com.coder.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        listPrint();
    }

    public static void listPrint() {
        System.out.println(listGenerate());
    }

    public static List<Integer> listGenerate() {
        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(supplier.get());
        }
        return list;
    }
}
