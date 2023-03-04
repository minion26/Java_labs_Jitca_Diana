/*
* This class has the main method and tests functionality with adding locations, roads and checking if we can go to a location
* to another using the existing roads
* @author Jitca Diana */
public class Main {
    public static void main(String [] args){
        MyCity Iasi = new MyCity("Iasi");
        Iasi.addLocation("acasa", 0, 0, new Home(3, 4));
        Iasi.addLocation("Lukoil", 1, 1, new GasStation(5.6, 10));
        Iasi.addLocation("Mol", 0.1, 2.1, new GasStation(5, 5));

        //add road between location 1 and location 2 meaning between home and gasStation
        Iasi.addRoads(60, 1, 2, new Highway());
        //Iasi.addRoads(50, 0, 2, new Highway());
        Iasi.checkIfWeCanGo(0,2);


        //System.out.println(Iasi.showRoads());
        //Iasi.showMatrix();
        //System.out.printf(Iasi.showLocations());
    }
}
