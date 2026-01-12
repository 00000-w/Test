package com.coder.homework3;

public class Factory {
    public static Person personType(String type) {
        if ("男人".equals(type))
            return new Man();
        else if ("女人".equals(type))
            return new Woman();
        else
            return new Unknown();
    }
}
