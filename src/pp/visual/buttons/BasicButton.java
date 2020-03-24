package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.*;

import javax.swing.*;

public class BasicButton extends BuseButton {
    public BasicButton(Data data, int x, int y, String text) {
        super(data, x, y, text);
        this.script = new BuseScript(this, text);
    }

    public BasicButton(Data data, int x, int y, String text, boolean special) {
        this(data, x, y, text);
        if (special)
            this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/buttons/yellow_button.png")));
    }
}
