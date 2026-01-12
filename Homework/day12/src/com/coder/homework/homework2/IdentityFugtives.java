package com.coder.homework.homework2;

public class IdentityFugtives {
    public static void checkFugtive(String message) throws IdentityException {
        if ("1234567890".equals(message))
            throw new IdentityException("该身份证与在逃人员匹配，立即报警!");
    }
}
