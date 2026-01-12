package com.coder.homework3;

public class Execute {
    public static void main(String[] args) {
        Person man = Factory.personType("男人");
        man.eat();
        man.sleep();
        man.speak();

        Person woman = Factory.personType("女人");
        woman.eat();
        woman.sleep();
        woman.speak();
    }
}
