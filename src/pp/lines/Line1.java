package pp.lines;

import pp.data.stoplist.Stop;

public class Line1 extends Line {
    public Line1() {
        super();
        this.code = "001";
        stops.add(new Stop(0));
        stops.add(new Stop(1));
        stops.add(new Stop(2));
        stops.add(new Stop(3));
        stops.add(new Stop(4));
        stops.add(new Stop(5));
        stops.add(new Stop(6));
        stops.add(new Stop(7));
        stops.add(new Stop(8));
    }
}