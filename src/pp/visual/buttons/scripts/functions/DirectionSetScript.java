package pp.visual.buttons.scripts.functions;

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

    /**
     * Default constructor
     *
     * @param button button that the script operates with
     */
    public DirectionSetScript(BuseButton button) {
        super(button, FUNCTION_TYPE.DESTINATION_SET);
    }

    @Override
    public void execute() {
        button.getData().setActiveScript(this);
        firstStage();
    }

    private void firstStage() {
        this.stage = STAGE.FIRST;
        this.text = button.getData().getCurrent().getDirection();
        refreshText();
    }

    private void secondStage() {
        this.stage = STAGE.SECOND;
        this.button.getData().setInputMode(Data.INPUT_MODE.SHOW);
        refreshText();
    }

    private void endStage() {
        getTextLine(0).setText("");
        getTextLine(1).setText("");
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
                //TODO: print the destination stop on line 2
                getTextLine(1).setText("placeholder");
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
        endStage();
    }
}
