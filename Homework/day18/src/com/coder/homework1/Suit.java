package com.coder.homework1;

public enum Suit {
    SPADES("♠", 0),
    HEARTS("♥", 1),
    CLUBS("♣", 2),
    DIAMONDS("♦", 3),
    JOKER("🃏", 4);

     private final String symbol;
     private final int order;

    Suit(String symbol, int order) {
        this.symbol = symbol;
        this.order = order;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getOrder() {
        return order;
    }
}
