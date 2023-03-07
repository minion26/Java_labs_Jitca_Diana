import java.util.ArrayList;
import java.util.List;
/*This class has the main method and tests functionality
* @author Jitca Diana */
public class Main {
    public static void main(String[] args){
       /* Company bytex = new Company("Bytex");
        Person vlad = new Person("Vlad");
        Company bit = new Company("Bit");
        Person ana = new Person("Ana");*/

        /*System.out.println(ana.getName());
        System.out.println(bytex.compareTo(bit));
        System.out.println(ana.compareTo(vlad));*/

        //Create a java.util.List containing node objects and print it on the screen.
        List<Node> list = new ArrayList<>();

        //adding person object to the list of nodes
        Person p0 = new Person("Ana");
        list.add(p0);

        Person p1 = new Person("Vlad");
        //checking if they have unique names
        if(list.contains(p1)){
            System.out.println("This person already exists!");
        }
        else{
            list.add(p1);
        }

        //adding company object to the list of nodes
        Company c0 = new Company("Bytex");
        list.add(c0);

        Company c1 = new Company("Bit");
        //checking if they have unique names
        if(list.contains(c1)){
            System.out.println("This company already exists!");
        }else{
            list.add(c0);
        }

        //printing out the list
        System.out.println(list);

    }
}
