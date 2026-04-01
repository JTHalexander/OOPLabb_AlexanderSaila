import java.util.Scanner;

public class VendingMachine {

    private int size;
    private Beverage[] inv;

    public VendingMachine(Beverage[] beverages){

        this.size = beverages.length;
        this.inv = beverages;
    }

    public void stats(){

        System.out.println("**STATS**");
        for(Beverage bev : inv){
            System.out.printf("%-10s has been selected -> %d times %n" , bev.getName(), bev.getTimesSelected());
        }
        System.out.println();
    }

    public void displayInventory(){

        for(int i = 0; i< size; i++){
            System.out.printf((i+1) + ". " + this.inv[i].toString());
        }
        System.out.println();
    }

    public void run(){

        Beverage[] cart = new Beverage[size];
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
            else if(!(choice < size) || choice < 0){
                continue;
            }
            else{
                Beverage tempBev = this.inv[choice-1];

                while(true) {

                    System.out.printf("You chose " + tempBev.getName() + ".. %nSpecify amount: ");
                    choice = sc.nextInt();

                    if(choice > tempBev.getStock()){

                        System.out.println("Sorry you cant withdraw that many..");
                        continue;
                    }
                    else{

                        System.out.println("Ok withdrawing " + choice + "..");
                        tempBev.decreaseStock(choice);
                        if(addToCart(cart, new Beverage(tempBev.getName(), tempBev.getPrice(), choice), cartSize)){
                            cartSize++;
                        }

                    }

                    break;
                }
            }
        }
        summary(cart, cartSize);
    }

    private boolean addToCart(Beverage[] cart, Beverage beverage, int cartSize){

        boolean foundDuplicate = false;
        //check for duplicates
        for(int i=0; i<cartSize; i++){

            if(cart[i].getName().equals(beverage.getName())){

                cart[i].increaseStock(beverage.getStock());
                foundDuplicate = true;
                break;
            }
        }
        if(!foundDuplicate){
            cart[cartSize] = beverage;
            return true;
        }
        return false;
    }

    private void summary(Beverage[] cart, int cartSize){

        double totalCost = 0;

        System.out.println("** SUMMARY **");

        for(int i=0; i<cartSize; i++){

            double cost = cart[i].getStock() * cart[i].getPrice();
            totalCost += cost;
            System.out.println((i+1)+ ". " + cart[i].getName() + ". Cost: " + cost + " (" + cart[i].getStock() + ")");
        }

        System.out.println("Total cost: " + totalCost);
        System.out.println();

    }

    private void waitForInput(){
        Scanner pressAny = new Scanner(System.in);
        System.out.println("Press 'Enter' to continue..");
        pressAny.nextLine();
    }

}
