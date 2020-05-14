package pp.data.stoplist;

public abstract class StopList {
    private final static String[] list = {"Hlavná Stanica", "Nám. Franza Liszta", "Úrad vlády SR", "STU", "Vysoká", "Poštová", "Nám. SNP", "SND", "Nám. Ľ. Štúra"};

    public static String getStopName(int id) {
        return list[id];
    }
}
