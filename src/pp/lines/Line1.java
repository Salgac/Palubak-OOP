package pp.lines;

import pp.data.stops.Stop;

/**
 * Class representing line 1 of Bratislava tram lines
 *
 * @author Dominik Šalgovič
 */
public class Line1 extends TramLine {
    /**
     * Default constructor initialising stops and destinations for tram line 1
     */
    public Line1() {
        super();
        this.code = "001";
        this.destination1 = "450";
        this.destination2 = "843";
        stops1.add(new Stop("0341"));
        stops1.add(new Stop("0345"));
        stops1.add(new Stop("0350"));
        stops1.add(new Stop("0402"));
        stops1.add(new Stop("0435"));
        stops1.add(new Stop("0466"));
        stops1.add(new Stop("0601"));
        stops1.add(new Stop("0592"));
        stops1.add(new Stop("0635"));//Nam. L. Stura
        stops2.add(new Stop("0522"));
        stops2.add(new Stop("0601"));
        stops2.add(new Stop("0466"));
        stops2.add(new Stop("0435"));
        stops2.add(new Stop("0402"));
        stops2.add(new Stop("0350"));
        stops2.add(new Stop("0345"));
        stops2.add(new Stop("0341"));
    }
}
