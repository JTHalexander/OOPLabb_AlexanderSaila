import java.util.Random;

void main() {

    Random myRand = new Random();

    Beverage[] myBevs = {
            new Beverage("Coca-Cola", 11.50, myRand.nextInt(20)+1),
            new Beverage("Fanta", 9.50, myRand.nextInt(20)+1),
            new Beverage("Coffee", 5.00, myRand.nextInt(20)+1),
            new Beverage("Sprite", 9.50, myRand.nextInt(20)+1)
    };

    VendingMachine myVend = new VendingMachine(myBevs);

    myVend.run();
    myVend.stats();

}
