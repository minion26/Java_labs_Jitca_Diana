/*
 * This is a class for the roads with their length, speed limit and type
 * @author Jitca Diana
 * */
import java.util.Objects;

public class Roads {
    private double length;
    private int speedLimit;
    RoadTypes type;

    //constructor
    public Roads(int speedLimit, Locations start, Locations end,  RoadTypes type) {
        this.length = Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
        this.speedLimit = speedLimit;
        this.type = type;
    }

    //gettere si settere
    public double getLength() {
        return length;
    }

    public void setLength(double lenght) {
        if (lenght >= this.length) {
            this.length = lenght;
        }
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public RoadTypes getType() {
        return type;
    }

    public void setType(RoadTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Roads [length=" + length + ", speedLimit=" + speedLimit ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roads roads = (Roads) o;
        return Double.compare(roads.length, length) == 0 && speedLimit == roads.speedLimit;
    }


}


