package pp.lines;

import pp.data.stops.Stop;

import java.util.ArrayList;
import java.util.Collections;

public class Line4 extends Line {
    public Line4() {
        super();
        this.code = "004";
        this.destination1 = "450";
        this.destination2 = "790";

        stops1.add(new Stop("0792"));
        stops1.add(new Stop("0788"));
        stops1.add(new Stop("0785"));
        stops1.add(new Stop("0769"));
        stops1.add(new Stop("0761"));
        stops1.add(new Stop("0758"));
        stops1.add(new Stop("0753"));
        stops1.add(new Stop("0744"));
        stops1.add(new Stop("0740"));
        stops1.add(new Stop("0736"));
        stops1.add(new Stop("0724"));
        stops1.add(new Stop("0703"));
        stops1.add(new Stop("0660"));
        stops1.add(new Stop("0638"));
        stops1.add(new Stop("0620"));

        stops2 = new ArrayList<>(stops1);
        Collections.reverse(stops2);

        stops1.add(new Stop("0592"));
        stops1.add(new Stop("0635"));//Nam. L. Stura

        stops2.add(0, new Stop("0522"));
    }
}
