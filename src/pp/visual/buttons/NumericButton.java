package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.*;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;
import java.awt.*;

public class NumericButton extends BuseButton {

    private JLabel number;
    private int num;
    private NumberScript numberScript;
    private Data data;

    public NumericButton(Data data, int x, int y, String text, String num, FUNCTION_TYPE type) {
        super(data, x, y, text, type);
        this.num = Integer.parseInt(num);
        this.data = data;
        this.numberScript = new NumberScript(this);
        drawNumber(num);
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

    public int getNum() {
        return num;
    }
}
