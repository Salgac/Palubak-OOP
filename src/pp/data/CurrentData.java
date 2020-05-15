package pp.data;

import pp.data.destinations.DestinationList;
import pp.data.stops.Stop;
import pp.lines.Line;
import pp.main.Data;
import pp.visual.screen.DestinationLine;
import pp.visual.screen.InfoLine;
import pp.visual.screen.StopLine;

public class CurrentData {
    private final Data data;

    private String driver;
    private String destination;
    private Line line;
    private String course;
    private String direction;
    private String graph;

    private Stop stop;


    public CurrentData(Data data) {
        this.data = data;
        this.driver = "00000";
        this.destination = "000";
        this.line = null;
        this.course = "00";
        this.direction = "00";
        this.graph = "0";

        this.stop = null;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getService() {
        return (getLineCode() + getCourse() + getGraph());
    }

    public void setService(String service) {
        setLine(service.substring(0, 3));
        setCourse(service.substring(3, 5));
        setGraph(service.substring(5));
    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationName() {
        return DestinationList.getName(getDestination());
    }

    public void setDestination(String destination) {
        this.destination = destination;
        //update textlines
        //TODO: error handling
        data.getScreen().getTextLines().get(2).setText(getDestinationName());
        ((DestinationLine) data.getScreen().getTextLines().get(4)).reset();
    }

    public Line getLine() {
        return this.line;
    }

    public void setLine(String line) {
        //set line according to entry
        switch (line) {
            case "001":
                this.line = this.data.getLines().get(0);
                break;
            case "003":
                this.line = this.data.getLines().get(1);
                break;
            case "004":
                this.line = this.data.getLines().get(2);
                break;
            case "007":
                this.line = this.data.getLines().get(3);
                break;
            case "009":
                this.line = this.data.getLines().get(4);
                break;
            default:
                //TODO: error handling
                this.data.getScreen().getTextLines().get(0).setText("Neznáma linka");
                this.line = null;
                break;
        }

        //get first stop and set it as our current stop
        if (this.line != null)
            setStop(this.line.getStops(course).get(0));
        //set destination acroding to line
        if (this.line != null)
            setDestination(this.line.getDestination(course));

        //update screen
        ((InfoLine) this.data.getScreen().getTextLines().get(5)).reset();
    }

    public String getLineCode() {
        if (this.line != null)
            return line.getCode();
        else return "000";
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getZone() {
        if (this.stop != null)
            return this.stop.getZone();
        return "000";
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getStopId() {
        if (this.stop != null)
            return stop.getId();
        return "";
    }

    public String getStopName() {
        if (this.stop != null)
            return stop.getName();
        return "";
    }

    public void setStop(Stop stop) {
        this.stop = stop;
        //update textlines
        //TODO: error handling
        data.getScreen().getTextLines().get(1).setText(getStopName());
        ((StopLine) data.getScreen().getTextLines().get(3)).reset();
        ((InfoLine) this.data.getScreen().getTextLines().get(5)).reset();
    }
}
