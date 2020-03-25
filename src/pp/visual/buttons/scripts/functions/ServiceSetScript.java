package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class ServiceSetScript extends BuseScript implements StagedScript {

    public ServiceSetScript(BuseButton button) {
        super(button, FUNCTION_TYPE.LINE_SET);
    }

    private STAGE stage;
    private String textPrev;

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
        this.stage = STAGE.SECOND;
        this.text = button.getData().getCurrent().getDriver();
        refreshText();
    }

    private void thirdStage() {
        this.stage = STAGE.THIRD;
        refreshText();
    }

    private void endStage() {
        getTextLine(0).setText("");
        button.getData().setActiveScript(null);
        button.getData().setInputModeActive(false);
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
                getTextLine(0).setText("Služba " + this.textPrev + " OK?");
                break;
        }
    }

    @Override
    void accept() {
        switch (stage) {
            case FIRST:
                textPrev = text;
                secondStage();
                break;
            case SECOND:
                button.getData().setInputModeActive(false);
                thirdStage();
                break;
            case THIRD:
                button.getData().getCurrent().setService(textPrev);
                button.getData().getCurrent().setDriver(text);
                endStage();
                break;
        }
    }

    @Override
    void cancel() {
        endStage();
    }
}
