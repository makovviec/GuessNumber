public class Main {
    private static final String APP_NAME = "Game - GUESS NUMBER v0.3";
    public static void main(String[] args) {
        System.out.println(APP_NAME);
        MainLoop mainLoop = new MainLoop();
        mainLoop.controlLoop();

    }
}