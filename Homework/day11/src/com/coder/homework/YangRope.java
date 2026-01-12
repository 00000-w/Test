package com.coder.homework;

public class YangRope implements Rope {
    @Override
    public Person creatPerson() {
        return new Man();
    }
}
