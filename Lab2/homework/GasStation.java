/*
 * This is a class for the types of Locations that can exists in the application
 * @author Jitca Diana
 * */
public class GasStation extends LocationTypes{
    private double priceGas;

    //constructor with 2 parameters
    public GasStation(double price, int population){
        super(population);
        this.priceGas = price;
    }

    //setters and getters for the price of gas
    public void setPrice(double price){
        this.priceGas = price;
    }

    public double getPrice(){
        return this.priceGas;
    }
}

