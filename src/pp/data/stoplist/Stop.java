package pp.data.stoplist;

public class Stop {
    private String name;
    private String id;
    private String zone;

    public Stop(int id) {
        this.name = StopList.getStopName(id);
        this.id = "0000";//TODO: redo this
        this.zone = "100";
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
