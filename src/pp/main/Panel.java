package pp.main;

import javax.swing.*;
import java.util.ArrayList;

import pp.visual.frame.*;
import pp.visual.auxiliary.*;
import pp.visual.buttons.*;
import pp.visual.screen.*;

class Panel {
    private JFrame frame;
    private JPanel display;
    private ArrayList<BuseButton> buttons = new ArrayList<>();
    private Data data;
    private boolean inputMode = false;

    Panel(Data data) {
        this.data = data;
        generateFrame();

        generateTextures();

        generateDisplay();

        generateButtons();

        connectData();

        frame.setVisible(true);
    }

    private void generateFrame() {
        frame = new BuseFrame("Palubný počítač");
    }

    private void generateTextures() {
        frame.add(new RoundedRectangle(50, 50, 680, 315, "#F1F1F1"));
        frame.add(new RoundedRectangle(750, 30, 120, 250, "#E16472", 8));

        frame.add(new BuseLogo("BUSE", BuseLogo.TYPE.BUSE));
        frame.add(new BuseLogo("BS 100", BuseLogo.TYPE.BS100));

        frame.add(new BuseKey());
    }

    private void generateDisplay() {
        display = new BuseScreen(110, 110);
        frame.add(display);
        frame.add(new RoundedRectangle(110, 110, 560, 200, "#8AA230", "#000000", 1));
    }

    private void generateButtons() {
        buttons.add(new BasicButton(data, 760, 40, "NEHODA"));
        buttons.add(new NumericButton(data, 890, 40, "LINKA PORADIE", "1"));
        buttons.add(new NumericButton(data, 1020, 40, "CIEĽ", "2"));
        buttons.add(new NumericButton(data, 1150, 40, "SLUŽBA VODIČ", "3"));
        buttons.add(new BasicButton(data, 760, 170, "KÓDOVÁ SPRÁVA"));
        buttons.add(new NumericButton(data, 890, 170, "", "4"));
        buttons.add(new NumericButton(data, 1020, 170, "PÁSMO", "5"));
        buttons.add(new NumericButton(data, 1150, 170, "SPOJ SMER", "6"));
        buttons.add(new BasicButton(data, 760, 300, "REVÍZOR"));
        buttons.add(new NumericButton(data, 890, 300, "ODKLON", "7"));
        buttons.add(new NumericButton(data, 1020, 300, "RUČNE", "8"));
        buttons.add(new NumericButton(data, 1150, 300, "ZASTÁVKA", "9"));
        buttons.add(new ArrowButton(data, 240, 430, ArrowButton.ARROW.LEFT));
        buttons.add(new ArrowButton(data, 370, 430, ArrowButton.ARROW.UP));
        buttons.add(new ArrowButton(data, 500, 430, ArrowButton.ARROW.RIGHT));
        buttons.add(new ArrowButton(data, 630, 430, ArrowButton.ARROW.DOUBLE_DOWN));
        buttons.add(new ArrowButton(data, 760, 430, ArrowButton.ARROW.DOUBLE_UP));
        buttons.add(new BasicButton(data, 890, 430, "ZRUŠIŤ", true));
        buttons.add(new NumericButton(data, 1020, 430, "SERVIS", "0"));
        buttons.add(new BasicButton(data, 1150, 430, "POTVRDIŤ", true));

        for (JButton button : buttons) frame.add(button);
    }

    private void connectData() {
        data.setScreen((BuseScreen) display);
    }
}
