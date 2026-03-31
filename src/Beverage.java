
public class Beverage {

    private String name;
    private double price;
    private int stock;
    private int timesSelected;

    public Beverage(String name, double price, int amount){

        this.name = name;
        this.price = price;
        this.stock = amount;
        this.timesSelected = 0;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %6.2f.kr | %-2d %n",  this.name, this.price, this.stock);
    }

    public String getName(){

        return this.name;
    }

    public double getPrice(){

        return this.price;
    }

    public int getStock(){

        return this.stock;
    }

    public int getTimesSelected(){

        return this.timesSelected;
    }

    public void increaseStock(int amount){
        this.stock += amount;
    }

    public void decreaseStock(int amount) {

        this.timesSelected++;

        if(this.stock == 0){
            System.out.println("Cannot take anymore " + this.name);
        }
        else{
            this.stock -= amount;
            this.timesSelected++;
        }
    }
}
