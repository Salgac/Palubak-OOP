package pp.lines;

import pp.data.stops.Stop;

import java.util.ArrayList;
import java.util.Collections;

public class Line3 extends TramLine {
    public Line3() {
        super();
        this.code = "003";
        this.destination1 = "567";
        this.destination2 = "650";
        stops1.add(new Stop("0558"));
        stops1.add(new Stop("0525"));
        stops1.add(new Stop("0523"));
        stops1.add(new Stop("0522"));
        stops1.add(new Stop("0620"));
        stops1.add(new Stop("0638"));
        stops1.add(new Stop("0660"));
        stops1.add(new Stop("0405"));
        stops1.add(new Stop("0410"));
        stops1.add(new Stop("0415"));
        stops1.add(new Stop("0420"));
        stops1.add(new Stop("0423"));
        stops1.add(new Stop("0427"));
        stops1.add(new Stop("0434"));
        stops1.add(new Stop("0444"));
        stops1.add(new Stop("0450"));
        stops1.add(new Stop("0452"));
        stops1.add(new Stop("0459"));
        stops1.add(new Stop("0462"));
        stops1.add(new Stop("0460"));
        stops1.add(new Stop("0470"));
        stops1.add(new Stop("0475"));
        stops1.add(new Stop("0478"));
        stops1.add(new Stop("0484"));
        stops1.add(new Stop("0491"));

        stops2 = new ArrayList<>(stops1);
        Collections.reverse(stops2);
    }
}
