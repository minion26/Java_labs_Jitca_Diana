/*This class extends the Person class
 * @author Jitca Diana */
public class Programmer extends Person{

    private String programmingLanguage;

    //constructor
    public Programmer(String name, String bday, String language){
        super(name, bday);
        this.programmingLanguage = language;
    }



    //settere si gettere
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
