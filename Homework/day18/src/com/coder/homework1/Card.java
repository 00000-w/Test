package com.coder.homework1;

public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int compareTo(Card other) {
        int suitCompare = Integer.compare(this.suit.getOrder(), other.suit.getOrder());
        if (suitCompare == 0) {
            return Integer.compare(this.rank.getOrder(), other.rank.getOrder());
        }
        return suitCompare;
    }

    public static String toString(Player player) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < player.getHandCard().size(); i++) {
            sb.append(player.getHandCard().get(i).suit.getSymbol() + player.getHandCard().get(i).rank.getDisplay());
            if (i < player.getHandCard().size() -  1) {
                if (player.getHandCard().get(i).getSuit() != player.getHandCard().get(i + 1).getSuit())
                    sb.append("\n");
                else
                    sb.append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return suit.getSymbol() + rank.getDisplay();
    }


}
