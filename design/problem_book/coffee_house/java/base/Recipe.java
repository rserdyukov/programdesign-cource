package base;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public Recipe addStep(RecipeStep step) {
        stepList.add(step);
        return this;
    }

    public List<RecipeStep> getStepList() {
        return stepList;
    }

    private List<RecipeStep> stepList = new ArrayList<>();
}
