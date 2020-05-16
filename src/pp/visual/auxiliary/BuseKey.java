package pp.visual.auxiliary;

import javax.swing.*;

/**
 * Auxiliary class containing key texture and position
 *
 * @author Dominik Šalgovič
 */
public class BuseKey extends JLabel {
    /**
     * Basic constructor initialising resources
     */
    public BuseKey() {
        this.setIcon(new ImageIcon(getClass().getResource("/pp/resources/key.png")));
        this.setBounds(50, 405, 150, 150);
    }
}
