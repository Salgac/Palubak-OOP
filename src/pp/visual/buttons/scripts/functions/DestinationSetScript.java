package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

/**
 * Class for destination setting script
 *
 * @author Dominik Šalgovič
 */
public class DestinationSetScript extends BuseScript implements StagedScript {

    /**
     * Defaul constructor
     *
     * @param button button that the script operates with
     */
    public DestinationSetScript(BuseButton button) {
        super(button, FUNCTION_TYPE.DESTINATION_SET);
    }

    @Override
    public void execute() {
        button.getData().setActiveScript(this);
        firstStage();
    }

    private void firstStage() {
        this.text = button.getData().getCurrent().getDestination();
        refreshText();
    }

    private void endStage() {
        getTextLine(0).setText("");
        button.getData().setActiveScript(null);
        button.getData().setInputMode(Data.INPUT_MODE.OFF);
    }

    @Override
    public void refreshText() {
        getTextLine(0).setText("Ciel: >" + this.text + "<");
    }

    @Override
    void accept() {
        button.getData().getCurrent().setDestination(fillText(text));
        endStage();
    }

    @Override
    void cancel() {
        endStage();
    }
}
