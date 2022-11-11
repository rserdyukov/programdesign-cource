package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeHouse {
    public CoffeeHouse() {
    }

    public void run() {
        createMenu();

        while (currentTime < Settings.CLOSING_TIME) {
            for (var visitor : outgoingVisitorList) {
                visitor.getCashDesk().removeVisitor(visitor);
            }
            outgoingVisitorList.clear();

            assert visitorGenerator != null;
            visitorGenerator.process(currentTime);

            for (var cash_desk: cashDeskList) {
                cash_desk.getWorker().process(currentTime);
                for (var visitor: cash_desk.getVisitorList()) {
                    visitor.process(currentTime);
                }
            }

            currentTime += Settings.TICK_TIME;
        }
    }

    public VisitorRequestStatus requestProduct(Product product) {
        if (product.isNeedPrepare()) {
            if (recipeMap.containsKey(product)) {
                return VisitorRequestStatus.NEED_PREPARE;
            }
        } else {
            if (dessertMap.getOrDefault(product, 0) > 0) {
                return VisitorRequestStatus.SUCCESS;
            }
        }

        return VisitorRequestStatus.PRODUCT_MISSING;
    }

    public void setVisitorGenerator(VisitorGenerator visitorGenerator) {
        this.visitorGenerator = visitorGenerator;
    }

    public void addRating(int rating) {
        ratingSum += rating;
        ratingAmount += 1;
    }

    public float getAvgRating() {
        return (float) ratingSum / (float) ratingAmount;
    }

    public void visitorLeave(Visitor visitor) {
        outgoingVisitorList.add(visitor);
    }

    public void createMenu() {
        menuList.addAll(dessertMap.keySet());
        menuList.addAll(recipeMap.keySet());
    }

    public List<Product> getMenu() {
        return menuList;
    }

    public void addDessert(Product dessert, int amount) {
        dessertMap.put(dessert, amount);
    }

    public void takeProduct(Product product) {
        if (! product.isNeedPrepare()) {
            var currentAmount = dessertMap.getOrDefault(product, 0);
            if (currentAmount > 0) {
                dessertMap.replace(product, currentAmount - 1);
            }
        }
    }

    public void addRecipe(Product product, Recipe recipe) {
        recipeMap.put(product, recipe);
    }

    public Recipe getRecipe(Product product) {
        return recipeMap.getOrDefault(product, null);
    }

    public void addIngredient(Ingredient ingredient, int amount) {
        ingredientMap.put(ingredient, amount);
    }

    public boolean takeIngredient(Ingredient ingredient, int amount) {
        var currentAmount = ingredientMap.getOrDefault(ingredient, 0);
        if (currentAmount - amount >= 0) {
            ingredientMap.replace(ingredient, currentAmount - amount);
            return true;
        }
        return false;
    }


    public void addCashDesk(CashDesk cashDesk) {
        cashDeskList.add(cashDesk);
    }

    public List<CashDesk> getCashDeskList() {
        return cashDeskList;
    }

    private VisitorGenerator visitorGenerator = null;
    final private Map<Product, Integer> dessertMap = new HashMap<>();
    final private Map<Product, Recipe> recipeMap = new HashMap<>();
    final private List<CashDesk> cashDeskList = new ArrayList<>();
    final private List<Product> menuList = new ArrayList<>();
    final private List<Visitor> outgoingVisitorList = new ArrayList<>();
    final private Map<Ingredient, Integer> ingredientMap = new HashMap<>();

    private long currentTime = 0;

    private long ratingSum = 0;
    private long ratingAmount = 0;
}
