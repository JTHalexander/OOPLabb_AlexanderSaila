public class VendingMachine {

    private int capacity;
    private int emptySpot;
    private Beverage[] inv;

    public VendingMachine(){
        this.capacity = 1;
        this.emptySpot  = 0;
        this.inv = new Beverage[capacity];
    }

    public void displayInventory(){

        for(int i=0; i<emptySpot; i++){
            System.out.printf((i+1) + ". " + this.inv[i].toString());
        }
        System.out.println();
    }

    public void addBeverage(Beverage bev){

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

}
