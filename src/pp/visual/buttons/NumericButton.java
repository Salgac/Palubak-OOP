package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.*;

import javax.swing.*;
import java.awt.*;

public class NumericButton extends BuseButton {

    private JLabel number;
    private int num;
    private NumberScript numberScript;

    public NumericButton(Data data, int x, int y, String text, String num) {
        super(data, x, y, text);
        drawNumber(num);
        this.num = Integer.parseInt(num);
        this.script = new BuseScript(this, text);
        this.numberScript = new NumberScript(this, this.num);
    }

    @Override
    void onclick() {
        super.onclick();
        if (numberScript != null) {
            numberScript.execute();
        }
    }

    private void drawNumber(String num) {
        number = new JLabel(num);
        number.setFont(new Font("Arial Condensed", Font.BOLD, 37));
        number.setHorizontalAlignment(SwingConstants.RIGHT);
        number.setVerticalAlignment(SwingConstants.BOTTOM);
        this.add(number, BorderLayout.SOUTH);
    }
}
