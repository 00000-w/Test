package com.coder.homework;

public class YinRope implements Rope {
    @Override
    public Person creatPerson() {
        return new Woman();
    }
}
