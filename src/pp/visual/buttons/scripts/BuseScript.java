package pp.visual.buttons.scripts;

import pp.visual.buttons.BuseButton;

import javax.swing.*;

public class BuseScript {

    private String text;
    private BuseButton button;

    public BuseScript() {

    }

    public BuseScript(BuseButton button, String text) {
        this();
        this.button = button;
        this.text = text;
    }

    public void execute() {
        System.out.println(this.text);
        button.getData().getScreen().getTextLines().get(0).setText(this.text);
    }
}
