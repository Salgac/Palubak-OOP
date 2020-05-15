package pp.visual.screen;

import pp.main.Data;

import java.awt.*;

public class StopLine extends TextLine {

    private int pos;
    private Data data;

    public StopLine(int i, Data data) {
        super(i);
        this.pos = i;
        this.data = data;
        reset();
    }

    public void reset() {
        this.setText("Z:" + this.data.getCurrent().getStopId());
        Dimension size = this.getPreferredSize();
        this.setBounds(550 - size.width, 10 + pos * (size.height + 10), size.width, size.height);
    }
}
