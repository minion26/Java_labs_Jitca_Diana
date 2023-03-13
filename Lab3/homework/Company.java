/*
 * This is a class for the companies
 * It  implements the interface java.util.Comparable and the interface Node
 * @author Jitca Diana
 * */
public class Company extends NodeOfNetwork implements Node{

    //Override the function compareTo

/*    public int compareTo(Company o) {
        if(this.companyName.compareTo(o.companyName) == 0){
            return 0;
        }else{
            if (this.companyName.compareTo(o.companyName) < 0){
                return -1;
            }else{
                return 1;
            }

        }
    }*/

    private String companyName;

    //constructor
    Company(String name){
        this.companyName = name;
    }

    //getters and setters
    public String getName() {
        return this.companyName + "[COMPANY]";
    }

    public void setName(String companyName) {
        this.companyName = companyName;
    }

    //override the toString for visual output
    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
