package com.coder.homework1;
//大众 4S 店组织一批车辆去报税
//奥迪 3.2 升
//迈腾 2.8 升
//宝来 1.6 升
public class Car {
    private String type;
    private double l;

    public String getType() {
        return type;
    }
    public double getl() {
        return l;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setl(double l) {
        this.l = l;
    }

    Car() {
    }
}
