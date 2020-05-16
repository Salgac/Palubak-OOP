package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

/**
 * Class for accept script
 *
 * @author Dominik Šalgovič
 */
public class AcceptScript extends BuseScript {
    /**
     * Defaul constructor
     *
     * @param button button that the script belongs to
     */
    public AcceptScript(BuseButton button) {
        super(button, FUNCTION_TYPE.ACCEPT);
    }

    /**
     * execution override
     */
    @Override
    public void execute() {
        BuseScript activeScript = button.getData().getActiveScript();
        if (activeScript != null)
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
