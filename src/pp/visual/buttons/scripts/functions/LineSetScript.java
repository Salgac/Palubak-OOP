package pp.visual.buttons.scripts.functions;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.*;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;
import pp.visual.screen.InfoLine;

public class LineSetScript extends BuseScript {

    private STAGE stage;
    private String waiting;

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
        this.stage = STAGE.SECOND;
        this.text = button.getData().getCurrent().getCourse();
        refreshText();
    }

    private void endStage() {
        getTextLine(0).setText("");
        ((InfoLine) getTextLine(3)).reset();
        button.getData().setActiveScript(null);
        button.getData().setInputModeActive(false);
    }

    @Override
    public void refreshText() {
        if (stage == STAGE.FIRST)
            getTextLine(0).setText("Linka: >" + this.text + "<");
        else
            getTextLine(0).setText("Kurz: >" + this.text + "<");
    }

    @Override
    public void accept() {
        if (stage == STAGE.FIRST) {
            waiting = text;
            secondStage();
        } else {
            button.getData().getCurrent().setLine(waiting);
            button.getData().getCurrent().setCourse(text);
            endStage();
        }
    }

    @Override
    public void cancel() {
        endStage();
    }

    private enum STAGE {
        FIRST,
        SECOND
    }
}