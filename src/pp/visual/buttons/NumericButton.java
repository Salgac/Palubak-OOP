package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.functions.NumberScript;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;
import java.awt.*;

/**
 * Button class for numeric buttons and functions
 *
 * @author Dominik Šalgovič
 */
public class NumericButton extends BuseButton {

    private JLabel number;
    private final int num;
    private final NumberScript numberScript;

    /**
     * Default constructor
     *
     * @param data data object
     * @param x    x coordinate
     * @param y    y coordinate
     * @param text text to be displayed on button
     * @param num  number of button
     * @param type type of function
     */
    public NumericButton(Data data, int x, int y, String text, String num, FUNCTION_TYPE type) {
        super(data, x, y, text, type);
        this.num = Integer.parseInt(num);
        this.numberScript = new NumberScript(this);
        drawNumber(num);
    }

    /**
     * Method executed on click event
     */
    @Override
    void onclick() {
        super.onclick();
        if (numberScript != null) {
            numberScript.execute();
        }
    }

    /**
     * Method that draws number on button
     *
     * @param num number to be displayed
     */
    private void drawNumber(String num) {
        number = new JLabel(num);
        number.setFont(new Font("Arial Condensed", Font.BOLD, 37));
        number.setHorizontalAlignment(SwingConstants.RIGHT);
        number.setVerticalAlignment(SwingConstants.BOTTOM);
        this.add(number, BorderLayout.SOUTH);
    }

    /**
     * Getter for number
     *
     * @return number of the button object
     */
    public int getNum() {
        return num;
    }
}
