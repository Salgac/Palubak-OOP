package pp.visual.buttons.scripts.helper;

import pp.visual.buttons.BuseButton;
import pp.visual.buttons.scripts.BuseScript;
import pp.visual.buttons.scripts.functions.*;

public class ScriptAssign {
    public static BuseScript assign(FUNCTION_TYPE type, BuseButton button) {
        BuseScript script = null;
        switch (type) {
            case ACCIDENT:
                break;
            case LINE_SET:
                script = new LineSetScript(button);
                break;
            case DESTINATION_SET:
                script = new DestinationSetScript(button);
                break;
            case SERVICE_SET:
                script = new ServiceSetScript(button);
                break;
            case CODE_MESSAGE:
                break;
            case ZONE_SET:
                break;
            case DIRECTION_SET:
                break;
            case REVISION:
                break;
            case DIVERSION:
                break;
            case MANUALLY:
                break;
            case STOP:
                break;
            case CANCEL:
                script = new CancelScript(button);
                break;
            case SERVICE:
                break;
            case ACCEPT:
                script = new AcceptScript(button);
                break;
            default:
                break;
        }
        return script;
    }
}
