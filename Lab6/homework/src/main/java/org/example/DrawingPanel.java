package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.lang.model.type.ArrayType;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Stack;

import static java.awt.geom.Point2D.distance;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 500;
    private ArrayList<MyPoint> dots = new ArrayList<>();
    private ArrayList<Line> lines = new ArrayList<>();
    int numberOfLines = 0;
    int playerTurn = 1;
    private int[][] adjacencyMatrix = new int[100][100]; //1=red 2=blue

    //list of lines that are colored with red
    private ArrayList<Line> redLines = new ArrayList<>();
    //list of lines that are colored with blue
    private ArrayList<Line> blueLines = new ArrayList<>();
    GameState gameState = new GameState();


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        //add a mouse listener
        addMouseListener(new MouseAdapter() {
                             @Override
                             public void mouseClicked(MouseEvent e) {

                                 int color;
                                 if (playerTurn % 2 == 0) {
                                     color = 1; // red player
                                 } else {
                                     color = 0; // blue player
                                 }
                                 gameState.setTurn(playerTurn % 2);
                                 //get the coordinates of the click
                                 int x = e.getX();
                                 int y = e.getY();

                                 System.out.println("x: " + x + " y: " + y);


                                 for (Line line : lines) {
                                     //if the click is on a line, color it//
                                     //slope of the line we want to check

                                     double slope = (double) (line.getDot2().y - line.getDot1().y) / (line.getDot2().x - line.getDot1().x);
                                     //if the slope is infinite
                                     boolean vertical = (slope == Double.NEGATIVE_INFINITY || slope == Double.POSITIVE_INFINITY);

                                     // check for y-y1 = m(x-x1)
                                     double left_hand = y - line.getDot1().y;
                                     double right_hand = slope * (x - line.getDot1().x);
                                     //if they are equal with a small margin of error, then the click is on the line
                                     if (Math.abs(left_hand - right_hand) < 15 || (vertical && nearLine(line, x, y))) {

                                         if (line.isColored()) {
                                             System.out.println("Line already colored");
                                             break;
                                         }
                                         Graphics g = getGraphics();
                                         if (color == 0) {  // blue player
                                             g.setColor(Color.BLUE);
                                             line.setcolor("blue");
                                             adjacencyMatrix[line.getDot1().getId()][line.getDot2().getId()] = 2;
                                             blueLines.add(line);
                                             gameState.updateLine(line);
                                             if (hasCycleOfLengthThree(blueLines)) {
                                                 System.out.println("Blue player wins");
                                                 JOptionPane.showMessageDialog(null, "Blue player wins");
                                             }

                                         } else {
                                             g.setColor(Color.RED);
                                             line.setcolor("red");
                                             gameState.addLine(line);
                                             adjacencyMatrix[line.getDot1().getId()][line.getDot2().getId()] = 1;
                                             redLines.add(line);
                                             gameState.updateLine(line);
                                             if (hasCycleOfLengthThree(redLines)) {
                                                 System.out.println("Red player wins");
                                                 JOptionPane.showMessageDialog(null, "Red player wins");
                                             }

                                         }

                                         g.drawLine(line.getDot1().x, line.getDot1().y, line.getDot2().x, line.getDot2().y);
                                         line.setColored(true);
                                         playerTurn++;
                                         break;


                                     }


                                 }
                             }
                         }
        );


        initPanel();

    }

    /*for the vertical lines where the slope si infinite
    * to verify if the click is near the vertical line*/
    private boolean nearLine(Line line, int x, int y) {
        if (y < line.getDot1().getY() && y > line.getDot2().getY()) {
            if (Math.abs(line.getDot1().getX() - x) < 15) {
                return true;
            }
        }
        return false;
    }


    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        //get the number of dots (numVertices)
        int numVertices = (int) frame.configPanel.dotsSpinner.getValue();
        gameState.setNumberOfDots(numVertices);
        //get the probability that two dots form a line (edgeProbability)
        double edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();

        //draw the board, that is:
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        int[] x = new int[numVertices];
        int[] y = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            //add the point to the list of points
            dots.add(new MyPoint(x[i], y[i], i));
            gameState.addDot(new MyPoint(x[i], y[i], i));

        }
        //draw the dots
        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i], y[i], 10, 10);
        }
        //draw the lines between every two dots with the given probability
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    //draw the line tickness 3
                    ((Graphics2D) g).setStroke(new BasicStroke(3));
                    g.drawLine(x[i], y[i], x[j], y[j]);
                    //add the line to the list of lines
                    lines.add(new Line(dots.get(i), dots.get(j)));
                    numberOfLines++;
                    gameState.addLine(new Line(dots.get(i), dots.get(j)));
                }
            }
        }
        //set the number of lines in the game state
        gameState.setNumberOfLines(numberOfLines);
    }


    /*
    * create the game with the new configurations*/
    public void createGame(int dots, double lines) {
        paintComponent(getGraphics());
    }


    /*
    * reset the game configurations*/
    public void resetGame() {
        Graphics g = getGraphics();
        g.clearRect(0, 0, W, H);
        dots.clear();
        lines.clear();
        blueLines.clear();
        redLines.clear();
        numberOfLines = 0;
        playerTurn = 1;
        //reset the json file
        gameState.reset();
    }


    private boolean hasCycleOfLengthThree(ArrayList<Line> lines) {
        // Convert the list of lines to an adjacency matrix
        int[][] matrix = new int[dots.size()][dots.size()];
        for (Line line : lines) {
            int i = line.getDot1().getId();
            int j = line.getDot2().getId();
            matrix[i][j] = matrix[j][i] = 1;
        }

        // Check if there is a cycle of length 3 in the graph
        for (int i = 0; i < dots.size(); i++) {
            for (int j = i + 1; j < dots.size(); j++) {
                if (matrix[i][j] == 1) {
                    // check if there is an edge between i and j
                    for (int k = j + 1; k < dots.size(); k++) {
                        if (matrix[j][k] == 1 && matrix[i][k] == 1) {
                            // check if there is an edge between j and k, and between i and k
                            if (degree(matrix, i) != 3 && degree(matrix, j) != 3 && degree(matrix, k) != 3) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int degree(int[][] matrix, int vertex) {
        int degree = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] == 1) {
                degree++;
            }
        }
        return degree;
    }


    /*
    *save the game as a png file and the settings as a txt file*/
    public void photoGame() {
        BufferedImage image = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        paintComponent(graphics2D);
        graphics2D.dispose();
        try {
            System.out.println("Saving game as game.png");
            ImageIO.write(image, "png", new File("game.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    * loads the game from the json file*/
    public void loadGame() {
        ObjectMapper mapper = new ObjectMapper();
        String path = "game.json";
        GameState game;
        //get the graphics
        Graphics g = getGraphics();
        try {
            game = mapper.readValue(new File(path), GameState.class);
            lines = game.getLines();
            numberOfLines = game.getNumberOfLines();
            dots = game.getDots();
            //draw the dots
            for (int i = 0; i < dots.size(); i++) {
                g.fillOval((int) dots.get(i).getX(), (int) dots.get(i).getY(), 10, 10);
            }

            //set the stoke
            ((Graphics2D) g).setStroke(new BasicStroke(3));

            //draw the lines
            for (Line line : lines) {
                if (line.isColored()) {
                    if (line.getcolor().equals("blue")) {
                        System.out.println("blue");
                        blueLines.add(line);
                        g.setColor(Color.BLUE);

                    } else if (line.getcolor().equals("red")) {
                        System.out.println("red");
                        redLines.add(line);
                        g.setColor(Color.RED);
                    }

                }else{
                    //if the line is not colored set the color to black
                    g.setColor(Color.BLACK);
                }
                //draw the line
                g.drawLine((int) line.getDot1().getX(), (int) line.getDot1().getY(), (int) line.getDot2().getX(), (int) line.getDot2().getY());

            }
            System.out.println(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * save the game in a json file*/
    public void saveGame() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("game.json"), gameState);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
