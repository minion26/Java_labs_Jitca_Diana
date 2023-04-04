package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory mem = new SharedMemory(10);
    private final ExplorationMap map = new ExplorationMap(this.mem);
    private final List<Robot> robots = new ArrayList<>();

    public void addRobot(Robot robot) {
        robots.add(robot);
    }
    public SharedMemory getMem() {
        return mem;
    }
    public ExplorationMap getMap() {
        return map;
    }

    public Exploration() {
    }

    public void start() {
        for (Robot robot : robots) {
            //start a new Thread representing the robot
            new Thread(robot).start();
            robot.setRunning(true);
            System.out.println("Robot started");
        }
    }



}

