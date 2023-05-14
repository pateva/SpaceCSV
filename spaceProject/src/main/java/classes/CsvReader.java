package classes;

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
     * catches FileNotFoundException if no file is found on the specified path and terminates the program
     * catches IOException if an error occurs while reading the file and terminates the program
     */
    public static ArrayList<String[]> ReadCSV(String path) {
        ArrayList<String[]> conditions = new ArrayList<>();
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                String[] condition = line.split(splitBy);
                conditions.add(condition);
            }

            return conditions;
        } catch (FileNotFoundException e) {
            System.err.println("No file was found on the specified path");
            System.exit(1);

        } catch (IOException e) {
            System.err.println("Something went wrong while reading the file");
            System.exit(1);
        }

        return null;
    }

    /**
     * method to print an arrayList of String arrays
     *
     * @param list ArrayList of String arrays
     *             used for testing purposes
     */
    public static void printList(ArrayList<String[]> list) {
        for (String[] str : list) {
            for (String ag : str) {
                System.out.print(ag + " ");
            }

            System.out.println();
        }
    }

}
