package com.company;

public class Cell {
    private Position position;
    private char symbol;

    public Cell(Position position, char symbol) {
        this.position = position;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public Position getPosition() {
        return position;
    }
}

