package com.coder.homework2;

import java.time.MonthDay;

public class Players {
    private String name;
    private MonthDay buyTime;

    Players() {}

    Players(String name, MonthDay buyTime) {
        this.name = name;
        this.buyTime = buyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonthDay getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(MonthDay buyTime) {
        this.buyTime = buyTime;
    }
}
