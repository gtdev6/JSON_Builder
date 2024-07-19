package EvoConditions;

public class ChanceCondition {
    private double chance;
    public final String evoConditionType = "chance";

    public ChanceCondition() {
    }

    public ChanceCondition(double chance) {
        this.chance = chance;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "{" + "chance=" + chance + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
