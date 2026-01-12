package com.coder.homework;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class homework3 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>(2);
        Class<?> clazz = list.getClass();
        Method method = clazz.getMethod("add", Object.class);
        method.invoke(list, 0);
        method.invoke(list,999);
        System.out.println(list);
    }
}
