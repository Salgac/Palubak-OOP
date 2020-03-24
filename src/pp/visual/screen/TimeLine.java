package pp.visual.screen;

import javax.swing.Timer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeLine extends TextLine {

    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private int currentSecond;
    private Calendar calendar;
    private int pos;

    public TimeLine(int i) {
        super(i);
        this.pos = i;
        start();
    }

    private void reset() {
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }

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

    private void updateText() {
        this.setText(String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond));
        Dimension size = this.getPreferredSize();
        this.setBounds(540 - size.width, 5 + pos * (size.height + 6), 540, size.height);
    }
}
