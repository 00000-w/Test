package com.coder.homework2;

public class Graphics {
    private String type;
    private int memory;

    Graphics(String type, int memory) {
        this.type = type;
        this.memory = memory;
    }
    Graphics() {}

    public void canPlay(Player player) {
        String r = memory >= 4 && "独立显卡".equals(type) ? "可以玩" : "不可以玩";
        System.out.println(player.getName() + "的" + player.getComputer().getType() + r + "英雄联盟");
    }
}
