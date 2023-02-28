public class Test {

    //testez functionalitatea
    public static void main(String[] args) {
        //creem 2 locatii
        Locations loc1 = new Locations("A", 0, 0, LocationTypes.home);
        Locations loc2 = new Locations("B", 1, 1, LocationTypes.work);
        //creem tipul de drum intre cele 2 locatii

        Roads road1 = new Roads(50, RoadsTypes.highway, loc1, loc2);
        System.out.println(road1);

        Locations loc3 = new Locations("Tecuci", 0.1, 0.2, LocationTypes.home);
        System.out.println(loc3);

    }
}
