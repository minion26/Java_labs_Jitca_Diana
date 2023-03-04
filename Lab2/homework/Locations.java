/*
 * This is a class for the locations with the coordinates, the name and the type of location
 * @author Jitca Diana
 * */
import java.util.Objects;

public class Locations {
    private String name;
    private double x;
    private double y;

    LocationTypes type;

    private int id;


    /**
     * This is the constructor for the class
     * */
    public Locations(String name, double x, double y, LocationTypes t, int id) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.type = t;
        this.id = id;
    }
    //settere si gettere

    public int getId(){
        return this.id;
    }
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
    public double getY() {
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public LocationTypes getType() {
        return type;
    }
    public void setType(LocationTypes type){
        this.type=type;
    }

    //2 overrides methods from the Object class
    @Override
    public String toString() {
        return "Locations [name=" + name + ", x=" + x + ", y=" + y ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locations locations = (Locations) o;
        return Double.compare(locations.x, x) == 0 && Double.compare(locations.y, y) == 0 && Objects.equals(name, locations.name) && Objects.equals(type, locations.type);
    }


}
