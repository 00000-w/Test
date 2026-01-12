package com.coder.homework1;

public class Employee {
    private String name;
    private String position;

    Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
    Employee() {}

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPosition (String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }

}
