package visual;

import javax.swing.*;

public class BuseButton extends JButton {

    public BuseButton(int x, int y, String text) {
        this.setBounds(x, y, 100, 100);
        this.setText("");
        this.setIcon(new ImageIcon(getClass().getResource("/resources/button.png")));
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }

    void onclick() {

    }
}
