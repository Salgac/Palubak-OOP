package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

/**
 * Class for service setting script
 *
 * @author Dominik Šalgovič
 */
public class ServiceSetScript extends BuseScript implements StagedScript {

    /**
     * Default constructor
     *
     * @param button button that the script operates with
     */
    public ServiceSetScript(BuseButton button) {
        super(button, FUNCTION_TYPE.LINE_SET);
    }

    private STAGE stage;
    private String textService, textDriver;

    private String prevService;
    private boolean saved = false;

    @Override
    public void execute() {
        button.getData().setActiveScript(this);
        firstStage();
    }

    private void firstStage() {
        this.stage = STAGE.FIRST;
        prevService = button.getData().getCurrent().getService();
        this.text = prevService;
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
        //set the line for check
        button.getData().getCurrent().setService(textService);
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
        saved = true;
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
                button.getData().getCurrent().setDriver(textDriver);
                endStage();
                break;
        }
    }

    @Override
    void cancel() {
        saved = false;
        switch (stage) {
            case FIRST:
            case SECOND:
                endStage();
                break;
            case THIRD:
                button.getData().getCurrent().setService(prevService);
                endStage();
        }
    }
}
