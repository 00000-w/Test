package com.coder.homework2;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class Skin {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void priceCheck(Players players) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM月dd日");
        int year = 2025;
        LocalDate newDate = MonthDay.of(9, 2).atYear(year);
        LocalDate newDate1 = newDate.plusWeeks(1);
        LocalDate newDate2 = newDate.plusWeeks(2);
        LocalDate newDate3 = newDate.plusWeeks(3);
        LocalDate newDate4 = newDate.plusWeeks(4);
        LocalDate date = players.getBuyTime().atYear(year);
        if (date.compareTo(newDate1) <= 0)
            this.price = (int) (1788 * 0.8);
        else if (date.compareTo(newDate2) <= 0)
            this.price = (int) (1788 * 0.9);
        else if (date.compareTo(newDate4) <= 0)
            this.price = 1788;
        else {
            System.out.println(players.getName() + "在" + players.getBuyTime().format(formatter) + "购买皮肤失败，" + "皮肤已下架");
            return;
        }
        System.out.println(players.getName() + "在" + players.getBuyTime().format(formatter) + "购买皮肤成功，花了 " + price + " 点券");
    }
}
