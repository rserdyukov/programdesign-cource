package ext2;

import base.CoffeeHouse;
import base.Visitor;
import base.VisitorGenerator;

public class VisitorGeneratorExt2 extends VisitorGenerator {
    public VisitorGeneratorExt2(CoffeeHouse model) {
        super(model);
    }

    @Override
    protected Visitor generateVisitor() {
        return new VisitorWithLastChance(model);
    }
}
