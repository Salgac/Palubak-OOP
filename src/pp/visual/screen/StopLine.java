package pp.visual.screen;

import pp.main.Data;

import java.awt.*;

public class StopLine extends TextLine {

    private final int pos;
    private final Data data;

    public StopLine(int i, Data data) {
        super(i);
        this.pos = i;
        this.data = data;
        reset();
    }

    public void reset() {
        String id = this.data.getCurrent().getStopId();
        if (!id.equals(""))
            this.setText("Z:" + id);
        else
            this.setText("");
        Dimension size = this.getPreferredSize();
        this.setBounds(550 - size.width, 10 + pos * (size.height + 10), size.width, size.height);
    }
}
