package pp.main;

/**
 * Main class is used to start the programme.
 *
 * @author Dominik Šalgovič
 */
public class Main {
    private final Data data;
    private final Panel mainWindow;

    /**
     * Default constructor generating database and new aplication window.
     */
    private Main() {
        this.data = new Data();
        this.mainWindow = new Panel(this.data);

    }

    /**
     * Main method that creates a new instance of itself.
     *
     * @param Args arguments from console, not needed
     */
    public static void main(String[] Args) {
        new Main();
    }
}
