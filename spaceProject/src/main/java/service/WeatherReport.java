package service;

import classes.CsvReader;
import classes.DayWeatherConditions;
import exceptions.InvalidFileException;

import java.util.ArrayList;
import java.util.Arrays;

public class WeatherReport {

    private ArrayList<String[]> listDays;
    private int days;

    public WeatherReport(ArrayList<String[]> listDays) {
        this.listDays = listDays;
        this.days = listDays.get(0).length - 1;
    }

    public ArrayList<String[]> calculateReport() {
        ArrayList<String[]> report = new ArrayList<>();

        try {
            report.add(findBestDay());
        } catch (InvalidFileException e) {
            e.printStackTrace();
        }

        report.add(new String[]{"Calculations/Parameter", "Average value", "Max value", "Min Value", "Median Value"});

        for (String[] str : listDays) {
            if (str[0].equals("Day/Parameter")) continue;
            else if (!str[0].equals("Lightning") && !str[0].equals("Clouds")) {
                report.add(aggrNumParam(str));
            } else {
                report.add(aggrText(str));
            }
        }

        CsvReader.printList(report);

        return report;
    }

    public String[] findBestDay() throws InvalidFileException {
        int lowestChecksum = Integer.MAX_VALUE;
        int bestDay = -1;
        ArrayList<DayWeatherConditions> daysAsObjectsList = DayWeatherConditionsMapper.mapper(listDays, days);

        for (DayWeatherConditions day : daysAsObjectsList) {
            int currentChecksum = day.calculateChecksum();

            if (currentChecksum != -1 && currentChecksum < lowestChecksum) {
                bestDay = day.getDayIndex();
            }
        }

        String[] result = new String[2];
        result[0] = "Most appropriate Launch Date";

        if (bestDay == -1) {
            result[1] = "There is no appropriate date";
        } else {
            result[1] = Integer.toString(bestDay);
        }

        return result;
    }

    public String[] aggrNumParam(String[] str) {
        String[] temp = new String[5];
        temp[0] = str[0];
        temp[1] = getAvrgValue(str);
        temp[2] = getMaxValue(str);
        temp[3] = getMinValue(str);
        temp[4] = getMedValue(str);

        return temp;
    }

    public String[] aggrText(String[] str) {
        String[] temp = new String[5];
        temp[0] = str[0];
        for (int i = 1; i < 5; i++) {
            temp[i] = " ";
        }

        return temp;
    }


    public String getAvrgValue(String[] param) {
        int cntValues = param.length - 1;
        int sum = 0;

        for (int i = 1; i < param.length; i++) {
            sum += Integer.parseInt(param[i]);
        }

        return String.format("%.2f", ((double) sum / cntValues));
    }

    public String getMaxValue(String[] param) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < param.length; i++) {
            int n = Integer.parseInt(param[i]);
            if (n > max) max = n;
        }

        return Integer.toString(max);

    }

    public String getMinValue(String[] param) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < param.length; i++) {
            int n = Integer.parseInt(param[i]);
            if (n < min) min = n;
        }

        return Integer.toString(min);
    }

    public String getMedValue(String[] param) {
        int[] array = new int[days];
        for (int i = 1; i < param.length; i++) {
            array[i - 1] = Integer.parseInt(param[i]);
        }

        Arrays.sort(array);
        int mid = array.length / 2;
        double res;

        if (array.length % 2 == 0) {
            res = (array[mid - 1] + array[mid]) / 2.0;
        } else {
            res = array[mid];
        }

        return String.format("%.2f", res);
    }


}
