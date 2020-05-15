package pp.lines;

import pp.data.stops.Stop;
import pp.main.Data;

import java.util.ArrayList;

public class Line {
    ArrayList<Stop> stops1, stops2;
    String code;
    String destination1, destination2;

    public Line() {
        stops1 = new ArrayList<>();
        stops2 = new ArrayList<>();
    }

    public ArrayList<Stop> getStops(String course) {
        if (bound(course))
            return stops1;
        else
            return stops2;
    }

    public String getCode() {
        return code;
    }

    public String getDestination(String course) {
        if (bound(course))
            return destination1;
        else
            return destination2;
    }

    public Stop getNext(String id, Data data) {
        ArrayList<Stop> list;
        String course = data.getCurrent().getCourse();

        //decide on list
        if (bound(course))
            list = stops1;
        else
            list = stops2;

        //find the stop
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                if (i != list.size() - 1)
                    return list.get(i + 1);
                else {
                    if (bound(course)) {
                        //change course
                        int num = Integer.parseInt(course);
                        String tmp;
                        num++;
                        if (num < 10)
                            tmp = "0" + num;
                        else
                            tmp = String.valueOf(num);
                        //write new data
                        data.getCurrent().setCourse(tmp);
                        data.getCurrent().setDestination(destination2);
                        return stops2.get(0);
                    } else
                        return null;
                }
            }
        }
        return null;
    }

    private boolean bound(String course) {
        int c = Integer.parseInt(course);
        return c % 2 == 0;
    }
}
