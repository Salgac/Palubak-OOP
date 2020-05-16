package pp.main;

import pp.data.*;
import pp.lines.*;
import pp.visual.buttons.scripts.functions.BuseScript;
import pp.visual.screen.*;

import java.util.ArrayList;

/**
 * Main database class that holds initial data and data handling for the application.
 *
 * @author Dominik Šalgovič
 */
public class Data {

    private INPUT_MODE inputMode = INPUT_MODE.OFF;

    private CurrentData current;
    private BuseScreen screen;
    private ArrayList<Line> lines;

    private BuseScript activeScript;

    /**
     * Default constructor initialising the database with default information
     */
    public Data() {
        //generate new current data database
        current = new CurrentData(this);

        //load all available lines
        lines = new ArrayList<>();
        lines.add(new Line1());
        lines.add(new Line3());
        lines.add(new Line4());
        lines.add(new Line7());
        lines.add(new Line9());
    }

    /**
     * Method used to check for current input mode
     *
     * @return the current input mode
     */
    public INPUT_MODE getInputMode() {
        return inputMode;
    }

    /**
     * Input mode setter method
     *
     * @param inputMode new input mode state
     */
    public void setInputMode(INPUT_MODE inputMode) {
        this.inputMode = inputMode;
    }

    /**
     * Getter method for BuseScreen object
     *
     * @return screen object
     */
    public BuseScreen getScreen() {
        return screen;
    }

    /**
     * Setter method for BuseScreen
     *
     * @param screen new BuseScreen object
     */
    public void setScreen(BuseScreen screen) {
        this.screen = screen;
    }

    /**
     * Getter method for CurrentData database
     *
     * @return object of current data
     */
    public CurrentData getCurrent() {
        return current;
    }

    /**
     * Getter method to find current script object
     *
     * @return current active script
     */
    public BuseScript getActiveScript() {
        return activeScript;
    }

    /**
     * Setter method to set new active script
     *
     * @param activeScript new active script object
     */
    public void setActiveScript(BuseScript activeScript) {
        this.activeScript = activeScript;
    }

    /**
     * Getter method to get lines array
     *
     * @return text lines of screen
     */
    public ArrayList<Line> getLines() {
        return lines;
    }

    /**
     * Enum used for input modes
     */
    public enum INPUT_MODE {
        OFF,
        SHOW,
        ON
    }
}
