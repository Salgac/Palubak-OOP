package pp.lines;

import pp.data.stops.Stop;

public class Line1 extends Line {
    public Line1() {
        super();
        this.code = "001";
        this.destination = "450";
        stops.add(new Stop("0000"));
        stops.add(new Stop("0001"));
        stops.add(new Stop("0002"));
        stops.add(new Stop("0003"));
        stops.add(new Stop("0004"));
        stops.add(new Stop("0005"));
        stops.add(new Stop("0006"));
        stops.add(new Stop("0007"));
        stops.add(new Stop("0008"));
    }
}
