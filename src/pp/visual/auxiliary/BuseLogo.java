package pp.visual.auxiliary;

import javax.swing.*;
import java.awt.*;

public class BuseLogo extends JLabel {

    private TYPE type;
    private Dimension size;
    private int x, y;

    public BuseLogo(String text, TYPE type) {
        super(text);
        this.type = type;
        generateText();
    }

    private void generateText() {
        switch (this.type) {
            case BUSE:
                this.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
                this.setForeground(Color.decode("#FFEC00"));
                this.size = this.getPreferredSize();
                this.x = 110;
                this.y = 85;
                break;
            case BS100:
                this.setFont(new Font("Arial Condensed", Font.PLAIN, 20));
                this.setForeground(Color.BLACK);
                this.size = this.getPreferredSize();
                this.x = 670 - size.width;
                this.y = 85;
                break;
        }
        this.setBounds(x, y, size.width + 10, size.height);
    }

    public enum TYPE {
        BUSE,
        BS100
    }
}
