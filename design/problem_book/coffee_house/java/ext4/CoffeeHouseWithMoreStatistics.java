package ext4;

import base.CoffeeHouse;
import base.Product;
import base.Visitor;

public class CoffeeHouseWithMoreStatistics extends CoffeeHouse {

    public void printMoreStatistics() {
        System.out.println("Visitors: " + visitorCounter);
        System.out.println("Dessert: " + dessertCounter);
        System.out.println("Drink: " + drinkCounter);
    }

    @Override
    public void visitorLeave(Visitor visitor) {
        super.visitorLeave(visitor);
        visitorCounter += 1;
    }

    @Override
    public void takeProduct(Product product) {
        super.takeProduct(product);
        if (product.isNeedPrepare()) {
            drinkCounter += 1;
        } else {
            dessertCounter += 1;
        }
    }

    private int visitorCounter = 0;
    private int dessertCounter = 0;
    private int drinkCounter = 0;
}
