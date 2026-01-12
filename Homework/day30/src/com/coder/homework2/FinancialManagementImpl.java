package com.coder.homework2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FinancialManagementImpl implements FinancialManagement{
    @Override
    public void financialOperation() {
        System.out.println("实行财务操作....");
    }
    @Override
    public String userName() {
        return System.getProperty("user.name");
    }

    @Override
    public String systemTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        String time = localDateTime.format(dateTimeFormatter);
        return time;
    }

    @Override
    public String methodName() {
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }

    @Override
    public String className() {
        return this.getClass().getName();
    }
}
