package pp.data;

public class CurrentData {
    private String driver;
    private String service;
    private String destination;
    private String line;
    private String course;
    private String direction;
    private String zone;

    public CurrentData() {
        this.driver = "00000";
        this.service = "0000000";
        this.destination = "000";
        this.line = "000";
        this.course = "000";
        this.direction = "00";
        this.zone = "101";
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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
}
