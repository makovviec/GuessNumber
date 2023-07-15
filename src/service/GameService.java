package service;

import model.Digit;
import model.MyInput;

public class GameService extends NumberService {
    private int guessDigit;

    public boolean checkDigit(int digit) {
        var length = String.valueOf(digit).length();
        if (length > 1) {
            throw new IllegalArgumentException("Please provide only one digit");
        }
        for (Digit oDigit : getArray()) {
            if (oDigit.getDIGIT() == digit) {
                this.guessDigit = digit;
                return true;
            }
        }
        return false;
    }

    public void tryGuessPosition() {
        var length = String.valueOf(getNUMBER()).length();

        System.out.println("Found a Digit!");
        System.out.println("------------------------------");
        System.out.println("Your Number:\t" + getNUMBER());
        System.out.print("Position: \t\t");
        for (int i = 0; i < length; i++) {
            System.out.print(i);
        }
        System.out.println("\n");
        System.out.println("------------------------------");

        var guessPosition = MyInput.getInt("Please give a position");
        boolean positionCheck = checkPosition(guessPosition);
    }

    private boolean checkPosition(int guessPosition) {
        if (getArray().get(guessPosition).getDIGIT() == guessDigit) {
            System.out.println("Brawo");
            getArray().get(guessPosition).setGuessed(true);
            return true;
        }
        System.out.println("Nie odgadłeś pozycji");
        return false;
    }
}
