package com.coder.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class homework4 {
    public static void main(String[] args) {
    }
}
class Utils {
    //方法一：只要传入类名、方法名和参数数组，就能获取该方法的返回值
    public static Object invokeMethod(String className, String methodName, Object[] args, Class<?>... parameters) {
        try {
            Class<?> clazz = Class.forName(className);
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getDeclaredMethod(methodName, parameters);
            method.setAccessible(true);
            return method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //方法二：只要传入类名、属性名和属性值，就可以调用该属性的 setXXX()方法为其赋值，并返回这个类的对象
    public static Object setFieldValue(String className, String fieldName, Object fieldValue) {
        Object obj = null;
        try {
            Class<?> clazz = Class.forName(className);
            obj = clazz.getDeclaredConstructor().newInstance();
            StringBuilder stringBuilder = new StringBuilder(fieldName);
            stringBuilder.setCharAt(0, Character.toUpperCase(fieldName.charAt(0)));
            Method method = clazz.getDeclaredMethod("set" + stringBuilder, fieldValue.getClass());
            method.invoke(obj, fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    //方法三：只要传入类名、属性数组和属性值数组，就可以为该类的给定属性赋值，并返回这个类的对象
    public static Object setFieldsValue(String className, String[] fields, Object[] values) {
        Object obj = null;
        try {
            Class<?> clazz = Class.forName(className);
            obj = clazz.getDeclaredConstructor().newInstance();
            for (int i = 0; i < fields.length; i++) {
                Field field = clazz.getDeclaredField(fields[i]);
                field.setAccessible(true);
                field.set(obj, values[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}

