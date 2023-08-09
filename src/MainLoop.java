import exceptions.NoSuchOptionException;
import io.ConsolePrinter;
import model.Digit;
import model.Menu;
import model.MyInput;
import service.GameService;

import java.util.InputMismatchException;
import java.util.List;

public class MainLoop {
    private final ConsolePrinter printer = new ConsolePrinter();
//    private NumberService numberService = new NumberService();
    private GameService gameService;

    public void controlLoop() {
        Menu menu;

        do {
            printOptions();
            menu = getMenuOptions();
            switch (menu) {

                case EXIT -> exitOption();
                case NEW_GAME -> newGame();
                case GUESS_NUMBER -> guessNumber();
                case GET_DIGIT -> getDigit();
            }
            printNumber();
        } while (menu.getValue() != Menu.EXIT.getValue());
    }

    private void newGame() {
        this.gameService = new GameService();
    }

    private void guessNumber() {
        var checkNumber = MyInput.getInt("This is your chance!!! give whole " + gameService.getHashedNUMBER().length() + " digit number:" );
        if (gameService.getNUMBER() == checkNumber) {
            bravo();
        } else {
            niceTry();
        }
    }

    private void bravo() {
        List<Digit> array = gameService.getArray();
        for (Digit digit : array) {
            digit.setGuessed(true);
        }
        printer.printLine("YOU WON!!!");
    }

    private void niceTry() {
    }

    private void getDigit() {
        var checkDigit = MyInput.getInt("Type digit, that will be checked, if exists in a number");
        if (gameService.checkDigit(checkDigit)) {
            gameService.tryGuessPosition();
        }
    }

    private void printNumber() {
        printer.printLine("===YOUR NUMBER===");
        printer.printLine("### " + gameService.getHashedNUMBER() + " ###");
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
            if ((gameService == null || gameService.allGuessed()) && (value.getValue() == 1 || value.getValue() == 2)) {
                printer.spacer("");
            } else {
                printer.printLine(value.toString());
            }
        }
    }
}
