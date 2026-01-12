package com.coder.homework1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Player> players = new ArrayList<>(3);
        players.add(new Player("李白", deck.deal(deck,1)));
        players.add(new Player("杜甫", deck.deal(deck,2)));
        players.add(new Player("白居易", deck.deal(deck,3)));

        for (Player player : players) {
            System.out.println(player.getName() + "的手牌\n" + Card.toString(player) + "\n");
        }
        System.out.println("底牌\n" + deck.deal(deck, 4) + "\n");
    }

}
