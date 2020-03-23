package pp.visual.buttons;

import javax.swing.*;
import java.awt.*;

public class NumericButton extends BuseButton {

    JLabel number;

    public NumericButton(int x, int y, String text, String num) {
        super(x, y, text);
        drawNumber(num);
    }

    private void drawNumber(String num) {
        number = new JLabel(num);
        number.setFont(new Font("Arial Condensed", Font.BOLD, 37));
        number.setHorizontalAlignment(SwingConstants.RIGHT);
        number.setVerticalAlignment(SwingConstants.BOTTOM);
        this.add(number, BorderLayout.SOUTH);
    }
}
