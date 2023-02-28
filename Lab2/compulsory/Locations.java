/**
 * This is a class for the locations of the application
 * @author Jitca Diana
 * */
public class Locations {
    private String name;
    private double x;
    private double y;
    LocationTypes type;

    /**
     * This is the constructor for the class
    * */
    public Locations(String name, double x, double y, LocationTypes type) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = type;
    }
    //settere si gettere
    public String getName() {
        return name;
    }
    public void setname(String n){
        this.name=n;
    }

    public double getX() {
        return x;
    }
    public void setX(int x){
        this.x=x;
    }
    public double GetY() {
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public LocationTypes getType() {
        return type;
    }
    public void SetType(LocationTypes type){
        this.type=type;
    }

    @Override
    public String toString() {
        return "Locations [name=" + name + ", x=" + x + ", y=" + y + ", type=" + type + "]";
    }

}
