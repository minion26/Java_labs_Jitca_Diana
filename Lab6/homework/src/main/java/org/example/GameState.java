package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class GameState implements Serializable {
    // Add fields that represent the state of the game
    private int turn;
    private int numberOfLines;
    private final ArrayList<Line> lines = new ArrayList<>();
    private final int numberOfDots = 0;
    private final ArrayList<MyPoint> dots = new ArrayList<>();

    public GameState() {

    }

    public ArrayList<MyPoint> getDots() {
        return dots;
    }

    public void addDot(MyPoint dot) {
        dots.add(dot);
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public int getNumberOfDots() {
        return numberOfDots;
    }

    public void setNumberOfDots(int nr) {
        this.numberOfLines = nr;
    }

    public void updateLine(Line newLine){
        for (Line line : lines) {
            if (line.getDot1().equals(newLine.getDot1()) && line.getDot2().equals(newLine.getDot2())) {
                line.setcolor(newLine.getcolor());
                line.setColored(true);
            }
        }
    }

    public void reset() {
        //reset the game configuration
        //clear the drawing panel
        lines.clear();
        dots.clear();
        turn = 0;
        numberOfLines = 0;

    }
}