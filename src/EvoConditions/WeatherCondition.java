package EvoConditions;

public class WeatherCondition {
    private String weather;
    public final String evoConditionType = "weather";

    public WeatherCondition(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "{" +
                "weather='" + weather + '\'' +
                ", evoConditionType='" + evoConditionType + '\'' +
                '}';
    }
}
