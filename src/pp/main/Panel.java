package pp.main;

import javax.swing.*;
import java.util.ArrayList;

import static pp.visual.buttons.scripts.helper.FUNCTION_TYPE.*;
import pp.visual.frame.*;
import pp.visual.auxiliary.*;
import pp.visual.buttons.*;
import pp.visual.screen.*;

/**
 * Main class containig the main aplication window
 *
 * @author Dominik Šalgovič
 */
class Panel {
    private JFrame frame;
    private JPanel display;
    private final ArrayList<BuseButton> buttons = new ArrayList<>();
    private final Data data;

    /**
     * Default constructor generating all the required resources for proper generation of main screen
     *
     * @param data database object
     */
    Panel(Data data) {
        this.data = data;
        generateFrame();

        generateTextures();

        generateDisplay();

        generateButtons();

        connectData();

        frame.setVisible(true);
    }

    /**
     * Method used to generate main application frame
     */
    private void generateFrame() {
        frame = new BuseFrame("Palubný počítač");
    }

    /**
     * Method generating additional textures into main frame
     */
    private void generateTextures() {
        //texture outlines
        frame.add(new RoundedRectangle(50, 50, 680, 315, "#F1F1F1"));
        frame.add(new RoundedRectangle(750, 30, 120, 250, "#E16472", 8));

        //logos
        frame.add(new BuseLogo("BUSE", BuseLogo.TYPE.BUSE));
        frame.add(new BuseLogo("BS 100", BuseLogo.TYPE.BS100));

        //key image
        frame.add(new BuseKey());
    }

    /**
     * Method generating main display into frame
     */
    private void generateDisplay() {
        display = new BuseScreen(110, 110, data);
        frame.add(display);
        frame.add(new RoundedRectangle(110, 110, 560, 200, "#8AA230", "#000000", 1));
    }

    /**
     * Method generating all buttons with their appropriate scripts
     */
    private void generateButtons() {
        //buttons from upper left
        buttons.add(new BasicButton(data, 760, 40, "NEHODA", ACCIDENT));
        buttons.add(new NumericButton(data, 890, 40, "LINKA PORADIE", "1", LINE_SET));
        buttons.add(new NumericButton(data, 1020, 40, "CIEĽ", "2", DESTINATION_SET));
        buttons.add(new NumericButton(data, 1150, 40, "SLUŽBA VODIČ", "3", SERVICE_SET));
        buttons.add(new BasicButton(data, 760, 170, "KÓDOVÁ SPRÁVA", CODE_MESSAGE));
        buttons.add(new NumericButton(data, 890, 170, "", "4", NULL));
        buttons.add(new NumericButton(data, 1020, 170, "PÁSMO", "5", ZONE_SET));
        buttons.add(new NumericButton(data, 1150, 170, "SPOJ SMER", "6", DIRECTION_SET));
        buttons.add(new BasicButton(data, 760, 300, "REVÍZOR", REVISION));
        buttons.add(new NumericButton(data, 890, 300, "ODKLON", "7", DIVERSION));
        buttons.add(new NumericButton(data, 1020, 300, "RUČNE", "8", MANUALLY));
        buttons.add(new NumericButton(data, 1150, 300, "ZASTÁVKA", "9", STOP));
        buttons.add(new ArrowButton(data, 240, 430, ArrowButton.ARROW.LEFT));
        buttons.add(new ArrowButton(data, 370, 430, ArrowButton.ARROW.UP));
        buttons.add(new ArrowButton(data, 500, 430, ArrowButton.ARROW.RIGHT));
        buttons.add(new ArrowButton(data, 630, 430, ArrowButton.ARROW.DOUBLE_DOWN));
        buttons.add(new ArrowButton(data, 760, 430, ArrowButton.ARROW.DOUBLE_UP));
        buttons.add(new BasicButton(data, 890, 430, "ZRUŠIŤ", CANCEL, true));
        buttons.add(new NumericButton(data, 1020, 430, "SERVIS", "0", SERVICE));
        buttons.add(new BasicButton(data, 1150, 430, "POTVRDIŤ", ACCEPT, true));

        for (JButton button : buttons) frame.add(button);
    }

    /**
     * Helper method that connects the database with window frame
     */
    private void connectData() {
        data.setScreen((BuseScreen) display);
    }
}
