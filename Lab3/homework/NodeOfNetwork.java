import java.util.HashMap;
import java.util.Map;
/*This class creates the nodes that will be in the Network class
 * @author Jitca Diana */

public class NodeOfNetwork implements Comparable{
    /*mapa pentru a descrie relatiile*/
    protected Map<String, String> myMap = new HashMap<>();


    //adauga relatii intre 2 persoane si specifica tipul
    public void addRelashioship(Person p2, String type){
        myMap.put(p2.getName(), type);

        //System.out.println(p2.getName());
    }

    //adauga relatii intre o persoana si o companie si specifica tipul
    public void addRelashioship(Company c, String type){
        myMap.put(c.getName(), type);

        //System.out.println(c.getName());
    }

    //arata relatiile existente
    public void showRelashionships() {
        StringBuilder str = new StringBuilder();
        str.append(this);
        str.append("is connected to: ");
        for (String url : this.myMap.keySet()){
            str.append(url);
            str.append(" ");
        }
        System.out.println(str);

    }

    //arata gradul unui nod, adica cate conexiuni are
    public Integer degree(){
        Integer id=0;
        for (String name : myMap.keySet()){
            id++;
        }

        //System.out.println("the degree is: "+id);
        return id;
    }


    @Override
    public int compareTo(Object o) {
        if (this.degree() == ((NodeOfNetwork)o).degree()){
            return 0;
        }
        else{
            if(this.degree() < ((NodeOfNetwork)o).degree()){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
