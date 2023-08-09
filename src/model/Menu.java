package model;

import exceptions.NoSuchOptionException;

public enum Menu {
    EXIT(0, "END Game!"),
    GUESS_NUMBER(1, "Try guess whole number"),
    GET_DIGIT(2, "Try guess one digit"),
    NEW_GAME(3, "New game");

    private final int value;
    private final String description;

    Menu(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "# " + value + " # " + description;
    }

    public static Menu createFromInt(int option) throws NoSuchOptionException {
        try {
            return Menu.values()[option];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("There is no optionId " + option);
        }
    }
}
