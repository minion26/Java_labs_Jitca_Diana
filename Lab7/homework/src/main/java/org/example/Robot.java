package org.example;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    Exploration explore;
    int rowStart;
    int colStart;
    int rowEnd;
    int colEnd;
    int tokenStartCol;
    int tokenStartRow;

    public Robot(String name, Exploration explore, int rowStart, int colStart, int rowEnd, int colEnd) {
        this.name = name;
        this.explore = explore;
        this.rowStart = rowStart;
        this.colStart = colStart;
        this.rowEnd = rowEnd;
        this.colEnd = colEnd;
        this.tokenStartCol = colStart;
        this.tokenStartRow = rowStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Exploration getExplore() {
        return explore;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getColStart() {
        return colStart;
    }

    public void setColStart(int colStart) {
        this.colStart = colStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public int getColEnd() {
        return colEnd;
    }

    public void setColEnd(int colEnd) {
        this.colEnd = colEnd;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }


    public void run() {
        while (running) {
            //pick a cell to explore

            /*explore.getMap().visit(rowStart, colStart++, this);*/
            if(colStart == 99) {
                rowStart++;
                colStart = 0;
            }
            //check if the robot reached the end
            if(rowStart == rowEnd && colStart == colEnd) {
                running = false;
            }
            explore.getMap().visit(rowStart, colStart++, this);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public String getTokensFound() {
        //calculate how many tokens
        int tokensFound = 3*(colStart - tokenStartCol) + 3*(rowStart - tokenStartRow);
        return String.valueOf(tokensFound);


    }

    public void destroy() {
        //stop the thread
        Thread.currentThread().interrupt();
    }
}
