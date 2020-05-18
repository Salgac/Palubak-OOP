package pp.data;

import pp.data.destinations.DestinationList;
import pp.data.stops.Stop;
import pp.lines.Line;
import pp.main.Data;
import pp.visual.screen.DestinationLine;
import pp.visual.screen.InfoLine;
import pp.visual.screen.StopLine;
import pp.visual.screen.TextLine;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Main database class holding all of the working data
 *
 * @author Dominik Šalgovič
 */
public class CurrentData {
    private final Data data;

    private String driver;
    private String destination;
    private Line line;
    private String course;
    private String direction;
    private String graph;

    private Stop stop;

    /**
     * Constructor generating the initial data for the database
     *
     * @param data data object
     */
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

    /**
     * Getter method for driver id code
     *
     * @return id code of driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * Setter method for driver id code
     *
     * @param driver new driver id code
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Getter method for service id code
     *
     * @return id code of service
     */
    public String getService() {
        return (getLineCode() + getCourse() + getGraph());
    }

    /**
     * Setter method for service id code
     *
     * @param service new service id code
     */
    public void setService(String service) {
        setLine(service.substring(0, 3), "00");
        setCourse(service.substring(3, 5));
        setGraph(service.substring(5));
    }

    /**
     * Getter method for destination id code
     *
     * @return id code of destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setter method for destination id code
     *
     * @param destination new destination id code
     */
    public void setDestination(String destination) {
        this.destination = destination;
        //update textlines
        //TODO: error handling
        data.getScreen().getTextLines().get(2).setText(getDestinationName());
        ((DestinationLine) data.getScreen().getTextLines().get(4)).reset();
    }

    /**
     * Getter method for destination name
     *
     * @return name of destination
     */
    public String getDestinationName() {
        return DestinationList.getName(getDestination());
    }

    /**
     * Getter method for current line
     *
     * @return id code of current line
     */
    public Line getLine() {
        return this.line;
    }

    /**
     * Setter method for line id code
     *
     * @param line new line id code
     */
    public void setLine(String line, String direction) {
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
                this.line = null;
                this.setDestination("000");
                this.setCourse("00");
                this.setStop(null);
                break;
        }

        //set direction
        setDirection(direction);
        //get first stop and set it as our current stop
        if (this.line != null)
            setStop(this.line.getStops(direction).get(0));
        //set destination according to line
        if (this.line != null)
            setDestination(this.line.getDestination(direction));

        //update screen
        ((InfoLine) this.data.getScreen().getTextLines().get(5)).reset();
    }

    /**
     * Getter method for current line id code
     *
     * @return id code of current line
     */
    public String getLineCode() {
        if (this.line != null)
            return line.getCode();
        else return "000";
    }

    /**
     * Getter method for course id code
     *
     * @return id code of course
     */
    public String getCourse() {
        return course;
    }

    /**
     * Setter method for course id code
     *
     * @param course new course id code
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Getter method for direction id code
     *
     * @return id code of direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Setter method for direction id code
     *
     * @param direction new direction id code
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Getter method for zone id code
     *
     * @return id code of zone
     */
    public String getZone() {
        if (this.stop != null)
            return this.stop.getZone();
        return "000";
    }

    /**
     * Getter method for graphicon id code
     *
     * @return id code of graphicon
     */
    public String getGraph() {
        return graph;
    }

    /**
     * Setter method for graphicon id code
     *
     * @param graph new graphicon id code
     */
    public void setGraph(String graph) {
        this.graph = graph;
    }

    /**
     * Getter method for stop
     *
     * @return instance of stop
     */
    public Stop getStop() {
        return stop;
    }

    /**
     * Getter method for stop id code
     *
     * @return id code of stop
     */
    public String getStopId() {
        if (this.stop != null)
            return stop.getId();
        return "";
    }

    /**
     * Getter method for stop name
     *
     * @return name of stop
     */
    public String getStopName() {
        if (this.stop != null)
            return stop.getName();
        return "";
    }

    /**
     * Setter method for stop
     *
     * @param stop new stop object
     */
    public void setStop(Stop stop) {
        this.stop = stop;
        //update textlines
        data.getScreen().getTextLines().get(1).setText(getStopName());
        //update display
        ArrayList<JLabel> tmp = data.getScreen().getTextLines();
        for (JLabel jLabel : tmp) {
            if (jLabel instanceof StopLine) {
                ((StopLine) jLabel).reset();
            }
            if (jLabel instanceof InfoLine) {
                ((InfoLine) jLabel).reset();
            }
        }
    }
}
