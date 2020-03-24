package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.*;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class DestinationSetScript extends BuseScript {

    FUNCTION_TYPE type;

    public DestinationSetScript(BuseButton button) {
        super(button);
        this.type = FUNCTION_TYPE.LINE_SET;
    }
}
