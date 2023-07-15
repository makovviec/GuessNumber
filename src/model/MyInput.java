package model;

import java.util.Random;
import java.util.Scanner;

public interface MyInput {
    Scanner scanner = new Scanner(System.in);
    Random rnd = new Random();

    static int getInt(String message) {
        System.out.println(message);
        int length = scanner.nextInt();
        scanner.nextLine();
        return length;
    }

    static int getInt() {
        try {
            return MyInput.scanner.nextInt();
        } finally {
            MyInput.scanner.nextLine();
        }
    }
}
