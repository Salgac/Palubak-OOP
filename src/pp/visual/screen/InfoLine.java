package pp.visual.screen;

import pp.main.Data;

public class InfoLine extends TextLine {

    Data data;

    public InfoLine(int i, Data data) {
        super(i);
        this.data = data;
        reset();
    }

    public void reset() {
        this.setText("L" + this.data.getCurrent().getLineCode() + "   Z" + this.data.getCurrent().getZone());
    }
}
