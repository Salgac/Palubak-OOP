package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import visual.*;

public class Panel {
    private JFrame frame;
    private JPanel display;
    private ArrayList<BuseButton> buttons = new ArrayList<>();

    public Panel() {
        generateFrame();

        generateDisplay();

        generateButtons();

        frame.setVisible(true);
    }

    private void generateFrame() {
        frame = new JFrame("Palubný počítač");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 600);
        frame.getContentPane().setBackground(Color.decode("#8B949D"));
    }

    private void generateDisplay() {
        display = new BusePanel();
        display.setBounds(50, 40, 780, 350);
        frame.add(display);
    }

    private void generateButtons() {
        buttons.add(new BasicButton(860, 40, "NEHODA"));
        buttons.add(new NumericButton(990, 40, "LINKA PORADIE", "1"));
        buttons.add(new NumericButton(1120, 40, "CIEĽ", "2"));
        buttons.add(new NumericButton(1250, 40, "SLUŽBA VODIČ", "3"));
        buttons.add(new BasicButton(860, 170, "KÓDOVÁ SPRÁVA"));
        buttons.add(new NumericButton(990, 170, "", "4"));
        buttons.add(new NumericButton(1120, 170, "PÁSMO", "5"));
        buttons.add(new NumericButton(1250, 170, "SPOJ SMER", "6"));
        buttons.add(new BasicButton(860, 300, "REVÍZOR"));
        buttons.add(new NumericButton(990, 300, "ODKLON", "7"));
        buttons.add(new NumericButton(1120, 300, "RUČNE", "8"));
        buttons.add(new NumericButton(1250, 300, "ZASTÁVKA", "9"));
        buttons.add(new ArrowButton(340, 430, "left"));
        buttons.add(new ArrowButton(470, 430, "up"));
        buttons.add(new ArrowButton(600, 430, "right"));
        buttons.add(new ArrowButton(730, 430, "downdown"));
        buttons.add(new ArrowButton(860, 430, "upup"));
        buttons.add(new BasicButton(990, 430, "ZRUŠIŤ"));
        buttons.add(new NumericButton(1120, 430, "SERVIS", "0"));
        buttons.add(new BasicButton(1250, 430, "POTVRDIŤ"));

        for (JButton button : buttons) frame.add(button);
    }
}
