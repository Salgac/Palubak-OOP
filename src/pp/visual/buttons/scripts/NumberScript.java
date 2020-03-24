package pp.visual.buttons.scripts;

import pp.visual.buttons.BuseButton;

public class NumberScript extends BuseScript {

    public NumberScript(BuseButton button, int num) {
        super(button, Integer.toString(num));
    }

    @Override
    public void execute() {
        getTextLine(0).setText(text);
    }
}
