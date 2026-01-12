package com.coder.homework.homework2;

public class IdentityException extends Exception {
    public IdentityException() {
        super("身份证与在逃人员相同");
    }

    public IdentityException(String message) {
        super(message);
    }
}
