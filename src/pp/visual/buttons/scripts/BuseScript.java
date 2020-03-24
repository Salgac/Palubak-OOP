package pp.visual.buttons.scripts;

import pp.visual.buttons.BuseButton;

import javax.swing.*;

public class BuseScript {

    String text;
    private BuseButton button;

    public BuseScript(BuseButton button, String text) {
        this.button = button;
        this.text = text;
    }

    public void execute() {
        System.out.println(this.text);
        getTextLine(1).setText(this.text);
    }

    JLabel getTextLine(int i) {
        return button.getData().getScreen().getTextLines().get(i);
    }
}
