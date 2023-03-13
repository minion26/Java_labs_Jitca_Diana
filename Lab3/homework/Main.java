import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*This class has the main method and tests functionality
 * @author Jitca Diana */
public class Main {
    public static void main(String[] args){

        /*
        * Creez mai multe instante ale claselor*/
        Person p0 = new Designer("Carmen", "12-2-1990", "UX");
        Person p1 = new Programmer("Diana", "20-02-2002", "Java");
        Company c0 = new Company("Bytex");
        Company c1 = new Company("Bit");
        Company c2 = new Company("Endava");

        /*
        * Creez un network ce va avea ca noduri instantele claselor de mai sus*/
        Network n1 = new Network();

        n1.addNode(p0);
        n1.addNode(p1);
        n1.addNode(c0);
        n1.addNode(c1);
        n1.addNode(c2);

        /*
        * adaug relatii intre acestea*/
        p0.addRelashioship(p1, "friend"); //carmen-diana
        p0.addRelashioship(c1, "business"); //carmen-bit
        p1.addRelashioship(c0, "business"); //diana->bytex
        c0.addRelashioship(p1, "company"); //bytex->diana
        p1.addRelashioship(c2, "business"); // diana-endava
        p0.addRelashioship(c0, "business"); //carmen-bytex
        // carmen-3
        // diana-2
        // bytex-1
        // bit-0
        // endava-0


        //p0.showRelashionships();

        //System.out.println(n1);

        /*
        * sortez lista dupa gradul nodurilor*/
        n1.sort();
        System.out.println("Sorted list: "+n1);


    }



}
