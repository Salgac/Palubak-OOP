package pp.visual.auxiliary;

import javax.swing.*;

public class BuseKey extends JLabel {
    public BuseKey() {
        this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/key.png")));
        this.setBounds(50, 405, 150, 150);
    }
}
