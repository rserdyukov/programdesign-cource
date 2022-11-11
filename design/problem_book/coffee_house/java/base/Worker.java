package base;

public class Worker {

    public Worker(CoffeeHouse model, CashDesk cashDesk) {
        this.cashDesk = cashDesk;
        this.model = model;
    }


    public void process(long currentTime) {
        if (currentRecipe == null) {
            var visitor = cashDesk.getFirstVisitor();
            if (visitor == null) {
                return;
            }

            currentProduct = visitor.getDesiredProduct();
            if (currentProduct.isNeedPrepare()) {
                currentRecipe = model.getRecipe(currentProduct);
                System.out.println("Time=" + currentTime +" Worker(" + hashCode() + ") start prepare product " + currentProduct);
            } else {
                visitor.askDesiredProduct(currentTime);
            }
        }

        if (currentRecipe != null) {
            prepareProductProcess(currentTime);
        }
    }

    protected void prepareProductProcess(long currentTime) {
        if (nextActionTime == 0) {
            recipeStepIndex = 0;
            var step = getRecipeStep(recipeStepIndex);
            assert step != null;

            nextActionTime = currentTime;
            processStepTime(step);
        } else if (nextActionTime <= currentTime) {
            var step = getRecipeStep(recipeStepIndex);
            assert step != null;

            var result = model.takeIngredient(step.getIngredient(), step.getAmount());
            if (!result) {
                cashDesk.getFirstVisitor().failDesiredProduct(currentTime, currentProduct);
                prepareProductFinished(currentTime);
            }
            recipeStepIndex += 1;
            var nextStep = getRecipeStep(recipeStepIndex);
            if (nextStep == null) {
                // finish prepare
                model.takeProduct(currentProduct);
                cashDesk.getFirstVisitor().givePreparedProduct(currentTime, currentProduct);
                prepareProductFinished(currentTime);
            } else {
                processStepTime(nextStep);
                prepareProductProcess(currentTime);
            }
        }
    }

    protected void prepareProductFinished(long currentTime) {
        System.out.println("Time=" + currentTime + " Worker(" + hashCode() + ") finish prepare " + currentProduct);
        nextActionTime = 0;
        recipeStepIndex = 0;
        currentProduct = null;
        currentRecipe = null;
    }

    protected void processStepTime(RecipeStep step) {
        nextActionTime += step.getTime();
    }

    private RecipeStep getRecipeStep(int index) {
        assert currentRecipe != null;
        var stepList = currentRecipe.getStepList();
        return stepList.size() > recipeStepIndex? stepList.get(recipeStepIndex) : null;
    }

    protected final CashDesk cashDesk;
    protected final CoffeeHouse model;

    protected Product currentProduct = null;
    protected Recipe currentRecipe = null;
    protected int recipeStepIndex = 0;

    protected long nextActionTime = 0;
}
