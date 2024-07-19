package EvoConditions;

public class MoveUsesCondition {
    private int uses;
    public final String evoConditionType = "moveUses";

    public MoveUsesCondition(int uses) {
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    @Override
    public String toString() {
        return "{" + "uses=" + uses + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
