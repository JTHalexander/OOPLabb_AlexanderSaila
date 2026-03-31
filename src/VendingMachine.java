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
                Beverage tempBev = this.inv[choice-1];

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
                        tempBev.decreaseStock(choice);
                        cart[cartSize] = new Beverage(tempBev.getName(), tempBev.getPrice(), choice);
                    }

                    break;
                }
            }
        }
        summary(cart, cartSize);
    }

    private void summary(Beverage[] cart, int cartSize){

        double totalCost = 0;

        System.out.println("** SUMMARY **");

        for(int i=0; i<cartSize; i++){

            double cost = cart[i].getStock() * cart[i].getPrice();
            totalCost += cost;
            System.out.println((i+1)+ ". " + cart[i].getName() + ". Cost: " + cost);
        }

        System.out.println("Total cost: " + totalCost);

    }

}
