/*
 * This is a class for the types of Locations that can exists in the application
 * @author Jitca Diana
 * */
public class Home extends LocationTypes{

    int numberOfRooms;

    //constructor with 2 parameters
    public Home(int rooms, int population){
        super(population);
        this.numberOfRooms = rooms;
    }

    //setters and getters for the number of rooms
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
