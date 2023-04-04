package org.example;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    Exploration explore;

    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
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

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public void run() {
        while (running) {
            //pick a cell to explore

            int row = (int) (Math.random() * explore.getMap().getRows());
            int col = (int) (Math.random() * explore.getMap().getCols());

            explore.getMap().visit(row, col, this);

            //System.out.println("Robot" + this.name + "is at: " + row + " " + col);
            //make the robot sleep for some time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
