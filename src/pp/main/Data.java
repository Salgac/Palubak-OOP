package pp.main;

import pp.data.*;
import pp.visual.buttons.scripts.functions.BuseScript;
import pp.visual.screen.*;

public class Data {

    private INPUT_MODE inputMode = INPUT_MODE.OFF;

    private CurrentData current;
    private BuseScreen screen;

    public INPUT_MODE getInputMode() {
        return inputMode;
    }

    private BuseScript activeScript;

    public Data() {
        current = new CurrentData(this);
        //TODO: make data initialisation
    }

    public BuseScreen getScreen() {
        return screen;
    }

    public void setScreen(BuseScreen screen) {
        this.screen = screen;
    }

    public CurrentData getCurrent() {
        return current;
    }

    public void setInputMode(INPUT_MODE inputMode) {
        this.inputMode = inputMode;
    }

    public enum INPUT_MODE {
        OFF,
        SHOW,
        ON
    }

    public BuseScript getActiveScript() {
        return activeScript;
    }

    public void setActiveScript(BuseScript activeScript) {
        this.activeScript = activeScript;
    }
}
