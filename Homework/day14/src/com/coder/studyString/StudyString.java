package com.coder.studyString;

public class StudyString {
    public static void main(String[] args) {
        //1.
        //静态创建，在方法区常量池产生唯一一个字符串对象，如果有另外一个引用指向了相同的字符串，则两个引用变量的地址相同
        String x = "abc";
        //动态创建，在堆内存中产生一个不同的对象，会产生两个对象
        String z = new String("asdaf");

        //2.构造方法
        String a = new String("xxx");
        String b = new String();
        //将字符串转成字符数组的方式
        char[] chars = a.toCharArray();
        //将字符数组转化为字符串
        char[] c = {'a', 'b', 'e'};
        String str1 = new String(c);
        //byte类型转换
        byte[] byte1 = {65, 66, 67};
        //sout显示ABC
        String str2 = new String(byte1);

    }
}
