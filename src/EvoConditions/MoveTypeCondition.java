package EvoConditions;

public class MoveTypeCondition {
    private String type;
    public final String evoConditionType = "moveType";

    public MoveTypeCondition(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" + "type=" + type + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
