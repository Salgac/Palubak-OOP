package pp.main;

import pp.data.*;
import pp.visual.buttons.scripts.BuseScript;
import pp.visual.screen.*;

public class Data {

    private CurrentData current;
    private BuseScreen screen;

    private boolean inputModeActive = false;
    private BuseScript activeScript;

    public Data() {
        current = new CurrentData();
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

    public boolean isInputModeActive() {
        return inputModeActive;
    }

    public void setInputModeActive(boolean inputModeActive) {
        this.inputModeActive = inputModeActive;
    }

    public BuseScript getActiveScript() {
        return activeScript;
    }

    public void setActiveScript(BuseScript activeScript) {
        this.activeScript = activeScript;
    }
}
