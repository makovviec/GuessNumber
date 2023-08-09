package service;

import model.Digit;
import model.MyInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberService {
    private final int ONE_DIGIT_NUMBER_RANGE = 10;
    private final int NUMBER;
    private List<Digit> array;

    public NumberService() {
        this.NUMBER = generateNumber();
        this.array = numberToList();

    }

    private int generateNumber() {
        var length = MyInput.getInt("Give the length (int) of a number you want to guess:");
        if (length == 1) {
            return MyInput.rnd.nextInt(ONE_DIGIT_NUMBER_RANGE);
        } else if (length > 2) {
            int min = (int) Math.pow(ONE_DIGIT_NUMBER_RANGE, length - 1);
            int max = (int) Math.pow(ONE_DIGIT_NUMBER_RANGE, length) - 1;
            return MyInput.rnd.nextInt(max - min + 1) + min;
        } else {
            return 0;
        }
    }

    public List<Digit> numberToList() {
        var txt = numberToString();
        var list = new ArrayList<Digit>();
        for (int i = 0; i < txt.length(); i++) {
            list.add(new Digit(Integer.parseInt(String.valueOf(txt.charAt(i))), false));
        }
        return list;
    }

    private String numberToString() {
        return Integer.toString(NUMBER);
    }

    public String getHashedNUMBER() {
        return hashUnknownDigits();
    }

    public int getNUMBER() {
        return NUMBER;
    }

    public List<Digit> getArray() {
        return array;
    }

    private String hashUnknownDigits() {
        return array.stream()
                .map(digit -> digit.isGuessed() ? String.valueOf(digit.getDIGIT()) : "*")
                .collect(Collectors.joining());
    }

    public boolean allGuessed() {
        return array.stream()
                .allMatch(digit -> digit.isGuessed());
    }

    public boolean allHidden() {
        if (array == null) {
            return false;
        } else {
            return array.stream()
                    .allMatch(digit -> digit.isGuessed() == false);
        }
    }

    @Override
    public String toString() {
        return "NumberService{" +
                "NUMBER=" + NUMBER +
                ", array=" + array +
                '}';
    }
}
