import classes.CsvReader;
import classes.DayWeatherConditions;
import exceptions.InvalidFileException;
import service.DayWeatherConditionsMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        try {
//            List<DayWeatherConditions> list = CsvReader.readCsv("../spaceFile.csv");
//            for(DayWeatherConditions obj : list) {
//                System.out.println(obj);
//            }
//        }catch(Exception e) {
//        }

        ArrayList<String[]> listOne = CsvReader.ReadCSV("../spaceFile.csv");
        try {
            ArrayList<DayWeatherConditions> mapper = DayWeatherConditionsMapper.mapper(listOne, 15);

        } catch (InvalidFileException e) {
            e.printStackTrace();
        }
        for (int index = 1; index < 15; index++) {
            System.out.println(index);
        }


    }
}

