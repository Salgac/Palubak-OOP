package pp.lines;

import pp.data.stops.Stop;

public class Line1 extends Line {
    public Line1() {
        super();
        this.code = "001";
        this.destination1 = "450";
        this.destination2 = "843";
        stops1.add(new Stop("0001"));
        stops1.add(new Stop("0002"));
        stops1.add(new Stop("0003"));
        stops1.add(new Stop("0004"));
        stops1.add(new Stop("0005"));
        stops1.add(new Stop("0006"));
        stops1.add(new Stop("0007"));
        stops1.add(new Stop("0008"));
        stops1.add(new Stop("0009"));//Nam. L. Stura
        stops2.add(new Stop("0010"));
        stops2.add(new Stop("0007"));
        stops2.add(new Stop("0006"));
        stops2.add(new Stop("0005"));
        stops2.add(new Stop("0004"));
        stops2.add(new Stop("0003"));
        stops2.add(new Stop("0002"));
        stops2.add(new Stop("0001"));
    }
}
