package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;
import pp.visual.screen.InfoLine;

public class LineSetScript extends BuseScript implements StagedScript {

    private STAGE stage;
    private String textPrev;

    public LineSetScript(BuseButton button) {
        super(button, FUNCTION_TYPE.LINE_SET);
    }

    @Override
    public void execute() {
        button.getData().setActiveScript(this);
        firstStage();
    }

    private void firstStage() {
        this.stage = STAGE.FIRST;
        this.text = button.getData().getCurrent().getLine();
        refreshText();
    }

    private void secondStage() {
        this.button.getData().setInputMode(Data.INPUT_MODE.SHOW);
        this.stage = STAGE.SECOND;
        this.text = button.getData().getCurrent().getCourse();
        refreshText();
    }

    private void endStage() {
        getTextLine(0).setText("");
        button.getData().setActiveScript(null);
        button.getData().setInputMode(Data.INPUT_MODE.OFF);
    }

    @Override
    public void refreshText() {
        if (stage == STAGE.FIRST)
            getTextLine(0).setText("Linka: >" + this.text + "<");
        else
            getTextLine(0).setText("Kurz: >" + this.text + "<");
    }

    @Override
    void accept() {
        if (stage == STAGE.FIRST) {
            textPrev = text;
            secondStage();
        } else {
            button.getData().getCurrent().setLine(fillText(textPrev));
            button.getData().getCurrent().setCourse(fillText(text));
            endStage();
        }
    }

    @Override
    void cancel() {
        endStage();
    }
}
