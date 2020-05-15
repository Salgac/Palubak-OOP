package pp.data.stops;

public abstract class StopList {
    private final static String[] list = {"Hl. Stanica", "Nám. F. Liszta", "Úrad vlády SR", "STU", "Vysoká", "Poštová", "Nám. SNP", "SND", "Nám. Ľ. Štúra"};
    private final static String[] number = {"0000", "00001", "0002", "0003", "0004", "0005", "0006", "0007", "0008", "0009", "0010"};
    private final static String[] zone = {"100", "100", "100", "100", "100", "100", "100", "100", "100"};

    public static String getName(String id) {
        for (int i = 0; i < list.length; i++) {
            if (number[i].equals(id)) {
                return list[i];
            }
        }
        return "";
    }

    public static String getZone(String id) {
        for (int i = 0; i < list.length; i++) {
            if (number[i].equals(id)) {
                return zone[i];
            }
        }
        return "";
    }
}
