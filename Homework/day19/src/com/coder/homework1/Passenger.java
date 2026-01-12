package com.coder.homework1;

public class Passenger {
    private String name;
    private Station start;
    private Station end;
    private String direction;

    Passenger(String name, Station start, Station end, String direction) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    public String getDirection() {
        return direction;
    }
}
