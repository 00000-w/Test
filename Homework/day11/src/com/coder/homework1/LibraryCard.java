package com.coder.homework1;

public class LibraryCard {
    private String color;
    private String type;

    LibraryCard(String color, String type) {
        this.color = color;
        this.type =type;
    }
    LibraryCard() {}

    public void setColor(String color) {
        this.color = color;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getColor() {
        return color;
    }
    public String getType() {
        return type;
    }

    public String pickBook(String color, String type) {
        if ("红色".equals(color)) {
            if("A类".equals(type))
                return "《java基础》";
            else if ("B类".equals(type))
                return "《mysql数据库》";
        } return "《java编程思想》";
    }

}
