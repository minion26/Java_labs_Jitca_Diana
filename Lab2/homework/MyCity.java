/*
* This is the instantiation of the problem, a city with a name and multiple locations and roads
* You have the possibility to add locations and roads
* You can check if you can go from one location to another
* @author Jitca Diana
* */
import java.util.*;

public class MyCity {
    private String name;

    //constructor
    public MyCity(String n){
        this.name = n;
    }

    //array of locations and roads
    private Locations [] arrayOfLocationTypes = new Locations [5];
    private int iterator1 = 0;
    private Roads [] arrayOfRoadTypes = new Roads [5];
    private int iterator2 = 0;

    //matrix for the roads with the nodes being the id of the locations
    // and the values being 1 if there is a road between them and 0 if there is no road
    int [][] matrix = new int [5][5];

    /*method for adding locations
    * @param nume - the name of the location
    * @param x - the x coordinate of the location
    * @param y - the y coordinate of the location
    * @param types - the type of the location
    * @return void
     */
    public void addLocation(String nume, double x, double y, LocationTypes types){
        int iterator;
        int sw = 0;
        //if the location already exists, it will not be added
        for ( iterator = 0; iterator < iterator1; iterator++){
            if (arrayOfLocationTypes[iterator].equals(new Locations(nume, x, y, types, iterator1))){
                sw = 1;
            }
        }

        //if not, it will be added
        if(sw == 0){
            arrayOfLocationTypes[iterator1] =  new Locations(nume, x, y, types, iterator1);
            iterator1++;
        }

    }

    /*method for adding locations
     * @param speedLimit - the speed limit of the road
     * @param start - the start location of the road
     * @param end - the end location of the road
     * @param type - the type of the road
     * @return void
     */
    public void addRoads(int speedLimit, int start, int end, RoadTypes type){
        int iterator;
        int sw = 0;
        //if the road already exists, it will not be added
        for ( iterator = 0; iterator < iterator2; iterator++){
            if (arrayOfRoadTypes[iterator].equals(new Roads(speedLimit, arrayOfLocationTypes[start], arrayOfLocationTypes[end], type))){
               sw = 1;
            }
        }

        //if not, it will be added
        if(sw == 0){
            arrayOfRoadTypes[iterator2] =  new Roads(speedLimit, arrayOfLocationTypes[start], arrayOfLocationTypes[end], type);
            matrix[arrayOfLocationTypes[start].getId()][arrayOfLocationTypes[end].getId()] = 1;
            matrix[arrayOfLocationTypes[end].getId()][arrayOfLocationTypes[start].getId()] = 1;
            iterator2++;
        }
    }

    //override method from the Object class
    @Override
    public String toString() {
        return "MyCity{" +
                "name='" + name + '\'' +
                ", arrayOfLocationTypes=" + Arrays.toString(arrayOfLocationTypes) +
                ", arrayOfRoadTypes=" + Arrays.toString(arrayOfRoadTypes) +
                '}';
    }

    /*method for showing the roads
    * @return a string with the roads
     */
    public String showRoads(){
        StringBuilder raspuns = new StringBuilder();

        for (int i = 0; i < iterator2; i++){
            raspuns.append("Road ").append(arrayOfRoadTypes[i].getType()).append(" [length=").append(arrayOfRoadTypes[i].getLength()).append(", speedLimit=").append(arrayOfRoadTypes[i].getSpeedLimit()).append("]");
            raspuns.append("\n");
        }
        return raspuns.toString();

    }

    /*method for showing the locations
    * @return a string with the locations
     */
    public String showLocations(){
        StringBuilder raspuns = new StringBuilder();

        for (int i = 0; i < iterator1; i++){
            raspuns.append("Location ").append(arrayOfLocationTypes[i].getType()).append(" [name=").append(arrayOfLocationTypes[i].getName()).append(" id= ").append(arrayOfLocationTypes[i].getId()).append("]");
            raspuns.append("\n");

        }
        return raspuns.toString();

    }

    //[DEBUG] method for showing the matrix
    public void showMatrix(){
        for(int i=0; i < 5; i++){
            for(int j=0; j < 5; j++){
                System.out.print(this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    /*check if we can go from one location to another location using bfs
    * @param start - the id of the starting location
    * @param end - the id of the ending location
    * @return a message if we can go or not
     */
    public void checkIfWeCanGo(int start, int end) {
        //BFS algorithm
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[5];
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (node == end) {
                System.out.println("We can go from " + start + " to " + end);
                return;
            }
            for (int i = 0; i < 5; i++) {
                if (matrix[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    if(i == end){
                        System.out.println("We can go from " + start + " to " + end);
                        return;
                    }
                }
            }
        }

        System.out.println("We can't go from " + start + " to " + end);

    }
    //TODO: find the shortest path between two locations with dijkstra algorithm


}
