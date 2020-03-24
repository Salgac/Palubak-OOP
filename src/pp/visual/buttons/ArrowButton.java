package pp.visual.buttons;

import pp.main.Data;

import javax.swing.*;
import java.awt.*;

public class ArrowButton extends BuseButton {
    private ARROW type;
    private JLabel image;

    public ArrowButton(Data data, int x, int y, ARROW arrow) {
        super(data, x, y);
        this.type = arrow;
        setImage();
    }

    private void setImage() {
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
                throw new IllegalStateException("Unexpected value: " + this.type);
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
