package service;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class WeatherReportTest {

    @org.junit.jupiter.api.Test
    void getAvrgValue() {
        ArrayList<String[] > list = new ArrayList<>();
        String[] param = {"Average", "10", "20", "30"};
        list.add(param);
        WeatherReport report = new WeatherReport(list);
        String result = report.getAvrgValue(param);

        assertEquals("20.00", result);
    }

    @org.junit.jupiter.api.Test
    void getMaxValue() {

        ArrayList<String[] > list = new ArrayList<>();
        String[] param = {"Average", "10", "40", "30"};
        list.add(param);
        WeatherReport report = new WeatherReport(list);
        String result = report.getMaxValue(param);

        assertEquals("40", result);
    }

    @org.junit.jupiter.api.Test
    void getMinValue() {
        ArrayList<String[] > list = new ArrayList<>();
        String[] param = {"Average", "10", "40", "30"};
        list.add(param);
        WeatherReport report = new WeatherReport(list);
        String result = report.getMinValue(param);

        assertEquals("10", result);
    }

    @org.junit.jupiter.api.Test
    void getMedValue() {
        ArrayList<String[] > list = new ArrayList<>();
        String[] param = {"Average", "10", "40", "30", "5"};
        list.add(param);
        WeatherReport report = new WeatherReport(list);
        String result = report.getMedValue(param);

        assertEquals("20", result);
    }
}
