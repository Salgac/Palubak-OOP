package pp.visual.buttons;

import javax.swing.*;

public class BasicButton extends BuseButton {
    public BasicButton(int x, int y, String text) {
        super(x, y, text);
    }

    public BasicButton(int x, int y, String text, boolean special) {
        this(x, y, text);
        if (special)
            this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/buttons/yellow_button.png")));
    }
}
