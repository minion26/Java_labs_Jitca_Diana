
public class Airport extends LocationTypes{
    private int numberOfTerminals;

    public Airport(int number, int population){
        super(population);
        this.numberOfTerminals = number;
    }

    public void setTerminals(int number){
        this.numberOfTerminals = number;
    }

    public int getTerminals(){
        return this.numberOfTerminals;
    }
}

