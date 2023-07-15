package model;

import java.util.Random;
import java.util.Scanner;

public interface MyInput {
    Scanner scanner = new Scanner(System.in);
    Random rnd = new Random();

    static int getInt(String message) {
        var length = "";
        do {
            System.out.println(message);
            length = scanner.nextLine();
        } while (!length.matches("\\d+"));
        return Integer.parseInt(length);
    }

    static int getInt() {
        try {
            return MyInput.scanner.nextInt();
        } finally {
            MyInput.scanner.nextLine();
        }
    }

}
