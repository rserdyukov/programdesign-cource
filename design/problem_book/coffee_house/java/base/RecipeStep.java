package base;

public class RecipeStep {
    public RecipeStep(Ingredient ingredient, int amount, KitchenMachine machine, long time)
    {
        this.ingredient = ingredient;
        this.amount = amount;
        this.machine = machine;
        this.time = time;
    }

    public Ingredient getIngredient() { return ingredient; }
    public int getAmount() { return amount; }
    public KitchenMachine getMachine() { return machine; }
    public long getTime() { return time; }

    private final Ingredient ingredient;
    private final int amount;
    private final KitchenMachine machine;
    private final long time;
}
