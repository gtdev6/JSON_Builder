package EvoConditions;

public class LevelCondition {
    private int level;
    public final String evoConditionType = "level";

    public LevelCondition(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "{" + "level=" + level + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
