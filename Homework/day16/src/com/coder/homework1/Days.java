package com.coder.homework1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Days {
    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(2005, 9, 29);
        LocalDate currentLocalDate = LocalDate.now();
        long days = ChronoUnit.DAYS.between(birthDay, currentLocalDate);
        System.out.println("从我出生到现在，一共生活了 " + days + " 天");
    }
}
