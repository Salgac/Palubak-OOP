package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

/**
 * Class for cancel script
 *
 * @author Dominik Šalgovič
 */
public class CancelScript extends BuseScript {
    /**
     * Default constructor
     *
     * @param button button that the script belongs to
     */
    public CancelScript(BuseButton button) {
        super(button, FUNCTION_TYPE.ACCEPT);
    }

    /**
     * Execution override
     */
    @Override
    public void execute() {
        //launch cancel() methor of the active script
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
