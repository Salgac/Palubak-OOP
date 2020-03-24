package pp.visual.buttons.scripts;

import pp.visual.buttons.NumericButton;

public class NumberScript extends BuseScript {

    public NumberScript(NumericButton button, int num) {
        super(button);
    }

    @Override
    public void execute() {
        getTextLine(0).setText(String.valueOf(((NumericButton) this.button).getNum()));
    }
}
