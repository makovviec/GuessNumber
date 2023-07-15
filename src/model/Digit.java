package model;

public class Digit {
    private final int DIGIT;
    private boolean guessed;

    public Digit(int number, boolean guessed) {
        this.DIGIT = number;
        this.guessed = guessed;
    }

    public int getLength() {
        return Integer.toString(DIGIT).length();
    }

    public int getDIGIT() {
        return DIGIT;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    @Override
    public String toString() {
        return DIGIT + ", " + guessed;
    }
}
