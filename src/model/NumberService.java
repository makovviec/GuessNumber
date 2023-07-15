package model;

import java.util.ArrayList;
import java.util.List;

public class NumberService {
    private final int NUMBER;
    private List<Digit> array = new ArrayList<>();

    public NumberService() {
        NUMBER = generateNumber();
    }

    private int generateNumber() {
        var multiply = 10;
        var length = MyInput.getInt("Give the length (int) of a number you want to guess:");
        if (length == 1) {
            return MyInput.rnd.nextInt(multiply);
        } else if (length > 2) {
            int min = (int) Math.pow(multiply, length - 1);
            int max = (int) Math.pow(multiply, length) - 1;
            return MyInput.rnd.nextInt(max - min + 1) + min;
        } else {
            return 0;
        }
    }

    public void add() {
        var txt = numberToString();
        for (int i = 0; i < txt.length(); i++) {
            array.add(new Digit(Integer.parseInt(String.valueOf(txt.charAt(i))), false));
        }
    }

    private String numberToString() {
        return Integer.toString(NUMBER);
    }

    public int getNUMBER() {
        return NUMBER;
    }

    public List<Digit> getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "NumberService{" +
                "NUMBER=" + NUMBER +
                ", array=" + array +
                '}';
    }
}
