package com.coder.homework;

public class Execute {
    public static void main(String[] args) {
        Rope yinRope = new YinRope();
        Rope yangRope = new YangRope();

        Person man = yangRope.creatPerson();
        Person woman = yinRope.creatPerson();

        man.eat();
        man.sleep();
        man.speak();

        woman.eat();
        woman.sleep();
        woman.speak();
    }
}
