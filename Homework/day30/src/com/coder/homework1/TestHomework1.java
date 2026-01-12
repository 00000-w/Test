package com.coder.homework1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestHomework1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Test.class;
        Object o = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Homework1 annotation = field.getAnnotation(Homework1.class);
            String value = annotation.value();
            if (field.getType().getSimpleName().equals("int"))
                field.set(o, Integer.parseInt(value));
            else
                field.set(o, value);
        }
        System.out.println(o);
    }
}
