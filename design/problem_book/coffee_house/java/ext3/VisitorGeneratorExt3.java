package ext3;

import base.CoffeeHouse;
import base.Visitor;
import base.VisitorGenerator;

public class VisitorGeneratorExt3 extends VisitorGenerator {
    public VisitorGeneratorExt3(CoffeeHouse model) {
        super(model);
    }

    @Override
    protected Visitor generateVisitor() {
        return new VisitorExt3(model);
    }
}
