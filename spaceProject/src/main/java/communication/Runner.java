package communication;

import classes.CsvReader;
import classes.CsvWriter;
import service.SendEmailAsAttachment;
import service.WeatherReport;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Runner {
    public void startApp() {
        String filePath, emailSender, passwordSender, emailReceiver;
        Scanner scanner = new Scanner(System.in);
        Locale locale = setLocale();
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

        //communication start
        System.out.println(messages.getString("welcome_message"));
        System.out.println(messages.getString("enter_name"));
        filePath = scanner.nextLine();
        System.out.println(messages.getString("enter_sender_email_address"));
        emailSender = scanner.nextLine();
        System.out.println(messages.getString("enter_sender_password"));
        passwordSender = scanner.nextLine();
        System.out.println(messages.getString("enter_receiver_email_address"));
        emailReceiver = scanner.nextLine();

        //send report
        sendReport(filePath, emailSender, passwordSender, emailReceiver);

    }

    private Locale setLocale() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose your preferred language (en/de): ");
        String language = scanner.nextLine();

        Locale locale;
        switch (language.toLowerCase()) {
            case "en":
                locale = new Locale("en", "US");
                break;
            case "de":
                locale = new Locale("de", "DE");
                break;
            default:
                System.out.println("Invalid language selection. Defaulting to English.");
                locale = new Locale("en", "US");
        }

        return locale;
    }

    private void sendReport(String path, String senderMail, String senderPassword, String receiverMail) {
        WeatherReport report = new WeatherReport(CsvReader.ReadCSV(path));
        CsvWriter.write(report.calculateReport(), "report.csv");
        SendEmailAsAttachment.sendMail(senderMail, senderPassword, receiverMail);
    }
}
