package pp.visual.screen;

import javax.swing.*;
import java.util.ArrayList;

public class BuseScreen extends JPanel {

    private ArrayList<JLabel> textLines;

    public BuseScreen(int x, int y) {
        this.setBounds(x, y, 560, 200);
        this.setLayout(null);
        this.setOpaque(false);

        generateTextLines();
    }

    private void generateTextLines() {
        this.textLines = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            this.textLines.add(new TextLine(i));
        this.textLines.add(new TimeLine(3));
        for (JLabel textLine : textLines) this.add(textLine);
    }

    public ArrayList<JLabel> getTextLines() {
        return textLines;
    }
}
