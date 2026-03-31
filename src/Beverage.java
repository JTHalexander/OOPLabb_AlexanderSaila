import java.util.Random;

public class Beverage {

    private String name;
    private double price;
    private int stock;
    private int timesSelected;

    public Beverage(String name, double price){

        Random rand = new Random();

        this.name = name;
        this.price = price;
        this.stock = rand.nextInt(20) + 1;
        this.timesSelected = 0;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %6.2f.kr | %-2d %n",  this.name, this.price, this.stock);
    }

    public void setName(String name){

        this.name = name;
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

    public void adjustStock(int amount) {
        int result = this.stock + amount;
        if (!(result < 0)) {
            this.price = result;
        }
        else {

            System.out.println("Warning: there are only " + this.stock + " available");
        }
    }
}
