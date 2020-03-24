package pp.visual.buttons.scripts;

public class BuseScript {

    private String text;

    public BuseScript() {

    }

    public BuseScript(String text) {
        this();
        this.text = text;
    }

    public void execute() {
        System.out.println(this.text);
    }
}
