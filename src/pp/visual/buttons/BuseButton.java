package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.*;
import pp.visual.buttons.scripts.helper.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.*;

abstract public class BuseButton extends JButton {

    private Clip click;
    private JLabel label;
    private Data data;
    protected BuseScript script;
    private String text = "";

    public BuseButton(Data data, int x, int y, FUNCTION_TYPE type) {
        this.setBounds(x, y, 100, 100);
        this.setLayout(new BorderLayout());
        this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/buttons/button.png")));
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.data = data;
        this.script = ScriptAssign.assign(type, this);

        this.addActionListener(actionEvent -> onclick());
    }

    public BuseButton(Data data, int x, int y, String text, FUNCTION_TYPE type) {
        this(data, x, y, type);
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

    void onclick() {
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

    public Data getData() {
        return data;
    }

    public String textGet() {
        return text;
    }
}
