package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

import javax.swing.*;

/**
 * Class for line setting script
 *
 * @author Dominik Šalgovič
 */
public class LineSetScript extends BuseScript implements StagedScript {

    private STAGE stage;
    private String textPrev;

    private boolean saved = false;

    /**
     * default constructor
     *
     * @param button button that the script operates with
     */
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
        this.text = button.getData().getCurrent().getLineCode();
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
        //test for line
        if (saved && button.getData().getCurrent().getLine() == null) {
            button.getData().getScreen().getTextLines().get(0).setText("Neznáma linka");
        }
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
            saved = true;
            button.getData().getCurrent().setCourse(fillText(text));
            button.getData().getCurrent().setLine(fillText(textPrev), "00");
            endStage();
        }
    }

    @Override
    void cancel() {
        saved = false;
        endStage();
    }
}
