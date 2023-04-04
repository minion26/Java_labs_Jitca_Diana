package org.example;

import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private  Cell[][] matrix = new Cell[100][100];
    private final SharedMemory mem;
    //Cell should be a wrapper or alias for List
    public ExplorationMap(SharedMemory memory) {
        this.mem = memory;
        //initialize the matrix
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                this.matrix[i][j] = new Cell();
            }
        }
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if(!matrix[row][col].isVisited()) {

                //get the tokens

                matrix[row][col].setTokens(robot.getExplore().getMem().extractTokens(3));
                matrix[row][col].setVisited(true);
                System.out.println("Robot " + robot.getName() + " visited cell " + row + " " + col);

                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }

    public double getRows() {
        return matrix.length;
    }

    public double getCols() {
        return matrix[0].length;
    }




}

