package com.coder.homework1;

public class Execute {
    public static void main(String[] args) {
        Tiger tiger = new Tiger(1.5, 300);
        Tiger cloneTiger = tiger.clone();

        System.out.println("原老虎" + tiger);
        System.out.println("新老虎" + cloneTiger);
        System.out.println("能否通过上级检查？" + tiger.equals(cloneTiger));
    }
}
