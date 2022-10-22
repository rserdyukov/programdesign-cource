package ext1;

import base.CashDesk;
import base.CoffeeHouse;
import base.RecipeStep;
import base.Worker;

import java.util.Random;

public class WorkerWithSpeed extends Worker {
    public WorkerWithSpeed(CoffeeHouse model, CashDesk cashDesk) {
        super(model, cashDesk);
        speed = new Random().nextFloat() * 10; // [0..10]
    }

    protected void processStepTime(RecipeStep step) {
        nextActionTime += step.getTime() / speed;
    }

    private final float speed;
}
