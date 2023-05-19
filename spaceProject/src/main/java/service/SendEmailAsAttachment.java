package service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class SendEmailAsAttachment {
//    static String senderMail = System.getenv("SENDER_MAIL");
//    static String senderPassword = System.getenv("SENDER_PASSWORD");
    static String smtpServer = "smtp.abv.bg";
    static int port = 465;

    public static void sendMail(String senderMail, String senderPassword, String recipientMail) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); //enable SMTP auth
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.host", smtpServer); //SMTP host
        props.put("mail.smtp.port", port); //SSL port

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, senderPassword);
            }
        };

        String subject = "Why do meteorologists hate the wind?";
        String body = """
                Because it takes them forever to get their forecasts off the ground!

                Attached you can find the weather report with the most appropriate launch date""".indent(1);

        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(true);
        System.out.println("Session created");

        generateAndSendEmail(session, senderMail, recipientMail, subject, body);

    }

    public static void generateAndSendEmail(Session session, String senderMail, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(senderMail, "NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse(senderMail, false));
            msg.setSubject(subject, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            //message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            //attachment part
            messageBodyPart = new MimeBodyPart();
            String fileName = "report.csv";
            FileDataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);

            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("Mail Sent Successfully!!");
        } catch (Exception e) {
            System.err.println("There was an issue with sending the mail!");
            //e.printStackTrace();
        }
    }
}

