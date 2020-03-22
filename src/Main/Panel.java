package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Visual.*;

public class Panel {
    private JFrame frame;
    private JTextArea display;
    private ArrayList<JButton> buttons;
    //Button[] buttons;
    //Window window;

    public Panel(){
        frame = new JFrame("Palubný počítač");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,600);

        display = new JTextArea();
        display.setBounds(50,40,780,350);
        display.setBackground(Color.lightGray);
        frame.add(display);

        buttons = new ArrayList<>();
        generateButtons();
        for (JButton button : buttons) frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void generateButtons(){
        JButton nehoda = new JButton("Nehoda");
        nehoda.setBounds(860,40,100,100);
        buttons.add(nehoda);

        JButton button1 = new JButton("1");
        button1.setBounds(990,40,100,100);
        buttons.add(button1);

        JButton button2 = new JButton("2");
        button2.setBounds(1120,40,100,100);
        buttons.add(button2);

        JButton button3 = new JButton("3");
        button3.setBounds(1250,40,100,100);
        buttons.add(button3);

        JButton sprava = new JButton("Kodova sprava");
        sprava.setBounds(860,170,100,100);
        buttons.add(sprava);

        JButton button4 = new JButton("4");
        button4.setBounds(990,170,100,100);
        buttons.add(button4);

        JButton button5 = new JButton("5");
        button5.setBounds(1120,170,100,100);
        buttons.add(button5);

        JButton button6 = new JButton("6");
        button6.setBounds(1250,170,100,100);
        buttons.add(button6);

        JButton revizor = new JButton("Revizor");
        revizor.setBounds(860,300,100,100);
        buttons.add(revizor);

        JButton button7 = new JButton("7");
        button7.setBounds(990,300,100,100);
        buttons.add(button7);

        JButton button8 = new JButton("8");
        button8.setBounds(1120,300,100,100);
        buttons.add(button8);

        JButton button9 = new JButton("9");
        button9.setBounds(1250,300,100,100);
        buttons.add(button9);

        JButton left = new JButton("left");
        left.setBounds(340,430,100,100);
        buttons.add(left);

        JButton up = new JButton("up");
        up.setBounds(470,430,100,100);
        buttons.add(up);

        JButton right = new JButton("right");
        right.setBounds(600,430,100,100);
        buttons.add(right);

        JButton doubleDown = new JButton("DownDown");
        doubleDown.setBounds(730,430,100,100);
        buttons.add(doubleDown);

        JButton doubleUp = new JButton("UpUp");
        doubleUp.setBounds(860,430,100,100);
        buttons.add(doubleUp);

        JButton zrusit = new JButton("zrusit");
        zrusit.setBounds(990,430,100,100);
        buttons.add(zrusit);

        JButton button0 = new JButton("0");
        button0.setBounds(1120,430,100,100);
        buttons.add(button0);

        JButton potvrdit = new JButton("potvrdit");
        potvrdit.setBounds(1250,430,100,100);
        buttons.add(potvrdit);
    }
}
