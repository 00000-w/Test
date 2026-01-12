package com.coder.homework2;

import java.time.MonthDay;

public class PurchaseSituation {
    public static void main(String[] args) {
        Players[] players = {
                new Players("李白", MonthDay.of(9, 5)),
                new Players("李信", MonthDay.of(9, 10) ),
                new Players("白起", MonthDay.of(9, 28)),
                new Players("李元芳", MonthDay.of(10, 10))
        };

        Skin skin = new Skin();

        for (Players player : players) {
            skin.priceCheck(player);
        }
    }
}
