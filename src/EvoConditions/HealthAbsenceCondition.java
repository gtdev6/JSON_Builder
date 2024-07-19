package EvoConditions;

public class HealthAbsenceCondition {
    private int health;
    public final String evoConditionType = "healthAbsence";

    public HealthAbsenceCondition(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "{" + "health=" + health + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }

}
