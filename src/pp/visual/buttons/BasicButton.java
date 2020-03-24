package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.*;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;

public class BasicButton extends BuseButton {
    public BasicButton(Data data, int x, int y, String text, FUNCTION_TYPE type) {
        super(data, x, y, text, type);
    }

    public BasicButton(Data data, int x, int y, String text, FUNCTION_TYPE type, boolean special) {
        this(data, x, y, text, type);
        if (special)
            this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/buttons/yellow_button.png")));
    }
}
