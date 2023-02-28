/**
 * This is lass for the roads of the application
 *  @author Jitca Diana
 *  */
public class Roads {
    private double length;
    private int speedLimit;
    RoadsTypes type;
    //constructor
    public Roads(int speedLimit, RoadsTypes type, Locations start, Locations end) {
        this.length = Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
        this.speedLimit = speedLimit;
        this.type = type;
    }
    //gettere si settere
    public double getLength() {
        return length;
    }
    public void setLength(double lenght){
        if (lenght >= this.length){
            this.length=lenght;
        }
    }
    public int getSpeedLimit() {
        return speedLimit;
    }
    public void setSpeedLimit(int speedLimit){
        this.speedLimit=speedLimit;
    }
    public RoadsTypes getType() {
        return type;
    }
    public void setType(RoadsTypes type){
        this.type=type;
    }

    @Override
    public String toString() {
        return "Roads [length=" + length + ", speedLimit=" + speedLimit + ", type=" + type + "]";
    }
}
