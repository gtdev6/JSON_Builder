package EvoConditions;

public class ShinyCondition {
    private boolean shiny;
    public final String evoConditionType = "shiny";

    public ShinyCondition(boolean shiny) {
        this.shiny = shiny;
    }

    public boolean isShiny() {
        return shiny;
    }

    public void setShiny(boolean shiny) {
        this.shiny = shiny;
    }

    @Override
    public String toString() {
        return "{" + "shiny=" + shiny + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }

}
