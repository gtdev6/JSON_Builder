package EvoConditions;

import java.util.ArrayList;
import java.util.Arrays;

public class NatureCondition {
    private ArrayList<String> natures;
    public final String evoConditionType = "nature";

    public NatureCondition(ArrayList<String> natures) {
        this.natures = natures;
    }

    public NatureCondition() {
    }

    public ArrayList<String> getNatures() {
        return natures;
    }

    public void setNatures(ArrayList<String> natures) {
        this.natures = natures;
    }

    @Override
    public String toString() {
        return "{" + "natures=" + Arrays.toString(natures.toArray()) + ", evoConditionType='" + evoConditionType + '\''
                + '}';
    }

}
