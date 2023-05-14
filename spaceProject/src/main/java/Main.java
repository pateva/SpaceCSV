import classes.CsvReader;
import classes.CsvWriter;
import classes.DayWeatherConditions;
import exceptions.InvalidFileException;
import service.DayWeatherConditionsMapper;
import service.SendEmailAsAttachment;
import service.WeatherReport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {


//        ArrayList<String[]> listOne = CsvReader.ReadCSV("../spaceFile.csv");
//        try {
//            ArrayList<DayWeatherConditions> mapper = DayWeatherConditionsMapper.mapper(listOne, 15);
//            //System.out.println(WeatherReport.findBestDay(mapper));
//            WeatherReport report = new WeatherReport(listOne);
//
//            ArrayList<String[]> toFile = report.calculateReport();
//            CsvWriter.write(toFile, "report");
//
//        } catch (InvalidFileException e) {
//            e.printStackTrace();
//        }


        SendEmailAsAttachment.sendMail("ateva.petya@gmail.com");
    }

}

