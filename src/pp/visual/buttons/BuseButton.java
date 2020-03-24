package pp.visual.buttons;

import pp.visual.buttons.scripts.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.*;

abstract public class BuseButton extends JButton {

    private Clip click;
    private JLabel label;
    protected BuseScript script = null;
    private String text = "";

    public BuseButton(int x, int y) {
        this.setBounds(x, y, 100, 100);
        this.setLayout(new BorderLayout());
        this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/buttons/button.png")));
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addActionListener(actionEvent -> onclick());
    }

    public BuseButton(int x, int y, String text) {
        this(x, y);
        this.text = text;
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

    private void onclick() {
        if (script != null) {
            playSound();
            script.execute();
        }
    }

    private void playSound() {
        try {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path + "/src/pp/resources/sounds/click.wav"));
            click = AudioSystem.getClip();
            click.open(inputStream);
        } catch (Exception e) {
            System.out.println("Error loading click sound");
            e.printStackTrace();
        }
        click.start();
    }
}
