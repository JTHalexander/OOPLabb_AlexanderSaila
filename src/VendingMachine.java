import java.util.Scanner;

public class VendingMachine {

    private int capacity;
    private int emptySpot;
    private Beverage[] inv;

    public VendingMachine(Beverage[] beverages){

        this.capacity = beverages.length*2;
        this.emptySpot  = beverages.length;
        this.inv = beverages;
    }

    public void displayInventory(){

        for(int i=0; i<emptySpot; i++){
            System.out.printf((i+1) + ". " + this.inv[i].toString());
        }
        System.out.println();
    }

    public void addBeverage(Beverage bev){

        // if current array is too small to fit more beverages, create larger array
        if(emptySpot == capacity){
            Beverage[] expandedInv = new Beverage[capacity*2];
            for(int i=0; i<capacity; i++){
                expandedInv[i] = this.inv[i];
            }
            this.inv = expandedInv;
            this.capacity *= 2;
        }

        inv[emptySpot++] = bev;
    }

    public void run(){

        Beverage[] cart = new Beverage[emptySpot];
        int cartSize = 0;
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("** Make a selection **");
            displayInventory();
            System.out.println("Type 0 to check out..");
            int choice = sc.nextInt();

            if(choice == 0){
                break;
            }
            else if(!(choice < emptySpot) || choice < 0){
                continue;
            }
            else{
                while(true) {

                    Beverage tempBev = this.inv[choice-1];

                    System.out.printf("You chose " + tempBev.getName() + ".. %nSpecify amount: ");
                    choice = sc.nextInt();

                    if(choice > tempBev.getStock()){
                        System.out.println("Sorry you cant withdraw that many..");
                        continue;
                    }
                    else{
                        System.out.println("Ok withdrawing " + choice + "..");
                        cart[cartSize] = new Beverage(tempBev.getName(), tempBev.getPrice(), choice);
                    }

                    break;
                }
            }
        }
        //print cart
    }

}
