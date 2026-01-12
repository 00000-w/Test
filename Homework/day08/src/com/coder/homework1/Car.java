package com.coder.homework1;
//小型车：1 小时以内，收费 8 元
//超过 1 小时，每小时收费 5 元
//大型车：1 小时以内，收费 15 元
//超过 1 小时，每小时收费 8 元
public class Car {
    public String type;
    int chargeWithinHour;
    int chargeOverPerHour;
    int time;

    Car() {
        type = "小";
        time = 3;
        chargeWithinHour = 8;
        chargeOverPerHour = 5;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setChargeWithinHour(int chargeWithinHour) {
        this.chargeWithinHour = chargeWithinHour;
    }
    public void setChargeOverPerHour(int chargeOverPerHour) {
        this.chargeOverPerHour = chargeOverPerHour;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }
    public int getChargeWithinHour() {
        return chargeWithinHour;
    }
    public int getChargeOverPerHour() {
        return chargeOverPerHour;
    }
    public int getTime() {
        return time;
    }

    public void charge(int time, String type) {
        if(type.equals("大")) {
            if(time == 1)
                System.out.println("收费为15元");
                else {
                System.out.println("收费为" + (8 * (time - 1) + 15));
            }

        } else {
            if(time == 1)
                System.out.println("收费为8元");
                else
                System.out.println("收费为" + (5 * (time - 1) + 8));
        }

    }
}
