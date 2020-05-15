package pp.visual.buttons.scripts.functions;

import pp.data.stops.Stop;
import pp.lines.Line;
import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class StopScript extends BuseScript implements StagedScript {

    private STAGE stage;
    private String course;

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
        this.course = button.getData().getCurrent().getCourse();
        this.text = button.getData().getCurrent().getStopId();
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
                getTextLine(1).setText("");
                button.getData().getCurrent().setStop(null);
                endStage();
        }
    }

    @Override
    void cancel() {
        endStage();
    }
}
