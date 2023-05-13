package classes;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import service.DayWeatherConditionsMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {
    public static ArrayList<String[]> ReadCSV(String path) {
        String line = "";
        ArrayList<String[]> conditions = new ArrayList<>();
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../spaceFile.csv"));

            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] condition = line.split(splitBy);
                conditions.add(condition);
            }

            System.out.println(DayWeatherConditionsMapper.isValidList(conditions));

            return conditions;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void printList(ArrayList<String[]> test) {
        for(String[] empl: test) {
            for(String ag : empl) {
                System.out.print(ag + " ");
            }
            System.out.println();

        }
    }

}
