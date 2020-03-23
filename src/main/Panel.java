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
        buttons.add(new BuseButton(860, 40, "Porucha"));
        buttons.add(new BuseButton(990, 40, "1"));
        buttons.add(new BuseButton(1120, 40, "2"));
        buttons.add(new BuseButton(1250, 40, "3"));
        buttons.add(new BuseButton(860, 170, "Kod. sprava"));
        buttons.add(new BuseButton(990, 170, "4"));
        buttons.add(new BuseButton(1120, 170, "5"));
        buttons.add(new BuseButton(1250, 170, "6"));
        buttons.add(new BuseButton(860, 300, "Revizor"));
        buttons.add(new BuseButton(990, 300, "7"));
        buttons.add(new BuseButton(1120, 300, "8"));
        buttons.add(new BuseButton(1250, 300, "9"));
        buttons.add(new BuseButton(340, 430, "left"));
        buttons.add(new BuseButton(470, 430, "up"));
        buttons.add(new BuseButton(600, 430, "right"));
        buttons.add(new BuseButton(730, 430, "downdown"));
        buttons.add(new BuseButton(860, 430, "upup"));
        buttons.add(new BuseButton(990, 430, "zrusit"));
        buttons.add(new BuseButton(1120, 430, "0"));
        buttons.add(new BuseButton(1250, 430, "Potvrdit"));

        for (JButton button : buttons) frame.add(button);
    }
}
