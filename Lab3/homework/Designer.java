/*This class extends the Person class
 * @author Jitca Diana */
public class Designer extends Person{

    private String typeOf;

    //constructor
    public Designer(String name, String bday, String type){
        super(name, bday);
        this.typeOf = type;
    }

    //settere si gettere
    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }
}
