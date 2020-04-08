package pp.data;

import pp.main.Data;
import pp.visual.screen.InfoLine;
import pp.visual.screen.TextLine;

public class CurrentData {
    private Data data;

    private String driver;
    private String destination;
    private String line;
    private String course;
    private String direction;
    private String zone;
    private String graph;

    public CurrentData(Data data) {
        this.data = data;
        this.driver = "00000";
        this.destination = "000";
        this.line = "000";
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
        return (this.line + this.course + this.graph);
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
        return line;
    }

    public void setLine(String line) {
        this.line = line;
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
