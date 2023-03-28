package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 500;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }
    @Override
    protected void paintComponent(Graphics g) {
        //get the number of dots (numVertices)
        int numVertices = (int) frame.configPanel.dotsSpinner.getValue();

        //get the probability that two dots form a line (edgeProbability)
        double edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();

        //draw the board, that is:
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        int[] x = new int[numVertices];
        int[] y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
        //draw the dots
        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i], y[i], 10, 10);
        }
        //draw the lines between every two dots with the given probability
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    g.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }

    }


    public void createGame(int dots, double lines) {
        paintComponent(getGraphics());
    }


    public void resetGame() {
        Graphics g = getGraphics();
        g.clearRect(0, 0, W, H);
    }
}
