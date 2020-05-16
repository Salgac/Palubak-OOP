package pp.visual.screen;

import javax.swing.Timer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class containing logic for digital clock
 *
 * @author Dominik Šalgovič
 */
public class TimeLine extends TextLine {

    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private int currentSecond;
    private Calendar calendar;
    private int pos;

    /**
     * default constructor
     *
     * @param i position of line
     */
    public TimeLine(int i) {
        super(i);
        this.pos = i;
        start();
    }

    /**
     * Method to reset the clock
     */
    private void reset() {
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }

    /**
     * method to start clock
     */
    private void start() {
        reset();
        Timer timer = new Timer(1000, actionEvent -> {
            if (currentSecond == 60) {
                reset();
            }
            updateText();
            currentSecond++;
        });
        timer.start();
    }

    /**
     * method to update the text of line
     */
    private void updateText() {
        this.setText(String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond));
        Dimension size = this.getPreferredSize();
        this.setBounds(550 - size.width, 10 + pos * (size.height + 10), size.width, size.height);
    }
}
