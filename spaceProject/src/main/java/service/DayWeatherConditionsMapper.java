package service;

import classes.DayWeatherConditions;
import exceptions.InvalidFileException;

import java.util.ArrayList;

public class DayWeatherConditionsMapper {

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
            for (DayWeatherConditions damn : condList) {
                System.out.println(damn);
            }


            return condList;
        }
    }

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


