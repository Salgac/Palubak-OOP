package pp.visual.buttons;

import pp.main.Data;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;
import pp.visual.buttons.scripts.helper.ScriptAssign;

import javax.swing.*;
import java.awt.*;

/**
 * Button class for arrow buttons
 *
 * @author Dominik Šalgovič
 */
public class ArrowButton extends BuseButton {
    private final ARROW type;
    private JLabel image;

    /**
     * Default constructor
     *
     * @param data  data object
     * @param x     x coordinate
     * @param y     y coordinate
     * @param arrow arrow type
     */
    public ArrowButton(Data data, int x, int y, ARROW arrow) {
        super(data, x, y, FUNCTION_TYPE.NULL);
        this.type = arrow;
        this.script = ScriptAssign.assign(this.type, this);
        setImage();
    }

    /**
     * Method for setting the image of arrows
     */
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

    /**
     * onclick override for arrow buttons
     */
    @Override
    void onclick() {
        super.onclick();
        if (script != null)
            script.execute();
    }

    /**
     * Enum to hold arrow types
     */
    public enum ARROW {
        LEFT,
        UP,
        RIGHT,
        DOUBLE_UP,
        DOUBLE_DOWN
    }
}
