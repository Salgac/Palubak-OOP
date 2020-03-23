package pp.visual.buttons;

import javax.swing.*;
import java.awt.*;

public class ArrowButton extends BuseButton {
    ARROW type;
    JLabel image;

    public ArrowButton(int x, int y, ARROW arrow) {
        super(x, y);
        this.type = arrow;
        String path;
        switch (this.type) {
            case LEFT:
                path = "/pp/resources/arrows/arrow_left.png";
                break;
            case UP:
                path = "/pp/resources/arrows/arrow_up.png";
                break;
            case RIGHT:
                path = "/pp/resources/arrows/arrow_right.png";
                break;
            case DOUBLE_UP:
                path = "/pp/resources/arrows/double_arrow_up.png";
                break;
            case DOUBLE_DOWN:
                path = "/pp/resources/arrows/double_arrow_down.png";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + arrow);
        }

        this.setMargin(new Insets(0, 0, 0, 0));
        image = new JLabel();
        image.setIcon(new ImageIcon(getClass().getResource(path)));
        this.add(image);
    }

    public enum ARROW {
        LEFT,
        UP,
        RIGHT,
        DOUBLE_UP,
        DOUBLE_DOWN
    }
}
