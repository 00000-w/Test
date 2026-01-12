package com.coder.homework2;

public class Execute {
    public static void main(String[] args) {
        Computer computer = new Computer("惠普笔记本电脑");
        Player player = new Player("李白", computer);
        Graphics graphics = new Graphics("独立显卡", 4);

        graphics.canPlay(player);
    }
}
