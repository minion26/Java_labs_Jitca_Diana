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

    //stop all the robots
    public void stop(){
        for (Robot robot : robots) {
            robot.setRunning(false);
            System.out.println("Robot stopped, tokens: "+ robot.getTokensFound());
            //stop the thread
            robot.destroy();


        }
    }

    //stop a robot by name
    public void stopByName(String s) {
        for (Robot robot : robots) {
            if (robot.getName().equalsIgnoreCase(s)) {
                robot.setRunning(false);
                System.out.println("Robot" + s + " stopped");
            }
        }
    }

    //start a robot by name
    public void startByName(String s) {
        //start a new Thread representing the robot
        for (Robot robot : robots) {
            if (robot.getName().equalsIgnoreCase(s)) {
                robot.setRunning(true);
                System.out.println("Robot" + s + " started");
            }
        }
    }


    public Robot[] getRobots() {
        return robots.toArray(new Robot[0]);
    }


}

