package pp.data.stops;

public class Stop {
    private String name;
    private String id;
    private String zone;

    public Stop(String id) {
        this.id = id;
        this.name = StopList.getName(id);
        this.zone = StopList.getZone(id);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getZone() {
        return zone;
    }
}
