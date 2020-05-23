package pp.main;

import java.util.Scanner;

/**
 * Main class is used to start the programme.
 *
 * @author Dominik Šalgovič
 */
public class Main {
    private final Data data;
    private final Panel mainWindow;
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Default constructor generating database and new aplication window.
     */
    private Main() {
        this.data = new Data();
        this.mainWindow = new Panel(this.data);

        //debug input check
        while (true) {
            checkInput();
        }
    }

    /**
     * Main method that creates a new instance of itself.
     *
     * @param Args arguments from console, not needed
     */
    public static void main(String[] Args) {
        new Main();
    }

    /**
     * Method that checks System.in for any input
     */
    private void checkInput() {
        char tmp;
        if (sc.hasNext()) {
            tmp = sc.next().charAt(0);
            //check for letter in stdin, and if it is 'd', switch debug mode
            if (tmp == 'd') {
                if (this.data.isDebugMode()) {
                    System.out.println("Debug mode is now set to OFF");
                    this.data.setDebugMode(false);
                } else {
                    System.out.println("Debug mode is now set to ON");
                    this.data.setDebugMode(true);
                }
            }
        }
    }
}
