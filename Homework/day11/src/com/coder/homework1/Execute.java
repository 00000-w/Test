package com.coder.homework1;

public class Execute {
    public static void main(String[] args) {
        LibraryCard libraryCard = new LibraryCard("红色", "A类");
        Student student = new Student("李白", libraryCard);
        Administrator administrator = new Administrator("杜甫");

        administrator.checkCard(student);
        student.borrow();
    }
}
