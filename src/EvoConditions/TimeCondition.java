package EvoConditions;

import java.util.ArrayList;

public class TimeCondition {
    private String time;
    public final String evoConditionType = "time";

    public TimeCondition(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "time='" + time + '\'' +
                ", evoConditionType='" + evoConditionType + '\'' +
                '}';
    }
}
