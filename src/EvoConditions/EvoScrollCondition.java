package EvoConditions;

public class EvoScrollCondition {
    private ScrollBlockType evolutionScroll;
    private int maxRangeSquared;
    public final String evoConditionType = "evolutionScroll";

    public EvoScrollCondition() {
    }

    public EvoScrollCondition(ScrollBlockType evolutionScroll, int maxRangeSquared) {
        this.evolutionScroll = evolutionScroll;
        this.maxRangeSquared = maxRangeSquared;
    }

    public ScrollBlockType getEvolutionScroll() {
        return evolutionScroll;
    }

    public void setEvolutionScroll(ScrollBlockType evolutionScroll) {
        this.evolutionScroll = evolutionScroll;
    }

    public int getMaxRangeSquared() {
        return maxRangeSquared;
    }

    public void setMaxRangeSquared(int maxRangeSquared) {
        this.maxRangeSquared = maxRangeSquared;
    }

    @Override
    public String toString() {
        return "{" + "Evolution Scroll=" + evolutionScroll + ", maxRangeSquared=" + maxRangeSquared
                + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }

}
