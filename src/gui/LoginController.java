/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
 
    


//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
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
    Mailling m=new Mailling();

    @FXML
    void ControlEmail(KeyEvent event) {

    }

   
    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
                conn = DataSource.getInstance().getConnection();
             String   query="select id_role, email, pwd_user , block from users where email=? and pwd_user=? ";
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
           
          
           while(rs.next()){
                  String titre=" successfuly login";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(titre);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
               
           
           
               for (int i=0 ;i< rs.getString(1).length();i++){
                   
                   
                   if(rs.getInt(1)==1){
                       // Admin scene
                        
                User u = new User(email.getText());
                Parent page = FXMLLoader.load(getClass().getResource("Crud.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(u);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
  
                           }
                  
                   
                   
                    if(rs.getInt(1)==3){
                           // Client
                           User u = new User(email.getText());
                       Parent page = FXMLLoader.load(getClass().getResource("profil.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(u);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                   }
                   
                   
                       if(rs.getInt(1)==2 && rs.getString(4).equals("unBlock")){
                           // Client
                           User u = new User(email.getText());
                       Parent page = FXMLLoader.load(getClass().getResource("MarketG.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(u);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                   }else {
                       Parent page = FXMLLoader.load(getClass().getResource("blocked.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                   }
                     
                       
                       
                       
                       
                  
                   
            
             
                   
                }
            }
            String titre=" ERROR";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(3000));
            
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
             String titre=" ERROR";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(3000));
             
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
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    private void cancel_login(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

 


        }

    
  
