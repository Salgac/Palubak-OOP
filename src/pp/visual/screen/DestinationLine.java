package pp.visual.screen;

import pp.main.Data;

import java.awt.*;

/**
 * Class representing line with destination
 *
 * @author Dominik Šalgovič
 */
public class DestinationLine extends TextLine {

    private final int pos;
    private final Data data;

    /**
     * Default constructor
     *
     * @param i    position of line
     * @param data data object
     */
    public DestinationLine(int i, Data data) {
        super(i);
        this.pos = i;
        this.data = data;
        reset();
    }

    /**
     * reset method to print new information from database
     */
    public void reset() {
        this.setText("P C:" + this.data.getCurrent().getDestination());
        Dimension size = this.getPreferredSize();
        this.setBounds(550 - size.width, 10 + pos * (size.height + 10), size.width, size.height);
    }
}
