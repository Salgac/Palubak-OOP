package pp.lines;

import pp.data.stops.Stop;

import java.util.ArrayList;

public class Line {
    ArrayList<Stop> stops;
    String code;
    String destination;

    public Line() {
        stops = new ArrayList<>();
    }

    public ArrayList<Stop> getStops() {
        return stops;
    }

    public String getCode() {
        return code;
    }

    public String getDestination() {
        return destination;
    }
}
