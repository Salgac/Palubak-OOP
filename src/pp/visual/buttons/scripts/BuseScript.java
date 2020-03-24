package pp.visual.buttons.scripts;

import pp.visual.buttons.BuseButton;

import javax.swing.*;

public class BuseScript {

    BuseButton button;

    public BuseScript(BuseButton button) {
        this.button = button;
    }

    public void execute() {
        System.out.println(this.button.textGet());
        getTextLine(1).setText(this.button.textGet());
    }

    JLabel getTextLine(int i) {
        return button.getData().getScreen().getTextLines().get(i);
    }
}
