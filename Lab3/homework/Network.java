import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/*
 * This is a class for the network
 * Creates  a List of identifiable NodeOfNetwork nodes
 * @author Jitca Diana
 * */

public class Network{

    private List<NodeOfNetwork> nodes = new ArrayList<>();

    //adds the node to the list
    public void addNode(NodeOfNetwork n){

            nodes.add(n);

    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }


    //sorts the list after the degree (number of conexions)
    public void sort() {
        //Collections.sort(nodes);
        //testList.sort(Comparator.comparing(ClassName::getFieldName));
        nodes.sort(Comparator.comparing(NodeOfNetwork::degree).reversed());

    }

}
