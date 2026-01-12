package com.coder.homework1;

import java.util.Objects;

public class Tiger implements Cloneable {
    private double height;
    private int weight;

    public Tiger(double height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public Tiger clone() {
        try {
            return (Tiger) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tiger tiger = (Tiger) obj;
        return Double.compare(tiger.height, height) == 0 && Integer.compare(tiger.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight);
    }

    @Override
    public String toString() {
        return "Tiger{" + "height=" + height + ",weight=" + weight + "}";
    }

}
