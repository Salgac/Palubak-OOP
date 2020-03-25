package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.BuseScript;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class AcceptScript extends BuseScript {
    public AcceptScript(BuseButton button) {
        super(button, FUNCTION_TYPE.ACCEPT);
    }

    @Override
    public void execute() {
        BuseScript activeScript = button.getData().getActiveScript();
        activeScript.accept();
    }

    @Override
    public void refreshText() {

    }

    @Override
    public void accept() {

    }

    @Override
    public void cancel() {

    }
}
