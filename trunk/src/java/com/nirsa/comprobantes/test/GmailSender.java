/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.test;

/**
 *
 * @author Rolando
 */
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSender {

    private static String HOST = "smtp.gmail.com";
    private static String USER = "rolando.roc@gmail.com";
    private static String PASSWORD = "XXXXX";
    private static String PORT = "587";
    private static String FROM = "rolando.roc@gmail.com";
    private static String TO = "rolando.roc@gmail.com";
    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SUBJECT = "Testing mail through gmail";
    private static String TEXT = "Mail body";

    public static synchronized void send() {
        //Use Properties object to set environment properties
        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.user", USER);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.debug", DEBUG);
        props.put("mail.smtp.ssl.trust", HOST);

        try {
            Authenticator auth = new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER, PASSWORD);
                }
            };

            Session session = Session.getDefaultInstance(props, auth);

            MimeMessage message = new MimeMessage(session);
            message.setText(TEXT);
            message.setSubject(SUBJECT);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));

            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GmailSender.send();
        System.out.println("Mail sent successfully!");
    }
}
