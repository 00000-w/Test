package com.coder.homework.test;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

public class homework2 {
    public static void main(String[] args) throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("value");
        Class<?> clazz = Class.forName("com.coder.homework.test.Student");
        Object o = clazz.getConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            String value = bundle.getString(name);
            if ("String".equals(field.getType().getSimpleName()))
                field.set(o, value);
            else if ("int".equals(field.getType().getSimpleName())) {
                field.set(o, Integer.parseInt(value));
            }
        }
        Student student = (Student) o;
        System.out.println(student);
    }
}
