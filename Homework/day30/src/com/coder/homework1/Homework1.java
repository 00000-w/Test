package com.coder.homework1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Homework1 {
    //1. 自定义注解，要求注解放在字段中，可以通过反射机制，将注解中的值给到字段中
    String value();
}
