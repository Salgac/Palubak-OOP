package visual;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class BuseButton extends JButton {

    Clip click;
    JLabel label;

    public BuseButton(int x, int y) {
        this.setBounds(x, y, 100, 100);
        this.setLayout(new BorderLayout());
        this.setIcon(new ImageIcon(getClass().getResource("/resources/button.png")));
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addActionListener(actionEvent -> onclick());
    }

    public BuseButton(int x, int y, String text) {
        this(x, y);
        drawText(text);
    }

    private void drawText(String text) {
        this.setMargin(new Insets(5, 5, 5, 5));
        label = new JLabel("<html>" + text.replaceAll(" ", "<br>") + "</html>");
        label.setFont(new Font("Arial Condensed", Font.PLAIN, 17));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        this.add(label, BorderLayout.NORTH);
    }

    void onclick() {
        playSound();
    }

    void playSound() {
        try {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path + "/src/resources/click.wav"));
            click = AudioSystem.getClip();
            click.open(inputStream);
        } catch (Exception e) {
            System.out.println("Error loading click sound");
            e.printStackTrace();
        }

        click.start();
    }
}
