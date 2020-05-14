package pp.data;

import pp.lines.Line;
import pp.main.Data;
import pp.visual.screen.InfoLine;

public class CurrentData {
    private final Data data;

    private String driver;
    private String destination;
    private Line line;
    private String course;
    private String direction;
    private String zone;
    private String graph;


    public CurrentData(Data data) {
        this.data = data;
        this.driver = "00000";
        this.destination = "000";
        this.line = null;
        this.course = "00";
        this.direction = "00";
        this.zone = "101";
        this.graph = "0";
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getService() {
        return (getLine() + getCourse() + getGraph());
    }

    public void setService(String service) {
        setLine(service.substring(0, 3));
        setCourse(service.substring(3, 5));
        setGraph(service.substring(5));
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLine() {
        if (this.line != null)
            return line.code;
        else return "000";
    }

    public void setLine(String line) {
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
        ((InfoLine) this.data.getScreen().getTextLines().get(3)).reset();
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
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }
}
