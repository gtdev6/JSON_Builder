package EvoConditions;

import java.util.ArrayList;
import java.util.Arrays;

public class GenderCondition {
    private ArrayList<String> genders;
    public final String evoConditionType = "gender";

    public GenderCondition(ArrayList<String> genders) {
        this.genders = genders;
    }

    public ArrayList<String> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<String> genders) {
        this.genders = genders;
    }

    @Override
    public String toString() {
        return "{" + "genders=" + Arrays.toString(genders.toArray()) + ", evoConditionType='" + evoConditionType + '\''
                + '}';
    }

}
