package pp.main;

import pp.data.*;
import pp.visual.screen.*;

public class Data {

    private CurrentData current;
    private BuseScreen screen;

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
}
