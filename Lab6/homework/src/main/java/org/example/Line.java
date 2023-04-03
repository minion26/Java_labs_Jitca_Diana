package org.example;

import java.awt.*;

import static java.awt.geom.Point2D.distance;

public class Line {
    private MyPoint dot1;
    private MyPoint dot2;
    private String color;
    private boolean isColored;
    public Line(){

    }

    public Line(MyPoint dot1, MyPoint dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.isColored = false;

    }

    public MyPoint getDot1() {
        return dot1;
    }

    public MyPoint getDot2() {
        return dot2;
    }

    public String getcolor() {
        return color;
    }


    public boolean isColored() {
        return isColored;
    }

    public void setColored(boolean colored) {
        isColored = colored;
    }

    @Override
    public String toString() {
        return "Line{" +
                "dot1=" + dot1 +
                ", dot2=" + dot2 +
                ", color='" + color + '\'' +
                ", isColored=" + isColored +
                '}';
    }

    public void setcolor(String color) {
        this.color = color;
    }

    public boolean intersects(Line other) {
        // get the four points that define the two line segments
        Point a = dot1;
        Point b = dot2;
        Point c = other.getDot1();
        Point d = other.getDot2();


        // calculate the orientation of the four points
        int o1 = orientation(a, b, c);
        int o2 = orientation(a, b, d);
        int o3 = orientation(c, d, a);
        int o4 = orientation(c, d, b);

        // check if the line segments intersect
        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // check if the line segments are collinear and overlapping
        if (o1 == 0 && onSegment(a, c, b)) {
            return true;
        }
        if (o2 == 0 && onSegment(a, d, b)) {
            return true;
        }
        if (o3 == 0 && onSegment(c, a, d)) {
            return true;
        }
        if (o4 == 0 && onSegment(c, b, d)) {
            return true;
        }

        // the line segments do not intersect
        return false;
    }

    // helper methods for calculating orientation and whether a point is on a line segment
    private int orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (Math.abs(val) < 1e-9) {
            return 0;  // collinear
        }
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    private boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }

}
