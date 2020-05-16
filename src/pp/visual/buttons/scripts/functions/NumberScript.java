package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.NumericButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

/**
 * Class for number entering script
 *
 * @author Dominik Šalgovič
 */
public class NumberScript extends BuseScript {

    /**
     * Deault constructor
     *
     * @param button button that the script operates with
     */
    public NumberScript(NumericButton button) {
        super(button, FUNCTION_TYPE.NULL);
    }

    @Override
    public void execute() {
        BuseScript activeScript = button.getData().getActiveScript();
        if (activeScript != null) {
            Data.INPUT_MODE input = button.getData().getInputMode();
            if (input == Data.INPUT_MODE.ON || input == Data.INPUT_MODE.SHOW) {
                if (input == Data.INPUT_MODE.SHOW) {
                    button.getData().setInputMode(Data.INPUT_MODE.ON);
                    //clear string and make it ready for input
                    String text = "";
                    int length = activeScript.getText().length();
                    for (int i = 0; i < length; i++)
                        text = text.concat(" ");
                    activeScript.setText(text);
                }
                String text = activeScript.getText();
                //remove first number, add new on back
                text = text.substring(1);
                text = text.concat(String.valueOf(((NumericButton) this.button).getNum()));
                activeScript.setText(text);
            } else if (input == Data.INPUT_MODE.OFF) {
                button.getData().setInputMode(Data.INPUT_MODE.SHOW);
            }
        }
    }

    @Override
    public void refreshText() {

    }

    @Override
    void accept() {

    }

    @Override
    void cancel() {

    }
}
