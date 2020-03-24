package pp.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import pp.visual.auxiliary.*;
import pp.visual.buttons.*;
import pp.visual.screen.*;

class Panel {
    private JFrame frame;
    private JPanel display;
    private ArrayList<BuseButton> buttons = new ArrayList<>();

    Panel() {
        generateFrame();

        generateTextures();

        generateDisplay();

        generateButtons();

        frame.setVisible(true);
    }

    private void generateFrame() {
        frame = new JFrame("Palubný počítač");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 625);
        frame.setLocation(400, 200);
        frame.getContentPane().setBackground(Color.decode("#8B949D"));
    }

    private void generateTextures() {
        frame.add(new RoundedRectangle(50, 50, 680, 315, "#F1F1F1"));
        frame.add(new RoundedRectangle(750, 30, 120, 250, "#E16472", 8));

        JLabel buse = new JLabel("BUSE");
        buse.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
        buse.setForeground(Color.decode("#FFEC00"));
        Dimension size = buse.getPreferredSize();
        buse.setBounds(110, 85, size.width + 10, size.height);
        frame.add(buse);

        JLabel bs = new JLabel("BS 100");
        bs.setFont(new Font("Arial Condensed", Font.PLAIN, 20));
        bs.setForeground(Color.BLACK);
        size = bs.getPreferredSize();
        bs.setBounds(670 - size.width, 85, size.width, size.height);
        frame.add(bs);

        JLabel key = new JLabel();
        key.setIcon(new ImageIcon(getClass().getResource("/pp/resources/key.png")));
        key.setBounds(50, 405, 150, 150);
        frame.add(key);
    }

    private void generateDisplay() {
        display = new BuseScreen(110, 110);
        frame.add(display);
        frame.add(new RoundedRectangle(110, 110, 560, 200, "#8AA230", "#000000", 1));
    }

    private void generateButtons() {
        buttons.add(new BasicButton(760, 40, "NEHODA"));
        buttons.add(new NumericButton(890, 40, "LINKA PORADIE", "1"));
        buttons.add(new NumericButton(1020, 40, "CIEĽ", "2"));
        buttons.add(new NumericButton(1150, 40, "SLUŽBA VODIČ", "3"));
        buttons.add(new BasicButton(760, 170, "KÓDOVÁ SPRÁVA"));
        buttons.add(new NumericButton(890, 170, "", "4"));
        buttons.add(new NumericButton(1020, 170, "PÁSMO", "5"));
        buttons.add(new NumericButton(1150, 170, "SPOJ SMER", "6"));
        buttons.add(new BasicButton(760, 300, "REVÍZOR"));
        buttons.add(new NumericButton(890, 300, "ODKLON", "7"));
        buttons.add(new NumericButton(1020, 300, "RUČNE", "8"));
        buttons.add(new NumericButton(1150, 300, "ZASTÁVKA", "9"));
        buttons.add(new ArrowButton(240, 430, ArrowButton.ARROW.LEFT));
        buttons.add(new ArrowButton(370, 430, ArrowButton.ARROW.UP));
        buttons.add(new ArrowButton(500, 430, ArrowButton.ARROW.RIGHT));
        buttons.add(new ArrowButton(630, 430, ArrowButton.ARROW.DOUBLE_DOWN));
        buttons.add(new ArrowButton(760, 430, ArrowButton.ARROW.DOUBLE_UP));
        buttons.add(new BasicButton(890, 430, "ZRUŠIŤ"));
        buttons.add(new NumericButton(1020, 430, "SERVIS", "0"));
        buttons.add(new BasicButton(1150, 430, "POTVRDIŤ"));

        for (JButton button : buttons) frame.add(button);
    }
}
