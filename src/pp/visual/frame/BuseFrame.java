package pp.visual.frame;

import javax.swing.*;
import java.awt.*;

public class BuseFrame extends JFrame {
    public BuseFrame(String text) {
        super(text);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 625);
        this.setLocation(400, 200);
        this.getContentPane().setBackground(Color.decode("#8B949D"));
    }
}
