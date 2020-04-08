package pp.visual.buttons.scripts.functions;

import pp.main.Data;
import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.helper.FUNCTION_TYPE;

public class ArrowScript extends BuseScript {
    public ArrowScript(BuseButton button, FUNCTION_TYPE type) {
        super(button, type);
    }

    @Override
    public void execute() {
        BuseScript activeScript = button.getData().getActiveScript();
        if (activeScript != null) {
            Data.INPUT_MODE input = button.getData().getInputMode();
            if (input == Data.INPUT_MODE.ON) {
                //operation with numbers
                switch (this.type) {
                    case ARROW_UP:
                        change(1);
                        break;
                    case ARROW_DOWN:
                        change(-1);
                        break;
                }
            }
        }
    }

    private void change(int n) {
        //manipulation number
        StringBuilder string = new StringBuilder(button.getData().getActiveScript().getText());
        int oldLength = string.length();
        int num = Integer.parseInt(string.toString().replace(" ", ""));
        //calculation
        num += n;
        if (num == -1)
            num = 0;
        string = new StringBuilder(String.valueOf(num));
        //add enough " "
        int newLength = string.length();
        for (int i = 0; i < oldLength - newLength; i++) {
            string.insert(0, " ");
        }
        button.getData().getActiveScript().setText(string.toString());
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

