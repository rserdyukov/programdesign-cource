package ext2;

import base.CoffeeHouse;
import base.Product;
import base.Visitor;

import java.util.Random;

public class VisitorWithLastChance extends Visitor {
    public VisitorWithLastChance(CoffeeHouse model) {
        super(model);
    }

    @Override
    public void failDesiredProduct(long currentTime, Product product) {
        if (successRating == 5) {
            successRating = 4;

            var menu = model.getMenu();
            Random rand = new Random();
            desiredProduct = menu.get(rand.nextInt(menu.size()));
        } else {
            super.failDesiredProduct(currentTime, product);
        }
    }
}
