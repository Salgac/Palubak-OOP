package pp.data.destinations;

/**
 * Database class containing list of possible destinations, with their identification numbers
 *
 * @author Dominik Šalgovič
 */
public abstract class DestinationList {
    private final static String[] list = {"Dúbravka", "Chatam Sófer", "Jurajov dvor", "Kamenné nám.", "Kapucínska",
            "Karlova Ves", "Nám. Ľ. Štúra", "Námestie SNP", "Rača", "Ružinov", "Šafárik. nám.", "Jungmanova", "Tunel", "Vazovova",
            "Voz. Krasňany", "Zlaté piesky", "ŽST N. Mesto", "ŽST Vinohrady", "Hl. Stanica", "Porucha", "Prestávka", "Služobná jazda", "Zvláštna jazda"};
    private final static String[] number = {"119", "139", "240", "265", "266", "270", "450", "460", "567", "581", "640",
            "650", "690", "710", "725", "790", "810", "835", "843", "906", "905", "912", "913"};

    /**
     * Method used to name a destination stop according to its identification code
     *
     * @param id identification code of destination stop
     * @return name of correct destination stop
     */
    public static String getName(String id) {
        for (int i = 0; i < list.length; i++) {
            if (number[i].equals(id)) {
                return list[i];
            }
        }
        return "";
    }
}
