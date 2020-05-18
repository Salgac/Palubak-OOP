package pp.lines;

import pp.data.stops.Stop;
import pp.main.Data;

import java.util.ArrayList;

/**
 * Default abstract class to represent tram/bus lines. Class holds all information of concurrent stops nad respective destinations
 *
 * @author Dominik Šalgovič
 */
public class Line {
    ArrayList<Stop> stops1, stops2;
    String code;
    String destination1, destination2;

    /**
     * Default constructor initialising the array lists of stops
     */
    public Line() {
        stops1 = new ArrayList<>();
        stops2 = new ArrayList<>();
    }

    /**
     * Getter method used to get array list of stops, according to current direction
     *
     * @param direction current direction of travel
     * @return Array list of stops
     */
    public ArrayList<Stop> getStops(String direction) {
        if (bound(direction))
            return stops1;
        else
            return stops2;
    }

    /**
     * Getter method for lines id code
     *
     * @return id code number of line in String format
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method used to get destination id code, according to current direction
     *
     * @param direction current direction of travel
     * @return destination code of destination
     */
    public String getDestination(String direction) {
        if (bound(direction))
            return destination1;
        else
            return destination2;
    }

    /**
     * Getter for next stop in list of stops
     *
     * @param id   id code of current stop
     * @param data database object
     * @return object of new stop
     */
    public Stop getNext(String id, Data data) {
        ArrayList<Stop> list;
        String direction = data.getCurrent().getDirection();

        //decide on list
        if (bound(direction))
            list = stops1;
        else
            list = stops2;

        //find the stop
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                if (i != list.size() - 1)
                    return list.get(i + 1);
                else {
                    if (bound(direction)) {
                        //change direction
                        int num = Integer.parseInt(direction);
                        String tmp;
                        num++;
                        if (num < 10)
                            tmp = "0" + num;
                        else
                            tmp = String.valueOf(num);
                        //write new data
                        data.getCurrent().setDirection(tmp);
                        data.getCurrent().setDestination(destination2);
                        return stops2.get(0);
                    } else
                        return null;
                }
            }
        }
        return null;
    }

    /**
     * Helper method to determine direction of travel
     *
     * @param direction direction of travel
     * @return true when direction is divisible by 2
     */
    private boolean bound(String direction) {
        int c = Integer.parseInt(direction);
        return c % 2 == 0;
    }
}
