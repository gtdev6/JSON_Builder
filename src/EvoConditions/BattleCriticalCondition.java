package EvoConditions;

public class BattleCriticalCondition {
    private int critical;
    public final String evoConditionType = "critical";

    public BattleCriticalCondition() {
    }

    public BattleCriticalCondition(int critical) {
        this.critical = critical;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    @Override
    public String toString() {
        return "{" + "critical=" + critical + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
