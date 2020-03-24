package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.*;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class LineSetScript extends BuseScript {

    FUNCTION_TYPE type;

    public LineSetScript(BuseButton button) {
        super(button);
        this.type = FUNCTION_TYPE.LINE_SET;
    }
}
