package pp.visual.buttons.scripts.functions;

import pp.data.stops.Stop;
import pp.lines.TramLine;
import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

/**
 * Class for direction setting script
 *
 * @author Dominik Šalgovič
 */
public class DirectionSetScript extends BuseScript implements StagedScript {

    private STAGE stage;
    private String textDirection;

    private TramLine prevLine;
    private String prevDirection;
    private Stop prevStop;

    /**
     * Default constructor
     *
     * @param button button that the script operates with
     */
    public DirectionSetScript(BuseButton button) {
        super(button, FUNCTION_TYPE.DIRECTION_SET);
    }

    @Override
    public void execute() {
        super.execute();
        button.getData().setActiveScript(this);
        firstStage();
    }

    private void firstStage() {
        this.stage = STAGE.FIRST;
        prevLine = button.getData().getCurrent().getLine();
        if (prevLine == null)
            endStage();
        else {
            this.prevStop = button.getData().getCurrent().getStop();
            this.prevDirection = button.getData().getCurrent().getDirection();
            this.text = prevDirection;
            refreshText();
        }
    }

    private void secondStage() {
        this.stage = STAGE.SECOND;
        this.button.getData().setInputMode(Data.INPUT_MODE.SHOW);
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
                getTextLine(0).setText("Smer: >" + this.text + "<");
                break;
            case SECOND:
                getTextLine(0).setText("Smer OK?");
                //set direction in line
                button.getData().getCurrent().setLine(prevLine.getCode(), this.textDirection);
                break;
        }

    }

    @Override
    void accept() {
        switch (stage) {
            case FIRST:
                textDirection = fillText(text);
                secondStage();

                break;
            case SECOND:
                button.getData().getCurrent().setDirection(textDirection);
                endStage();
                break;
        }
    }

    @Override
    void cancel() {
        switch (stage) {
            case FIRST:
                endStage();
                break;
            case SECOND:
                //set previous line
                button.getData().getCurrent().setLine(prevLine.getCode(), prevDirection);
                button.getData().getCurrent().setStop(prevStop);
                endStage();
                break;
        }
    }
}
