package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class ServiceSetScript extends BuseScript implements StagedScript {

    public ServiceSetScript(BuseButton button) {
        super(button, FUNCTION_TYPE.LINE_SET);
    }

    private STAGE stage;
    private String textService, textDriver;

    @Override
    public void execute() {
        button.getData().setActiveScript(this);
        firstStage();
    }

    private void firstStage() {
        this.stage = STAGE.FIRST;
        this.text = button.getData().getCurrent().getService();
        refreshText();
    }

    private void secondStage() {
        this.button.getData().setInputMode(Data.INPUT_MODE.SHOW);
        this.stage = STAGE.SECOND;
        this.text = button.getData().getCurrent().getDriver();
        refreshText();
    }

    private void thirdStage() {
        this.button.getData().setInputMode(Data.INPUT_MODE.SHOW);
        this.stage = STAGE.THIRD;
        refreshText();
    }

    private void endStage() {
        getTextLine(0).setText("");
        button.getData().setActiveScript(null);
        button.getData().setInputMode(Data.INPUT_MODE.OFF);
    }

    @Override
    public void refreshText() {
        switch (stage) {
            case FIRST:
                getTextLine(0).setText("Služba: >" + this.text + "<");
                break;
            case SECOND:
                getTextLine(0).setText("Vodič: >" + this.text + "<");
                break;
            case THIRD:
                getTextLine(0).setText("Služba " + this.textService + " OK?");
                break;
        }
    }

    @Override
    void accept() {
        switch (stage) {
            case FIRST:
                textService = fillText(text);
                secondStage();
                break;
            case SECOND:
                textDriver = fillText(text);
                thirdStage();
                break;
            case THIRD:
                button.getData().getCurrent().setService(textService);
                button.getData().getCurrent().setDriver(textDriver);
                endStage();
                break;
        }
    }

    @Override
    void cancel() {
        endStage();
    }
}
