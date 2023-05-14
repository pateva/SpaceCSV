package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CsvWriter {

    public static void write(ArrayList<String[]> data, String fileName) {
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            for (String[] line : data) {
                String csvLine = String.join(",", line);
                pw.println(csvLine);
            }

            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("There was an issue saving the file!");
        }
    }
}
