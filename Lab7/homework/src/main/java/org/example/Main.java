package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO
//1. Make a robot sleep for a given time
//2. !!! Make the each robots will try to explore the map in a systematic fashion
//3. !!! Timekeeper thread that will stop the robots after 10 minutes

public class Main {
    public static void main(String[] args){

        Exploration explore = new Exploration();

        int row = (int)explore.getMap().getRows()-1;
        int numRowsPerRobot = row / 3;
        int col = (int)explore.getMap().getCols() - 1;

        explore.addRobot(new Robot("Wall-E", explore, 0, 0, numRowsPerRobot, col ));

        explore.addRobot(new Robot("R2D2", explore, numRowsPerRobot+1, 0, 2*numRowsPerRobot, col));

        explore.addRobot(new Robot("Optimus Prime", explore, 2*numRowsPerRobot+1, 0, row, col));

        //make a timekeeper thread that will stop the robots after 10 minutes * 60 seconds/minute * 1000 milliseconds/second = 600,000 milliseconds.
        DaemonThread timeKeeper = new DaemonThread(600000, explore);
        Thread timekeeperThread = new Thread(timeKeeper);
        timekeeperThread.setDaemon(true);
        timekeeperThread.start();


        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        //check if the user wrote start
        while (isRunning) {
            String input = scanner.nextLine();
            /*Pattern pattern = Pattern.compile("[0-9]+$");
            Matcher matcher = pattern.matcher(input);*/

            if(input.equals("start")){
                System.out.println("Starting the robots");
                explore.start();
            }
            if (input.equals("stop")) {
                System.out.println("Stopping the robots");
                explore.stop();
                isRunning = false;
            }
            if(input.equals("stop wall-e")){
                System.out.println("stopping wall-e");
                explore.stopByName("Wall-E");
            }
            if(input.equals("stop r2d2")){
                System.out.println("stopping r2d2");
                explore.stopByName("R2D2");
            }
            if(input.equals("stop optimus prime")){
                System.out.println("stopping optimus prime");
                explore.stopByName("Optimus Prime");
            }
            if(input.equals("start wall-e")){
                System.out.println("starting wall-e");
                explore.startByName("Wall-E");
            }
            if(input.equals("start r2d2")){
                System.out.println("starting r2d2");
                explore.startByName("R2D2");
            }
            if(input.equals("start optimus prime")){
                System.out.println("starting optimus prime");
                explore.startByName("Optimus Prime");
            }


        }

    }
}