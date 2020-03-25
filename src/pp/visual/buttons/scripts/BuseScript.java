package pp.visual.buttons.scripts;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;

public abstract class BuseScript {

    public BuseButton button;
    public String text;
    private FUNCTION_TYPE type;

    public BuseScript(BuseButton button, FUNCTION_TYPE type) {
        this.button = button;
        this.type = type;
    }

    public abstract void execute();

    public abstract void refreshText();

    public abstract void accept();

    public abstract void cancel();

    public JLabel getTextLine(int i) {
        return button.getData().getScreen().getTextLines().get(i);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        refreshText();
    }
}
