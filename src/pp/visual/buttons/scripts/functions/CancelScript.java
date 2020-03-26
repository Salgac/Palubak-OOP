package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class CancelScript extends BuseScript {
    public CancelScript(BuseButton button) {
        super(button, FUNCTION_TYPE.ACCEPT);
    }

    @Override
    public void execute() {
        BuseScript activeScript = button.getData().getActiveScript();
        if (activeScript != null)
            activeScript.cancel();
    }

    @Override
    public void refreshText() {

    }

    @Override
    void accept() {

    }

    @Override
    void cancel() {

    }
}
