package pp.lines;

import pp.data.stops.Stop;
import pp.main.Data;

import java.util.ArrayList;

public interface Line {
    ArrayList<Stop> getStops(String direction);

    default String getCode() {
        return "000";
    }

    default String getDestination(String direction) {
        return "000";
    }

    Stop getNext(String id, Data data);
}
