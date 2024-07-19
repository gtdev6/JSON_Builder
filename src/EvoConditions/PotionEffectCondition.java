package EvoConditions;

import java.util.ArrayList;
import java.util.Arrays;

public class PotionEffectCondition {
    private ArrayList<String> potions;
    public final String evoConditionType = "potionEffect";

    public PotionEffectCondition(ArrayList<String> potions) {
        this.potions = potions;
    }

    public ArrayList<String> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<String> potions) {
        this.potions = potions;
    }

    @Override
    public String toString() {
        return "{" + "potions=" + Arrays.toString(potions.toArray()) + ", evoConditionType='" + evoConditionType + '\''
                + '}';
    }
}
