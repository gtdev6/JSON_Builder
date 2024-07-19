package EvoConditions;

public class HighAltitudeCondition {
    private double minAltitude;
    public final String evoConditionType = "highAltitude";

    public HighAltitudeCondition(double minAltitude) {
        this.minAltitude = minAltitude;
    }

    public double getMinAltitude() {
        return minAltitude;
    }

    public void setMinAltitude(double minAltitude) {
        this.minAltitude = minAltitude;
    }

    @Override
    public String toString() {
        return "{" + "minAltitude=" + minAltitude + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
