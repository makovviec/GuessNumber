import exceptions.NoSuchOptionException;
import io.ConsolePrinter;
import model.Menu;
import model.MyInput;
import service.GameService;
import service.NumberService;

import java.util.InputMismatchException;

public class MainLoop {
    private final ConsolePrinter printer = new ConsolePrinter();
//    private NumberService numberService = new NumberService();
    private GameService gameService = new GameService();

    public void controlLoop() {
        Menu menu;

        do {
            printOptions();
            menu = getMenuOptions();
            switch (menu) {

                case ASSIGN_POSITION -> {
                }
                case GIVE_DIGIT -> giveDigit();
                case NEW_GAME -> {
                }
                case EXIT -> exitOption();
            }
            printNumber();
        } while (menu.getValue() != Menu.EXIT.getValue());
    }

    private void giveDigit() {
        var checkDigit = MyInput.getInt("Type digit, that will be checked, if exists in a number");
        if (gameService.checkDigit(checkDigit)) {
            gameService.tryGuessPosition();
        }
    }

    private void printNumber() {
        printer.printLine("===YOUR NUMBER===");
        printer.printLine(gameService.getNUMBER());
        printer.printLine("=================");
    }

    private Menu getMenuOptions() {
        boolean optionOk = false;
        Menu option = null;
        while (!optionOk) {
            try {
                option = Menu.createFromInt(MyInput.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", give menu option again:");
            } catch (InputMismatchException ignored) {
                printer.printLine("The given value is not a Number, please give menu option again:");
            }
        }

        return option;
    }

    private void exitOption() {
        printer.printLine("Game Over!");
        MyInput.scanner.close();
    }

    private void printOptions() {
        printer.printLine("=== Choose an action: ===");
        for (Menu value : Menu.values()) {
            printer.printLine(value.toString());
        }
    }
}
