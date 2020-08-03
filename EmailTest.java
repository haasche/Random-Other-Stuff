package test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailTest {
    public static void main(String[] args){
        final String user = "xxx@yyy.com";
        final String pass = "";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "xxx.com"); //office365.com ?
        props.put("mail.smtp.port", "25"); //587 is default

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        session.setDebug(true);

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("xxx@zzz.com")); //recipient
            message.setSubject("Testing");
            message.setText("Is this thing on?"); //html tags work here

            Transport.send(message);
            System.out.println("Done");

        }catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }

}
