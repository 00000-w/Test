package com.coder.homework1;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    ACE("A", 0), TWO("2", 12), THREE("3", 11),
    FOUR("4", 10), FIVE("5", 9), SIX("6", 8),
    SEVEN("7", 7), EIGHT("8", 6), NINE("9", 5),
    TEN("10", 4), JACK("J", 3), QUEEN("Q", 2), KING("K", 1),
    BIG_JOKER("大王", 13), SMALL_JOKER("小王", 14);

    private final String display;
    private final int order;

    Rank(String display, int order) {
        this.display = display;
        this.order = order;
    }

    public String getDisplay() {
        return display;
    }

    public int getOrder() {
        return order;
    }

    public static List<Rank> getStandardRanks() {
        return Arrays.asList(ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO);
    }
}