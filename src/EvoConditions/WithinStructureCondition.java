package EvoConditions;

public class WithinStructureCondition {
    private String structure;
    public final String evoConditionType = "withinStructure";

    public WithinStructureCondition(String structure) {
        this.structure = structure;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public String toString() {
        return "{" +
                "structure='" + structure + '\'' +
                ", evoConditionType='" + evoConditionType + '\'' +
                '}';
    }
}
