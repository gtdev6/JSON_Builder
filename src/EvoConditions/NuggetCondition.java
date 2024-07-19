package EvoConditions;

public class NuggetCondition {
    private int nuggets;
    public final String evoConditionType = "nugget";

    public NuggetCondition(int nuggets) {
        this.nuggets = nuggets;
    }

    public int getNuggets() {
        return nuggets;
    }

    public void setNuggets(int nuggets) {
        this.nuggets = nuggets;
    }

    @Override
    public String toString() {
        return "{" + "nuggets=" + nuggets + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
