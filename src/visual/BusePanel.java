package visual;

import javax.swing.*;
import java.awt.*;

public class BusePanel extends JPanel {
    public BusePanel() {
        this.setBounds(50, 40, 780, 350);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(30, 30);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setStroke(new BasicStroke(7));
        graphics.setColor(Color.decode("#8B949D"));
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics.setColor(Color.decode("#F1F1F1"));
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }
}
