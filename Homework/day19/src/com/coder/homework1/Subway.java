package com.coder.homework1;

import java.util.ArrayList;
import java.util.List;

public class Subway {
    private List<Station> stations;
    private String direction;

    Subway(List<Station> stations, String direction) {
        this.stations = stations;
        this.direction = direction;
    }

    Subway() {
        this.stations = new ArrayList<>();
    }

    public List<Station> getStations() {
        return stations;
    }

    public String fees(List<Station> stations) {
        if (stations.size() <= 3)
            return "车票价 2 元";
        else if (stations.size() <= 5)
            return "车票价 3 元";
        else if (stations.size() <=7)
            return "车票价 4 元";
        else
            return "车票价 5 元";
    }

}
