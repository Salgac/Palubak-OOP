package pp.data.stops;

/**
 * Basic class holding the information need for proper stop simulation
 *
 * @author Dominik Šalgovič
 */
public class Stop {
    private String name;
    private String id;
    private String zone;

    /**
     * Basic constructor generating stop based on its id code.
     *
     * @param id identification code of stop
     */
    public Stop(String id) {
        this.id = id;
        this.name = StopList.getName(id);
        this.zone = StopList.getZone(id);
    }

    /**
     * Getter method for stops name
     *
     * @return name of stop
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for stops id code
     *
     * @return code of stop
     */
    public String getId() {
        return id;
    }

    /**
     * Getter method for stops zone
     *
     * @return zone of stop
     */
    public String getZone() {
        return zone;
    }
}
