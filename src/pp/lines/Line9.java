package pp.lines;

import pp.data.stops.Stop;

import java.util.ArrayList;
import java.util.Collections;

public class Line9 extends Line {
    public Line9() {
        super();
        this.code = "009";
        this.destination1 = "450";
        this.destination2 = "581";
        stops1.add(new Stop("0871"));
        stops1.add(new Stop("0866"));
        stops1.add(new Stop("0853"));
        stops1.add(new Stop("0846"));
        stops1.add(new Stop("0830"));
        stops1.add(new Stop("0823"));
        stops1.add(new Stop("0811"));
        stops1.add(new Stop("0800"));
        stops1.add(new Stop("0724"));
        stops1.add(new Stop("0703"));
        stops1.add(new Stop("0405"));
        stops1.add(new Stop("0435"));
        stops1.add(new Stop("0466"));
        stops1.add(new Stop("0601"));

        stops2 = new ArrayList<>(stops1);
        Collections.reverse(stops2);

        //stu
        stops1.add(stops1.size() - 3, new Stop("0402"));
        stops1.add(new Stop("0592"));
        stops1.add(new Stop("0635"));//Nam. L. Stura

        stops2.add(0, new Stop("0522"));
    }
}
