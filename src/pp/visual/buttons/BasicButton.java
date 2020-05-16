package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;

/**
 * Button class for basic buttons without special function
 *
 * @author Dominik Šalgovič
 */
public class BasicButton extends BuseButton {

    private boolean special = false;

    /**
     * Default constructor
     *
     * @param data data object
     * @param x    x coordinate
     * @param y    y coordinate
     * @param text text to be displayed on button
     * @param type type of the button function
     */
    public BasicButton(Data data, int x, int y, String text, FUNCTION_TYPE type) {
        super(data, x, y, text, type);
    }

    /**
     * Constructor for special buttons with yellow background
     *
     * @param data    data object
     * @param x       x coordinate
     * @param y       y coordinate
     * @param text    text to be displayed on button
     * @param type    type of the button function
     * @param special special boolean
     */
    public BasicButton(Data data, int x, int y, String text, FUNCTION_TYPE type, boolean special) {
        this(data, x, y, text, type);
        if (special) {
            this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/buttons/yellow_button.png")));
            this.special = true;
        }
    }

    /**
     * onclick override to execute special script as well
     */
    @Override
    void onclick() {
        super.onclick();
        if (special)
            script.execute();
    }
}
