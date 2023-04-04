package org.example;

public class Token {
    private final int number;

    public Token(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    //toString

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }
}
