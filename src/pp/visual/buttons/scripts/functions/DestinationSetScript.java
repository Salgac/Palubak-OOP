package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;
import pp.visual.screen.DestinationLine;

public class DestinationSetScript extends BuseScript implements StagedScript {

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
