package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.functions.BuseScript;
import pp.visual.buttons.scripts.helper.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.*;

/**
 * Class styling the basic JButton to fit buse window
 *
 * @author Dominik Šalgovič
 */
abstract public class BuseButton extends JButton {

    private Clip click;
    private JLabel label;
    private final Data data;
    protected BuseScript script;

    /**
     * Default button constructor that loads and setups the button
     *
     * @param data data object
     * @param x    x coordinate
     * @param y    y coordinate
     * @param type type of button function
     */
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

        try {
            loadResources();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor that sets the text of button
     *
     * @param data data object
     * @param x    x coordinate
     * @param y    y coordinate
     * @param text text of button
     * @param type type of button function
     */
    public BuseButton(Data data, int x, int y, String text, FUNCTION_TYPE type) {
        this(data, x, y, type);
        drawText(text);
    }

    /**
     * Method to draw text on button
     *
     * @param text text to be drawn
     */
    private void drawText(String text) {
        this.setMargin(new Insets(5, 5, 5, 5));
        label = new JLabel("<html>" + text.replaceAll(" ", "<br>") + "</html>");
        label.setFont(new Font("Arial Condensed", Font.PLAIN, 17));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        this.add(label, BorderLayout.NORTH);
    }

    /**
     * function to be executed on action event
     */
    void onclick() {
        playSound();
        if (script != null && data.getInputMode() == Data.INPUT_MODE.OFF) {
            script.execute();
        }
    }

    /**
     * Auxiliary method for loading sound resources
     *
     * @throws NoAudioLoadedException audio not loaded
     */
    private void loadResources() throws NoAudioLoadedException {
        try {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path + "/src/pp/resources/sounds/click.wav"));
            click = AudioSystem.getClip();
            click.open(inputStream);
        } catch (Exception e) {
            throw new NoAudioLoadedException("Error loading click sound", e);
        }
    }

    /**
     * Method that plays sound effect
     */
    private void playSound() {
        click.setFramePosition(0);
        click.start();
    }

    /**
     * Getter for data
     *
     * @return data object
     */
    public Data getData() {
        return data;
    }
}
