package org.example;



import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));


        //create the rest of the components
        linesLabel = new JLabel("Lines probability:");
        linesCombo = new JComboBox(new Double[]{0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0});
        createButton = new JButton("Create new game!");

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);

        createButton.addActionListener(this::createGame);


    }

    private void createGame(ActionEvent actionEvent) {
        int dots = (int) dotsSpinner.getValue();
        double lines = (double) linesCombo.getSelectedItem();
        frame.canvas.createGame(dots, lines);
    }


}
