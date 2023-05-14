package classes;

import service.DayWeatherConditionsMapper;
import service.WeatherReport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    /**
     * method to read a CSV file
     *
     * @param path to the CSV file
     * @return value is an arrayList of String arrays containing the different data on every line
     * @throws FileNotFoundException if no file is found on the specified path
     * @throws IOException if an error occurs while reading the file
     */
    public static ArrayList<String[]> ReadCSV(String path) {
        ArrayList<String[]> conditions = new ArrayList<>();
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../spaceFile.csv"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] condition = line.split(splitBy);
                conditions.add(condition);
            }

            return conditions;
        } catch (FileNotFoundException e) {
            System.err.println("No file was found on the specified path");

        } catch (IOException e) {
            System.err.println("Check logs to debug");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * method to print an arrayList of String arrays
     *
     * @param list ArryList of String arrays
     *             used for testing purposes
     */
    public static void printList(ArrayList<String[]> list) {
        for (String[] empl : list) {
            for (String ag : empl) {
                System.out.print(ag + " ");
            }

            System.out.println();
        }
    }

}
