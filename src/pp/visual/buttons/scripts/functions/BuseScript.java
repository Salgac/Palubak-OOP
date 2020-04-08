package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;

public abstract class BuseScript {

    BuseButton button;
    String text;
    FUNCTION_TYPE type;

    public BuseScript(BuseButton button, FUNCTION_TYPE type) {
        this.button = button;
        this.type = type;
    }

    public abstract void execute();

    abstract void refreshText();

    abstract void accept();

    abstract void cancel();

    JLabel getTextLine(int i) {
        return button.getData().getScreen().getTextLines().get(i);
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
        refreshText();
    }

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
