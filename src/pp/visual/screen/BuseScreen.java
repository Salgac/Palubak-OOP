package pp.visual.screen;

import pp.main.Data;

import javax.swing.*;
import java.util.ArrayList;

public class BuseScreen extends JPanel {

    private ArrayList<JLabel> textLines;
    private Data data;

    public BuseScreen(int x, int y, Data data) {
        this.setBounds(x, y, 560, 200);
        this.setLayout(null);
        this.setOpaque(false);
        this.data = data;
        generateTextLines();
    }

    private void generateTextLines() {
        this.textLines = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            //generates 3 functional lines
            this.textLines.add(new TextLine(i));
        //Current stop line
        this.textLines.add(new StopLine(1, data));
        //Destination line
        this.textLines.add(new DestinationLine(2, data));
        //L and Z line
        this.textLines.add(new InfoLine(3, data));
        //Time
        this.textLines.add(new TimeLine(3));
        //flashing carriage
        this.textLines.add(new Carriage(0, this));

        for (JLabel textLine : textLines) this.add(textLine);
    }

    public Data getData() {
        return data;
    }

    public ArrayList<JLabel> getTextLines() {
        return textLines;
    }
}
