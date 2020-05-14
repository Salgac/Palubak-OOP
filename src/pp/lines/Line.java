package pp.lines;

import pp.data.stoplist.Stop;

import java.util.ArrayList;

public class Line {
    public ArrayList<Stop> stops;
    public String code;

    public Line() {
        stops = new ArrayList<>();
    }
}
