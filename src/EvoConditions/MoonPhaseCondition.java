package EvoConditions;

public class MoonPhaseCondition {
    private int moonPhase;
    public final String evoConditionType = "moonPhase";

    public MoonPhaseCondition(int moonPhase) {
        this.moonPhase = moonPhase;
    }

    public int getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(int moonPhase) {
        this.moonPhase = moonPhase;
    }

    @Override
    public String toString() {
        return "{" + "moonPhase=" + moonPhase + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }

}
