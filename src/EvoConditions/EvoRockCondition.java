package EvoConditions;

public class EvoRockCondition {
    EvolutionRockType evolutionRock;
    private int maxRangeSquared;
    public final String evoConditionType = "evolutionRock";

    public EvoRockCondition() {
    }

    public EvoRockCondition(EvolutionRockType evolutionRock, int maxRangeSquared) {
        this.evolutionRock = evolutionRock;
        this.maxRangeSquared = maxRangeSquared;
    }

    public EvolutionRockType getEvolutionRock() {
        return evolutionRock;
    }

    public void setEvolutionRock(EvolutionRockType evolutionRock) {
        this.evolutionRock = evolutionRock;
    }

    public int getMaxRangeSquared() {
        return maxRangeSquared;
    }

    public void setMaxRangeSquared(int maxRangeSquared) {
        this.maxRangeSquared = maxRangeSquared;
    }

    @Override
    public String toString() {
        return "{" + "Evolution Rock=" + evolutionRock + ", maxRangeSquared=" + maxRangeSquared + ", evoConditionType='"
                + evoConditionType + '\'' + '}';
    }

}
