package pp.data.stops;

/**
 * Database class containing the list of all stops with their identification codes
 *
 * @author Dominik Šalgovič
 */
public abstract class StopList {
    private final static String[] list = {"Hl. Stanica", "Nám. F. Liszta", "Úrad vlády SR", "STU", "Vysoká", "Poštová", "Nám. SNP", "SND", "Nám. Ľ. Štúra", "Šaf. nám"};
    private final static String[] number = {"0001", "0002", "0003", "0004", "0005", "0006", "0007", "0008", "0009", "0010"};
    private final static String[] zone = {"100", "100", "100", "100", "100", "100", "100", "100", "100", "100"};

    /**
     * Method used to get name according to id code
     *
     * @param id identification code of stop
     * @return name of the stop
     */
    public static String getName(String id) {
        for (int i = 0; i < list.length; i++) {
            if (number[i].equals(id)) {
                return list[i];
            }
        }
        return "";
    }

    /**
     * Method used to get zone of stop based on its id code
     *
     * @param id identification code of stop
     * @return zone of the stop
     */
    public static String getZone(String id) {
        for (int i = 0; i < list.length; i++) {
            if (number[i].equals(id)) {
                return zone[i];
            }
        }
        return "";
    }
}
