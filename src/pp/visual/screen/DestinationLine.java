package pp.visual.screen;

import pp.main.Data;

import java.awt.*;

public class DestinationLine extends TextLine {

    private int pos;
    private Data data;

    public DestinationLine(int i, Data data) {
        super(i);
        this.pos = i;
        this.data = data;
        reset();
    }

    public void reset() {
        this.setText("P C:" + this.data.getCurrent().getDestination());
        Dimension size = this.getPreferredSize();
        this.setBounds(550 - size.width, 10 + pos * (size.height + 10), size.width, size.height);
    }
}
