package EvoConditions;

public class MoveCondition {
    private String attackName;
    public final String evoConditionType = "move";

    public MoveCondition() {
    }

    public MoveCondition(String attackName) {
        this.attackName = attackName;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    @Override
    public String toString() {
        return "{" + "attackName=" + attackName + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
