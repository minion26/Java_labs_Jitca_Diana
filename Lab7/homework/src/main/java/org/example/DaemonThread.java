package org.example;

public class DaemonThread implements Runnable {
    private int timeLimit;
    private Exploration exploration;

    public DaemonThread(int timeLimit, Exploration exploration) {
        this.timeLimit = timeLimit;
        this.exploration = exploration;
    }


    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            Thread.sleep(timeLimit);
            System.out.println("Time limit reached");

            //calculate how many tokens did each robot find
            for (Robot robot : exploration.getRobots()) {
                System.out.println("Robot " + robot.getName() + " found " + robot.getTokensFound() + " tokens");
            }

            exploration.stop();
            long endTime   = System.currentTimeMillis();
            long totalTime = (endTime - startTime)/1000;
            System.out.println("Total time is: " + totalTime + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
