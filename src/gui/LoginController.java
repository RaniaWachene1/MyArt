/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
 
    


import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import entite.Role;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;
import service.RoleService;
import service.UserService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.DataSource;
import javafx.util.Duration;
import jdk.nashorn.api.scripting.JSObject;
import service.Mailling;



public class LoginController implements Initializable {

    
    @FXML
    private AnchorPane LoginPane;

    @FXML
    private Button cancel;

    @FXML
    public TextField email;

    @FXML
    private Label idk;

    @FXML
    private ImageView img;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Button passwordfailed;

    @FXML
    private Button signup;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private Text txt1;
    private Connection conn;
    private ResultSet rs;
private PreparedStatement pst;
    @FXML
    private Button lgmail;
    Mailling m=new Mailling();

    @FXML
    void ControlEmail(KeyEvent event) {

    }

   
    @FXML
   public void login(ActionEvent event) {
      // if(bolcktrue)
                conn = DataSource.getInstance().getConnection();
             String   query="select id_role, email, pwd_user from users where email=? and pwd_user=? and block= false";
        try {
                     if (email.getText().isEmpty()|| password.getText().isEmpty()) {
                         String titre=" Required fields are empty !";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(titre);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
            
                     }
                     
                   
            pst= conn.prepareStatement(query);
            pst.setString(1,email.getText());
            pst.setString(2, password.getText());
            
           rs = pst.executeQuery();
           //getEmail();
           
           while(rs.next()){
               for (int i=0 ;i< rs.getString(1).length();i++){
                   if(rs.getString(1).equals("1")){
                       // Admin scene
                           try {
                Parent page = FXMLLoader.load(getClass().getResource("Crud.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                
                        
//                String titre=" successfully login";
//            String message = email.getText();
//            TrayNotification tray = new TrayNotification();
//            AnimationType type = AnimationType.POPUP;
//            tray.setAnimationType(type);
//            tray.setTitle(titre);
//            tray.setMessage(message);
//            tray.setNotificationType(NotificationType.SUCCESS);
//            tray.showAndDismiss(Duration.millis(3000));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
                   }else if(rs.getString(1).equals("2")){
                       //Article a = new Article(email.getText())
                       // rania this 2 
                       
                       User u = new User(email.getText());
                Parent page = FXMLLoader.load(getClass().getResource("profil.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                //rania u need it 
                stage.setUserData(u);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                   }else {
                       Parent page = FXMLLoader.load(getClass().getResource("profil.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                   }
                    
               }
                   
               
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                   String titre=" ERROR";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(3000));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   public String em;
public void getEmail(){
    login.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        em = email.getText().toString();
    }
});
   

}   
    
   
    @FXML
    void signup(ActionEvent event) throws IOException {
         Parent page = FXMLLoader.load(getClass().getResource("signup.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                

    }

    @FXML
    void save(ActionEvent event) throws IOException {
         Parent page = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
             }
    
   


//          Notifications notification = pushNotify(email +" was not found in our database", "try again");
//          notification.showError();
//     }
// }
//}
//    
//
//@FXML
//    public void submit(ActionEvent event) {
        
//     
//        String email = email.getText().trim();
//        String text = txt_verifcode.getText().trim();
//        String password = txt_password.getText();
//        String password2 = txt_password2.getText();
//         Pattern pattern = Pattern.compile("([a-z0-9_\\-\\.])+\\@([a-z0-9_\\-\\.])+\\.([a-z]{2,4})$");
//                 if (email.isEmpty()) {
//            Notifications notification = pushNotify("Empty Field", "Please fill in the field");
//            notification.showError();
//           txt_email.requestFocus();
//        } else  if (text.isEmpty() && password.isEmpty()&& password2.isEmpty()) {
//            Notifications notification = pushNotify("Empty Fields", "Please fill in the fields");
//            notification.showError();
//           txt_verifcode.requestFocus();
////            txt_password.setStyle("-fx-border-color: red;");
////            txt_username.setStyle("-fx-border-color: red;");
//        } else
//            {
//    if (getCode() == Integer.parseInt(text))
//  {
//      if (password.equals(password2))
//     {
//        if(!sp.Updatepassword(password,email))
//     {
//     System.out.println("passwoed updated");
//     Image img = new Image(getClass().getResourceAsStream("images/ok.png"));
//     Notifications notification = pushNotify("passwoed updated", "back to sign in");
//     notification.graphic(new ImageView(img));
//     notification.show();
//     clear();
//     setCode();
// pane1.setVisible(true);
// pane2.setVisible(false);
//     }
//     else
//     {
//         System.out.println("passwoed wasn't updated");
//         Notifications notification = pushNotify("passwoed wasn't updated", "try again");
//          notification.showError();
//     }
//      }else
//      {
//         Notifications notification = pushNotify("passwoeds don't match", "try again");
//         notification.showError();
//      }
//
//      
//  }
//  else
//  {
//        System.out.println("Rong code");
//        Notifications notification = pushNotify("verifcode don't match", "try again");
//        notification.showError();
//  }
//
//}

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

 


        }
    
  
