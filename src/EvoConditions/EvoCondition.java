package EvoConditions;

public class EvoCondition {
    private String evoConditionType;

    public EvoCondition() {
    }

    public EvoCondition(String evoConditionType) {
        this.evoConditionType = evoConditionType;
    }

    public String getEvoConditionType() {
        return evoConditionType;
    }

    public void setEvoConditionType(String evoConditionType) {
        this.evoConditionType = evoConditionType;
    }

    @Override
    public String toString() {
        return "{" + "evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
