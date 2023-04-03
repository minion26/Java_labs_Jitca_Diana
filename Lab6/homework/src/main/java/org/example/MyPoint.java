package org.example;
import java.awt.*;

import static java.awt.geom.Point2D.distance;
public class MyPoint extends Point {
    private int id;

    public MyPoint(int x, int y, int id) {
        super(x, y);
        this.id = id;
    }

    public MyPoint() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
