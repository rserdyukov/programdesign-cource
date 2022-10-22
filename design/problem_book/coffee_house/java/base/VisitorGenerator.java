package base;

public class VisitorGenerator {
    public VisitorGenerator(CoffeeHouse model) {
        this.model = model;
    }

    public void process(long currentTime) {
        if (nextActionTime <= currentTime) {
            var visitor = generateVisitor();
            nextActionTime += Settings.VISITOR_GENERATE_TIME_PERIOD;
            System.out.println("Time=" + currentTime + " Generate visitor " + visitor);
        }
    }

    protected Visitor generateVisitor() {
        return new Visitor(model);
    }

    protected final CoffeeHouse model;
    private long nextActionTime = 0;
}
