package pp.main;

public class Main {
    private Data data;
    private Panel mainWindow;

    private Main() {
        this.data = new Data();
        this.mainWindow = new Panel(this.data);

    }

    public static void main(String[] Args) {
        new Main();
    }
}
