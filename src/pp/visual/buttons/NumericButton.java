package pp.visual.buttons;

import pp.visual.buttons.scripts.*;

import javax.swing.*;
import java.awt.*;

public class NumericButton extends BuseButton {

    private JLabel number;
    private int num;
    private NumberScript numberScript;

    public NumericButton(int x, int y, String text, String num) {
        super(x, y, text);
        drawNumber(num);
        this.num = Integer.parseInt(num);
        this.script = new BuseScript(text);
        this.numberScript = new NumberScript(this.num);
    }

    private void drawNumber(String num) {
        number = new JLabel(num);
        number.setFont(new Font("Arial Condensed", Font.BOLD, 37));
        number.setHorizontalAlignment(SwingConstants.RIGHT);
        number.setVerticalAlignment(SwingConstants.BOTTOM);
        this.add(number, BorderLayout.SOUTH);
    }
}
