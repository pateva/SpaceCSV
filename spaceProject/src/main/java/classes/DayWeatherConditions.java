package classes;

/**
 * Model to save the weather conditions for a given day
 * Could be easily integrated with a DB
 */

public class DayWeatherConditions {
    private int dayIndex;
    private int temperature;
    private int wind;
    private int humidity;
    private int precipitation;
    private String lightning;
    private String clouds;
    private int checksum;

    public DayWeatherConditions() {
    }

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

    /**
     * calculates the Checksum of the weather conditions
     * used to find the most appropriate day for a rocket launch
     * the day is first validated whether a rocket can launch at all
     * if true the checksum is calculated based on wind and humidity
     * the lower checksum the better
     * returns -1 if day is not valid for launching
     */
    public int calculateChecksum() {
        if (this.isValidLaunchDay()) {
            this.checksum = this.wind + this.humidity;
        } else {
            this.checksum = -1;
        }

        return checksum;
    }

    public boolean isValidLaunchDay() {
        if (temperature < 2 || temperature > 31) return false;

        if (wind > 10 || wind < 0) return false;

        if (humidity > 60 || humidity < 0) return false;

        if (precipitation != 0) return false;

        if (!lightning.equalsIgnoreCase("no")) return false;

        return (!clouds.equalsIgnoreCase("cumulus") && !clouds.equalsIgnoreCase("nimbus"));
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
