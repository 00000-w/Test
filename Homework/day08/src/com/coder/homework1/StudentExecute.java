package com.coder.homework1;
/*网管检查学生年龄，超过 18岁可以上网
根据以上要求，通过构造方法，创建一个学生李白 17 岁。
创建一个网管白居易，调用检查方法，看是否可以上网*/
public class StudentExecute {
    public static void main(String[] args) {
        Student student = new Student("李白", 17);
        Administrator administrator = new Administrator();
        administrator.check(student);
    }
}
