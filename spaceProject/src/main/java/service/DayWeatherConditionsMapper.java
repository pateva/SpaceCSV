package service;

import classes.DayWeatherConditions;
import exceptions.InvalidFileException;

import java.util.ArrayList;

/**
 * Service class used to convert an ArrayList of String arrays to an ArrayList of DayWeatherConditions objects
 */
public class DayWeatherConditionsMapper {

    /**
     * @param list    ArrayList of String arrays to be converted
     * @param cntDays Count of provided days in thr ArrayList of String arrays
     * @return ArrayList of DayWeatherConditions objects
     * @throws InvalidFileException if data in the file is invalid and has surpassed the original file validation
     */
    public static ArrayList<DayWeatherConditions> mapper(ArrayList<String[]> list, int cntDays) throws InvalidFileException {
        if (!isValidList(list)) {
            throw new InvalidFileException("Invalid file");
        } else {
            ArrayList<DayWeatherConditions> condList = new ArrayList<>();

            for (int index = 1; index <= cntDays; index++) {
                DayWeatherConditions day = new DayWeatherConditions();

                for (String[] condition : list) {

                    switch (condition[0]) {
                        case "Day/Parameter":
                            day.setDayIndex(Integer.parseInt(condition[index]));
                            break;
                        case "Temperature (C)":
                            day.setTemperature(Integer.parseInt(condition[index]));
                            break;
                        case "Wind (m/s)":
                            day.setWind(Integer.parseInt(condition[index]));
                            break;
                        case "Humidity (%)":
                            day.setHumidity(Integer.parseInt(condition[index]));
                            break;
                        case "Precipitation (%)":
                            day.setPrecipitation(Integer.parseInt(condition[index]));
                            break;
                        case "Lightning":
                            day.setLightning(condition[index]);
                            break;
                        case "Clouds":
                            day.setClouds(condition[index]);
                            break;
                        default:
                            throw new InvalidFileException("Something is really wrong :')");
                    }
                }
                condList.add(day);
            }

            /*
            for (DayWeatherConditions damn : condList) {
                System.out.println(damn);
            }
            */

            return condList;
        }
    }

    /**
     * this fucntions checks if the data provided in the ArrayList of String arrays is valid
     *
     * @param list ArrayList ofr String Arrays
     * @return true if valid and false if invalid
     */
    public static boolean isValidList(ArrayList<String[]> list) {
        if (list.size() != 7) return false;

        ArrayList<String> cond = new ArrayList<>();
        int i = 0;

        for (String[] str : list) {
            cond.add(str[0]);
        }

        return (cond.contains("Day/Parameter")
                && cond.contains("Temperature (C)")
                && cond.contains("Wind (m/s)")
                && cond.contains("Humidity (%)")
                && cond.contains("Precipitation (%)")
                && cond.contains("Lightning")
                && cond.contains("Clouds"));
    }
}


