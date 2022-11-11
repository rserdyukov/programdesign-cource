package ext3;

import base.CoffeeHouse;
import base.Product;
import base.Visitor;

public class VisitorExt3 extends Visitor {
    public VisitorExt3(CoffeeHouse model) {
        super(model);
    }

    @Override
    public void failDesiredProduct(long currentTime, Product product) {
        if (product.isNeedPrepare()) {
            successRating -= 1;
            if (successRating > 1) {
                return;
            }
        }
        super.failDesiredProduct(currentTime, product);
    }
}
