package visual;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class BuseButton extends JButton {

    Clip click;

    public BuseButton(int x, int y, String text) {
        this.setBounds(x, y, 100, 100);
        this.setText("");
        this.setIcon(new ImageIcon(getClass().getResource("/resources/button.png")));
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addActionListener(actionEvent -> onclick());
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
