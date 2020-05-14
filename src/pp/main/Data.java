package pp.main;

import pp.data.*;
import pp.lines.*;
import pp.visual.buttons.scripts.functions.BuseScript;
import pp.visual.screen.*;

import java.util.ArrayList;

public class Data {

    private INPUT_MODE inputMode = INPUT_MODE.OFF;

    private CurrentData current;
    private BuseScreen screen;
    private ArrayList<Line> lines;

    public INPUT_MODE getInputMode() {
        return inputMode;
    }

    private BuseScript activeScript;

    public Data() {
        //generate new current data database
        current = new CurrentData(this);

        //load all available lines
        lines = new ArrayList<>();
        lines.add(new Line1());
        lines.add(new Line3());
        lines.add(new Line4());
        lines.add(new Line7());
        lines.add(new Line9());
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

    public ArrayList<Line> getLines() {
        return lines;
    }
}
