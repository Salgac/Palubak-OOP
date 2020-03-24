package pp.visual.screen;

import javax.swing.*;
import java.util.ArrayList;

public class BuseScreen extends JPanel {

    private ArrayList<JLabel> textLines;

    public BuseScreen(int x, int y) {
        this.setBounds(x, y, 560, 200);
        this.setLayout(null);
        this.setOpaque(false);
        this.textLines = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            this.textLines.add(new TextLine(i));

        for (JLabel textLine : textLines) this.add(textLine);
    }
}
