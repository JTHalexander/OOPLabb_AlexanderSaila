void main() {

    Beverage[] myBevs = {
            new Beverage("Coca-Cola", 11.50, 10),
            new Beverage("Fanta", 9.50, 4),
            new Beverage("Coffee", 5.00, 20),
            new Beverage("Sprite", 9.50, 6)
    };

    VendingMachine myVend = new VendingMachine(myBevs);
    
    myVend.run();
    myVend.stats();

}
