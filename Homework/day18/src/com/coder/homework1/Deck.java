package com.coder.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>(54);

    Deck() {
        initialize();
        shuffle();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void initialize() {
        cards.add(new Card(Suit.JOKER, Rank.BIG_JOKER));
        cards.add(new Card(Suit.JOKER, Rank.SMALL_JOKER));
        for (Suit suit : Arrays.asList(Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES)) {
            for (Rank rank: Rank.getStandardRanks())
                cards.add(new Card(suit, rank));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    private List<Card> handcards1;
    private List<Card> handcards2;
    private List<Card> handcards3;
    private List<Card> restcards;

    private static void divideGroups(Deck deck) {
        deck.handcards1 = new ArrayList<>(deck.getCards().subList(0, 17));
        deck.handcards2 = new ArrayList<>(deck.getCards().subList(17, 34));
        deck.handcards3 = new ArrayList<>(deck.getCards().subList(34, 51));
        deck.restcards = new ArrayList<>(deck.getCards().subList(51, 54));
    }

    public List<Card> deal(Deck deck, int groups) {
        divideGroups(deck);
        if (groups == 1)
            return handcards1;
        else if (groups == 2)
            return handcards2;
        else if (groups == 3)
            return handcards3;
        else
            return restcards;
    }
}
