/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author Acer
 */
public class Mailling {
    
    public Mailling(){}

public void sendemail(String email,int code)
{
Properties prop = new Properties();

prop.put ("mail.smtp.auth", "true");
prop.setProperty("mail.smtp.starttls.enable", "true");
prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
prop.put ("mail.smtp.host", "smtp.gmail.com");
prop.put ("mail.smtp.port", "587");
Session s;
        s = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("meriamwachene@gmail.com","meriamwachene@");
            }
        });
try {
Message message = new MimeMessage(s);
message.setFrom(new InternetAddress("meriamwachene@gmail.com"));
message.setRecipients(
  Message.RecipientType.TO, InternetAddress.parse(email));
message.setSubject("verification code");

String msg ="votre code est : "+code;

MimeBodyPart mimeBodyPart = new MimeBodyPart();
mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

Multipart multipart = new MimeMultipart();
multipart.addBodyPart(mimeBodyPart);

message.setContent(multipart);

Transport.send(message);
}catch (MessagingException ex) {
 System.err.println(ex.getMessage());
}
}


    
    
}
