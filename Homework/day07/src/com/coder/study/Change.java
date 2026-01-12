package com.coder.study;

public class Change {
    public static void main(String[] args) {
        int x = 10;
        change(x);
        System.out.println(x);
    }
    public static int change(int x) {
        return x *= 10;
    }
}
