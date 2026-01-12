package com.coder.homework1;

public class Student {
    private String name;
    private LibraryCard libraryCard;

    Student(String name, LibraryCard libraryCard) {
        this.name = name;
        this.libraryCard = libraryCard;
    }
    Student() {
    }

    public String getName() {
        return name;
    }

    public void borrow() {
        System.out.println(name + "借到了" + libraryCard.pickBook(libraryCard.getColor(), libraryCard.getType()));
    }
}
