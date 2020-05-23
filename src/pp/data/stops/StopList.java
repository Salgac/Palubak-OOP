package pp.data.stops;

/**
 * Database class containing the list of all stops with their identification codes
 *
 * @author Dominik Šalgovič
 */
public abstract class StopList {
    private final static String[] list = {"Hl. Stanica", "Nám. F. Liszta", "Úrad vlády SR", "STU", "Vysoká", "Poštová",
            "Nám. SNP", "SND", "Nám. Ľ. Štúra", "Šaf. nám", "Jungmanova", "Farského", "Sad J. K.", "Kamenné nám.", "Mariánska", "Americké nám.",
            "Blumentál", "Rač. mýto", "Ursínyho", "Pionierska", "Riazanská", "Mladá garda", "Nám. B. Kríž", "ŽST Vinohrady",
            "Voz. Krasňany", "Malé Krasňany", "Pekná cesta", "Černockého", "Hečkova", "Hybešova", "Cintorín Rača", "Záhumenice", "Púchovská", "Komisárky",
            "Zlaté Piesky", "Shop. Palace", "PPA Controll", "Jur. Dvor", "Magnetová", "Odborárska", "Zátišie", "MiÚ n. Mesto", "Nová Doba", "Odbojárov",
            "Trnavské mýto", "Krížna", "Saleziáni", "Slovanet", "Nemocnica Ruž.", "Herlianska", "Tomášikova", "Súmračná", "Chlumeckého", "Astronomická"};
    private final static String[] number = {"0341", "0345", "0350", "0402", "0435", "0466",
            "0601", "0592", "0635", "0522", "0558", "0525", "0523", "0620", "0638", "0660",
            "0405", "0410", "0415", "0420", "0423", "0427", "0434", "0444",
            "0450", "0452", "0459", "0462", "0460", "0470", "0475", "0478", "0484", "0491",
            "0792", "0788", "0785", "0769", "0761", "0758", "0753", "0744", "0740", "0736",
            "0724", "0703", "0800", "0811", "0823", "0830", "0846", "0853", "0866", "0871"};
    private final static String[] zone = {"100", "100", "100", "100", "100", "100",
            "100", "100", "100", "100", "100", "100", "100", "100", "100", "100",
            "100", "100", "100", "100", "100", "100", "100", "100",
            "101", "101", "101", "101", "101", "101", "101", "101", "101", "101",
            "101", "101", "101", "100", "100", "100", "100", "100", "100", "100",
            "100", "100", "100", "100", "100", "100", "100", "100", "100", "100"};

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
