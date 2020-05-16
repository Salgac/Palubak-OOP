package pp.visual.screen;

import pp.main.Data;

import java.util.Timer;
import java.awt.*;
import java.util.TimerTask;

/**
 * Class containing the logic behind carriage
 *
 * @author Dominik Šalgovič
 */
public class Carriage extends TextLine {

    private final BuseScreen screen;
    private final Timer timer;
    private boolean blick;

    /**
     * Default constructor
     *
     * @param i      line position of carriage
     * @param screen screen that the object is part of
     */
    public Carriage(int i, BuseScreen screen) {
        super(i);
        this.screen = screen;
        this.blick = false;
        this.timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                check();
            }
        }, 0, 750);
    }

    /**
     * Checking method for blicking
     */
    private void check() {
        if (screen.getData().getInputMode() == Data.INPUT_MODE.ON) {
            if (this.blick) {
                this.setText("ô");
                this.blick = false;
            } else {
                this.setText("");
                this.blick = true;
            }
        } else {
            if (!this.getText().equals(""))
                this.setText("");
        }

    }

    /**
     * Method to set stylized text
     *
     * @param text String of new text
     */
    @Override
    public void setText(String text) {
        super.setText(text);
        if (this.screen != null && !text.equals("")) {
            Dimension size = screen.getTextLines().get(0).getPreferredSize();
            Dimension mySize = this.getPreferredSize();
            this.setBounds(10 + size.width - 2 * mySize.width, 10, mySize.width, mySize.height);
        }
    }
}
