package pp.visual.buttons.scripts.functions;

import pp.data.stops.Stop;
import pp.lines.Line;
import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;
import pp.visual.screen.DestinationLine;

/**
 * Class for stop script, that handles stop confirmations
 *
 * @author Dominik Šalgovič
 */
public class StopScript extends BuseScript implements StagedScript {

    private STAGE stage;

    /**
     * Default constructor
     *
     * @param button button that the script operates with
     */
    public StopScript(BuseButton button) {
        super(button, FUNCTION_TYPE.LINE_SET);
    }

    @Override
    public void execute() {
        button.getData().setActiveScript(this);
        firstStage();
    }

    private void firstStage() {
        this.stage = STAGE.FIRST;
        this.text = button.getData().getCurrent().getStopId();
        if (text.equals(""))
            endStage();
        else
            refreshText();
    }

    private void secondStage() {
        this.button.getData().setInputMode(Data.INPUT_MODE.SHOW);
        this.stage = STAGE.SECOND;
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
                getTextLine(0).setText("Zastávka: >" + this.text + "<");
                break;
            case SECOND:
                getTextLine(0).setText("Odjezd ze zast?");
                break;
            case THIRD:
                getTextLine(0).setText("Koniec jazdy");
                break;
        }
    }

    @Override
    void accept() {
        switch (stage) {
            case FIRST:
                secondStage();
                break;
            case SECOND:
                Line line = button.getData().getCurrent().getLine();
                if (line == null) {
                    getTextLine(1).setText("");
                    button.getData().getCurrent().setStop(null);
                    endStage();
                } else {
                    Stop newStop = line.getNext(this.text, button.getData());
                    if (newStop != null) {
                        button.getData().getCurrent().setStop(newStop);
                        endStage();
                    } else
                        thirdStage();
                }
                break;
            case THIRD:
                button.getData().getCurrent().setStop(null);
                button.getData().getCurrent().setDestination("000");
                getTextLine(1).setText("");
                getTextLine(2).setText("");
                ((DestinationLine) getTextLine(4)).reset();
                endStage();
        }
    }

    @Override
    void cancel() {
        endStage();
    }
}
