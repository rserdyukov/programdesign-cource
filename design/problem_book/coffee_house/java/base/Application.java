package base;



// coffee machine
// cappuccinatore
// refrigerator

// recipe
// worker
// cook - готовить

// coffee beans
// milk
// syrup
// rating
// visitor
// cash desk

class Application
{
    public static void main(String[] args) {
        Application app = new Application();
        var model = app.build();
        System.out.println("Start modeling");
        model.run();
        System.out.printf("Finish rating: %f\n", model.getAvgRating());
    }
    // https://bengusta.com.ua/blog/wp-content/uploads/2018/09/coffee-types-1-1024x652.jpg
    protected CoffeeHouse build() {
        CoffeeHouse model = new CoffeeHouse();
        model.setVisitorGenerator(new VisitorGenerator(model));

        var cashDesk = new CashDesk();
        cashDesk.setWorker(new Worker(model, cashDesk));
        model.addCashDesk(cashDesk);

        cashDesk = new CashDesk();
        cashDesk.setWorker(new Worker(model, cashDesk));
        model.addCashDesk(cashDesk);

        model.addDessert(new Product("Печенье", false), 20);
        model.addDessert(new Product("Пирожное", false), 20);
        model.addDessert(new Product("Торт", false), 20);

        var coffeeBeans = new Ingredient("Кофейные зерна");
        var milk = new Ingredient("Молоко");
        var syrup = new Ingredient("Сироп");

        model.addIngredient(coffeeBeans, 1000);
        model.addIngredient(milk, 200);
        model.addIngredient(syrup, 100);

        var coffeeMachine = new KitchenMachine("Кофе машина");
        var cappuccinatore = new KitchenMachine("Капучинатор");

        model.addRecipe(new Product("Эспрессо", true),
                new Recipe()
                        .addStep(new RecipeStep(coffeeBeans, 5, coffeeMachine, 120))
        );
        model.addRecipe(new Product("Раф кофе", true),
                new Recipe()
                        .addStep(new RecipeStep(syrup, 10, null, 10))
                        .addStep(new RecipeStep(coffeeBeans, 5, coffeeMachine, 120))
                        .addStep(new RecipeStep(milk, 10, cappuccinatore, 100))
        );
        model.addRecipe(new Product("Каппучино", true),
                new Recipe()
                        .addStep(new RecipeStep(coffeeBeans, 5, coffeeMachine, 120))
                        .addStep(new RecipeStep(milk, 10, null, 10))
                        .addStep(new RecipeStep(milk, 10, cappuccinatore, 100))
        );

        return model;
    }
}