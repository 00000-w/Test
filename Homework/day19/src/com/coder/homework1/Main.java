package com.coder.homework1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Station> stations1 = new ArrayList<>(10);
        stations1.add(new Station("沿山大道站"));
        stations1.add(new Station("凤凰山站"));
        stations1.add(new Station("文德路站"));
        stations1.add(new Station("河滨公园站"));
        stations1.add(new Station("康安路站"));
        stations1.add(new Station("南京工业大学站"));
        stations1.add(new Station("兴隆路站"));
        stations1.add(new Station("万寿路站"));
        stations1.add(new Station("国际健康中心站"));

        List<Station> stations2 = new ArrayList<>(10);
        stations2.add(new Station("国际健康中心站"));
        stations2.add(new Station("万寿路站"));
        stations2.add(new Station("兴隆路站"));
        stations2.add(new Station("南京工业大学站"));
        stations2.add(new Station("康安路站"));
        stations2.add(new Station("河滨公园站"));
        stations2.add(new Station("文德路站"));
        stations2.add(new Station("凤凰山站"));
        stations2.add(new Station("沿山大道站"));

        List<Subway> subways = new ArrayList<>(2);
        subways.add(new Subway(stations1, "上行"));
        subways.add(new Subway(stations2, "下行"));

        Station stationStart1 = new Station("凤凰山站");
        Station stationStart2 = new Station("南京工业大学站");
        Station stationEnd1 = new Station("万寿路站");
        Station stationEnd2 = new Station("河滨公园站");

        List<Passenger> passengers = new ArrayList<>(2);
        passengers.add(new Passenger("李白", stationStart1, stationEnd1, "上行"));
        passengers.add(new Passenger("杜甫", stationStart2, stationEnd2, "下行"));

        Subway subway = new Subway();

        for (Passenger passenger : passengers) {
            System.out.println(passenger.getName() + "从" + passenger.getStart().getName() + "坐到" + passenger.getEnd().getName() + subway.fees(subwayRoute(passenger, subways)));
        }
    }

    public static List<Station> subwayRoute(Passenger passenger, List<Subway> subways) {
        if ("上行".equals(passenger.getDirection())) {
            int i = subways.get(0).getStations().indexOf(passenger.getStart());
            int j = subways.get(0).getStations().indexOf(passenger.getEnd());
            return new ArrayList<>(subways.get(0).getStations().subList(i, j + 1));
        }
        else {
            int i = subways.get(1).getStations().indexOf(passenger.getStart());
            int j = subways.get(1).getStations().indexOf(passenger.getEnd());
            return new ArrayList<>(subways.get(1).getStations().subList(i, j + 1));
        }
    }

}
