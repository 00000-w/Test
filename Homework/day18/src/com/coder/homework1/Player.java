package com.coder.homework1;

import java.util.Collections;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> handCard;

    Player(String name, List<Card> handCard) {
        this.name = name;
        this.handCard = handCard;
        Collections.sort(handCard);
    }

    public String getName() {
        return name;
    }

    public List<Card> getHandCard() {
        return handCard;
    }

    @Override
    public String toString() {
        return "Player{" +
                "handCard=" + handCard +
                '}';
    }
}
