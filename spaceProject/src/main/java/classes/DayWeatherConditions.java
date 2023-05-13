package classes;

public class DayWeatherConditions {
    private int dayIndex;
    private int temperature;
    private int wind;
    private int humidity;
    private int precipitation;
    private String lightning;
    private String clouds;
    private int checksum;

    public DayWeatherConditions() {}

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public String getLightning() {
        return lightning;
    }

    public void setLightning(String lightning) {
        this.lightning = lightning;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public int getChecksum() {
        return checksum;
    }

    public void calculateChecksum() {
        //todo
    }

    @Override
    public String toString() {
        return "WeatherConditions{" +
                "dayIndex=" + dayIndex +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", precipitation=" + precipitation +
                ", lightning='" + lightning + '\'' +
                ", clouds='" + clouds + '\'' +
                '}';
    }
}
