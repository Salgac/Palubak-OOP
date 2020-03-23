package pp.visual.auxiliary;

import javax.swing.*;
import java.awt.*;

public class RoundedRectangle extends JPanel {

    Color lncolor, bgcolor;
    int stroke;
    boolean transparentbg;

    public RoundedRectangle(int x, int y, int width, int height, String lncolor) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.lncolor = Color.decode(lncolor);
        this.stroke = 5;
        this.transparentbg = true;
    }

    public RoundedRectangle(int x, int y, int width, int height, String lncolor, int stroke) {
        this(x, y, width, height, lncolor);
        this.stroke = stroke;
    }

    public RoundedRectangle(int x, int y, int width, int height, String bgcolor, String lncolor, int stroke) {
        this(x, y, width, height, lncolor, stroke);
        this.transparentbg = false;
        this.bgcolor = Color.decode(bgcolor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(stroke * 5, stroke * 5);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setStroke(new BasicStroke(stroke));
        if (transparentbg) {
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.f));
        } else {
            graphics.setColor(bgcolor);
        }
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.f));
        graphics.setColor(lncolor);

        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }
}
