package pp.data.stoplist;

public class Stop {
    String name;
    int id;

    public Stop(int id) {
        this.id = id;
        this.name = StopList.getStopName(id);
    }
}
