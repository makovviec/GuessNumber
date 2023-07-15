import java.util.Random;
import java.util.Scanner;

public class GuessMeTester {
    static Random rnd = new Random();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final var LENGTH = 10;
        System.out.println("Welcome!");
        System.out.println("This is a challenge called \"Guess Number\".");
        System.out.println("############################################");
        int length = getLength();
        int generatedNumber = generateNumber(length);
        System.out.println(hashUnknownDigits(generatedNumber));
        System.out.println(generatedNumber);
    }

    private static int getLength() {
        System.out.println("Please choose a number length you wish to guess.");
        int length = scanner.nextInt();
        scanner.nextLine();
        return length;
    }

    private static String hashUnknownDigits(int generatedNumber) {
        String txt = Integer.toString(generatedNumber);
        return "*".repeat(txt.length());
    }

    private static int generateNumber(int length) {
        var multiply = 10;
        if (length == 1) {
            return rnd.nextInt(multiply);
        } else if (length > 2) {
            int min = (int) Math.pow(multiply, length - 1);
            int max = (int) Math.pow(multiply, length) - 1;
            return rnd.nextInt(max - min + 1) + min;
        } else {
            return 0;
        }
    }
}
