package com.coder.homework1;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        //BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        System.out.println(add.apply(11, 536));
        //BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> multiply = Math::multiplyExact;
        System.out.println(multiply.apply(23, 5646));

    }
}
