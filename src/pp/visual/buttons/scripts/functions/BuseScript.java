package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;

/**
 * Default abstract class for scripts
 *
 * @author Dominik Šalgovič
 */
public abstract class BuseScript {

    BuseButton button;
    String text;
    FUNCTION_TYPE type;

    /**
     * Defaul constructor
     *
     * @param button button that the script belongs to
     * @param type   type of script
     */
    public BuseScript(BuseButton button, FUNCTION_TYPE type) {
        this.button = button;
        this.type = type;
    }

    /**
     * execution method
     */
    public abstract void execute();

    /**
     * method for text refreshing
     */
    abstract void refreshText();

    /**
     * accept method
     */
    abstract void accept();

    /**
     * cancel method
     */
    abstract void cancel();

    /**
     * helper method to get text line
     *
     * @param i index of text line
     * @return line object
     */
    JLabel getTextLine(int i) {
        return button.getData().getScreen().getTextLines().get(i);
    }

    /**
     * getter method to get text
     *
     * @return text in script
     */
    String getText() {
        return text;
    }

    /**
     * Setter for text in script
     *
     * @param text String to be set
     */
    void setText(String text) {
        this.text = text;
        refreshText();
    }

    /**
     * Method that formats the text to be displayed
     *
     * @param text text to be formatted
     * @return formatted text
     */
    String fillText(String text) {
        int length = text.length();
        char[] string = text.toCharArray();
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ')
                string[i] = '0';
            else
                break;
        }
        return String.valueOf(string);
    }
}
