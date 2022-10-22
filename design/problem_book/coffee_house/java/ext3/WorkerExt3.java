package ext3;

import base.CashDesk;
import base.CoffeeHouse;
import base.Worker;

import java.util.Random;

public class WorkerExt3 extends Worker {
    public WorkerExt3(CoffeeHouse model, CashDesk cashDesk) {
        super(model, cashDesk);
    }

    @Override
    protected void prepareProductProcess(long currentTime) {
        if (currentRecipe != null) {
            var isFail = new Random().nextBoolean();
            if (isFail) {
                cashDesk.getFirstVisitor().failDesiredProduct(currentTime, currentProduct);
                prepareProductFinished(currentTime);
            }
        }
        super.prepareProductProcess(currentTime);
    }
}
