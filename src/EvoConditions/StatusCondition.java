package EvoConditions;

public class StatusCondition {
    private String type;
    public final String evoConditionType = "status";

    public StatusCondition(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void String(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", evoConditionType='" + evoConditionType + '\'' +
                '}';
    }
}
