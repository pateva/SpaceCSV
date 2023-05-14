package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmailAsAttachment {
    static String senderMail = System.getenv("SENDER_MAIL");
    static String senderPassword = System.getenv("SENDER_PASSWORD");
    static String smtpServer = "smtp.abv.bg";
    static int port = 465;

    public static void sendMail(String recipientMail) {

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

        String subject = "Why do meteorologists hate the wind? Because it takes them forever to get their forecasts off the ground!";
        String body = "Attached you can find the weather report with the most appropriate launch date";

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");

        sendEmail(session, recipientMail, subject, body);

    }

    public static void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("test_space@abv.bg", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@abv.bg", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

