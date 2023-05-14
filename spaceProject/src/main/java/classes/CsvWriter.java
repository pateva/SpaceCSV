package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A class to act as Writer of CSV files
 */
public class CsvWriter {

    /**
     *
     * @param data ArrayList of String arrays to be saved in the CSV file
     * @param fileName name of the newly created file
     */
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
            System.exit(2);
        }
    }
}
