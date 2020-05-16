package pp.visual.screen;

import pp.main.Data;

/**
 * Class used for displaying basic line and zone information
 *
 * @author Dominik Šalgovič
 */
public class InfoLine extends TextLine {

    Data data;

    /**
     * Default constructor
     *
     * @param i    position of line
     * @param data data object
     */
    public InfoLine(int i, Data data) {
        super(i);
        this.data = data;
        reset();
    }

    /**
     * Method to reset the line and get new information to display from database
     */
    public void reset() {
        this.setText("L" + this.data.getCurrent().getLineCode() + "   Z" + this.data.getCurrent().getZone());
    }
}
