package EvoConditions;

public class StatRatioCondition {
    private Double ratio;
    private String stat1;
    private String stat2;
    public final String evoConditionType = "statRatio";

    public StatRatioCondition(Double ratio, String stat1, String stat2) {
        this.ratio = ratio;
        this.stat1 = stat1;
        this.stat2 = stat2;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public String getStat1() {
        return stat1;
    }

    public void setStat1(String stat1) {
        this.stat1 = stat1;
    }

    public String getStat2() {
        return stat2;
    }

    public void setStat2(String stat2) {
        this.stat2 = stat2;
    }

    @Override
    public String toString() {
        return "{" +
                "ratio=" + ratio +
                ", stat1='" + stat1 + '\'' +
                ", stat2='" + stat2 + '\'' +
                ", evoConditionType='" + evoConditionType + '\'' +
                '}';
    }
}
