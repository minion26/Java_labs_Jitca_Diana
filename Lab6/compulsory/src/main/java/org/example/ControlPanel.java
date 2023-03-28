package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel  {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Exit, etc.)
    JButton loadbtn = new JButton("Load");
    JButton savebtn = new JButton("Save");
    JButton resetbtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        add(exitBtn);
        add(loadbtn);
        add(savebtn);
        add(resetbtn);

        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadbtn.addActionListener(this::loadGame);
        savebtn.addActionListener(this::saveGame);
        resetbtn.addActionListener(this::resetGame);

    }

    private void resetGame(ActionEvent actionEvent) {
        //reset the game configuration
        //clear the drawing panel
        frame.canvas.resetGame();


    }

    private void saveGame(ActionEvent actionEvent) {
    }

    private void loadGame(ActionEvent actionEvent) {
        //load the game configuration
        //TODO

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    //TODO ???

}
