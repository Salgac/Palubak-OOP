package pp.visual.screen;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class TextLine extends JLabel {

    Font font;

    public TextLine(int i) {
        try {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            InputStream stream = new BufferedInputStream(new FileInputStream(path + "/src/pp/resources/pixelmix.ttf"));
            this.font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(this.font);
        } catch (Exception e) {
            System.out.println("Error loading font for display");
            e.printStackTrace();
        }
        this.setFont(font);
        this.setText(i + ". line_abcdefghijkl");

        Dimension size = this.getPreferredSize();
        this.setBounds(10, 5 + i * (size.height + 6), 540, size.height);
        //this.setOpaque(false);
    }
}