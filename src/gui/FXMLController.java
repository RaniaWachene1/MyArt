package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import utils.DataSource;

public class FXMLController {

    @FXML
    private TextField idmail;

    @FXML
    private Button idsave;
 String reciever;
    String subj;
    String con;
     String username;
     String password;
    String from;
    String host;
    String put_auth;
    String put_ttls;
    String put_host;
    String put_port;
     private Connection conn;
    private ResultSet rs;
private PreparedStatement pst;
  
    @FXML
    void save(ActionEvent event){
        
     
                
        send();
    }
    
     public void send()
    {
         int t = idmail.getText().toString().indexOf('@');
    String res = idmail.getText().toString().substring(0,t )+1;
        
    String  us = idmail.getText().toString().substring(0,t );
        
        
        
           username="meriam.wachene@esprit.tn";
        password="223JFT1101";
        from="example";
        host="smtp.gmail.com";
        reciever=idmail.getText();
        subj="Password recover";
        con="Dear "+us+"Your  new password is "+" "+res+"If you have any problem or this is not your account please contact the admin ";
        put_auth="mail.smtp.auth";
        put_ttls="mail.smtp.starttls.enable";
        put_host="mail.smtp.host";
        put_port="mail.smtp.port";

        Properties props=new Properties();
        props.put(put_auth, "true");
        props.put(put_ttls, "true");
        props.put(put_host, host);
        props.put(put_port, "587");

        Session session=Session.getInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication () {
                return new PasswordAuthentication(username,password);
            }
        });
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever));
            message.setSubject(subj);
            message.setText(con);
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Done");
        }catch (MessagingException e) {
            
            System.out.print("email ??????????????????");

            
            
            throw new RuntimeException(e);
        }
        
           conn = DataSource.getInstance().getConnection();
         try {           
    PreparedStatement st = conn.prepareStatement("UPDATE users SET pwd_user = ? WHERE email = ?");
    st.setString(1, res);
    st.setString(2, idmail.getText().toString());
    
    st.executeUpdate();

System.out.print("successfully");
  
} catch (SQLException e ) {
System.out.print("UNsuccessfully");
}
     
        
        
    }
    
    
    

}
