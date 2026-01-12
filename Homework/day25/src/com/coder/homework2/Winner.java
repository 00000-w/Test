package com.coder.homework2;

public class Winner {
    private static String winner;
    public static synchronized boolean setWinner(String name) {
        if (winner == null) {
            winner = name;
            return true;
        }
        return false;
    }

    public static String getWinner() {
        return winner;
    }
}
