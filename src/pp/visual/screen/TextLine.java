package pp.visual.screen;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

/**
 * Default text line of screen
 *
 * @author Dominik Šalgovič
 */
public class TextLine extends JLabel {

    private Font font;
    private final int i;

    /**
     * default constructor
     *
     * @param i position of line
     */
    public TextLine(int i) {
        loadFont();
        this.i = i;
        this.setFont(font);
    }

    /**
     * method overriding default setText
     *
     * @param text new string
     */
    @Override
    public void setText(String text) {
        super.setText(text);
        Dimension size = this.getPreferredSize();
        this.setBounds(10, 10 + i * (size.height + 10), size.width, size.height);
    }

    /**
     * Method to load font resources
     */
    private void loadFont() {
        try {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            InputStream stream = new BufferedInputStream(new FileInputStream(path + "/src/pp/resources/pixelmixMono.ttf"));
            this.font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(36f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(this.font);
        } catch (Exception e) {
            System.out.println("Error loading font for display");
            e.printStackTrace();
        }
    }
}
