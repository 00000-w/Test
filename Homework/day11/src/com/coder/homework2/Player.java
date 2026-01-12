package com.coder.homework2;

public class Player {
    private String name;
    private Computer computer;

    Player(String name, Computer computer) {
        this.name = name;
        this.computer = computer;
    }

    Player() {}

    public String getName() {
        return name;
    }

    public Computer getComputer() {
        return computer;
    }
}
