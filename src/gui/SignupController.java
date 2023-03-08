/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entite.Role;
import entite.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import service.ConnectionClass;
import service.UserService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class SignupController implements Initializable {

    @FXML
    private TextField lastname;
    @FXML
    private TextField firstname;
    @FXML
    private TextField email;
   
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private DatePicker date;
    
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpass;
    @FXML
    private Button signup;
    @FXML
    private Button backup;
    @FXML
    private ImageView image1;
    @FXML
    private Button addphoto;
    
    
//private Connection conn;
private Statement ste;                          
private PreparedStatement pst;
private  ResultSet rs;



    @FXML
    private Text txt1;
    @FXML
    private ComboBox<String> role;
    @FXML
    private AnchorPane sexe;
    @FXML
    private ComboBox<String> newsexe;
    @FXML
    private ImageView imviews;
    @FXML
    private ImageView logooo;

  
    @Override
    public void initialize(URL url, ResourceBundle rb){
         role.getItems().addAll("Client","Artiste");
         newsexe.getItems().addAll("homme","femme");
        // TODO
    }    
    
    @FXML
    private void signup (ActionEvent event) throws SQLException {
        UserService udao = new UserService();
       LocalDate ld =date.getValue();
        ConnectionClass connectionClass=new ConnectionClass();
         Connection conn=connectionClass.getConnection();
//        conn = DataSource.getInstance().getConnection();
        String req="SELECT * FROM `users` WHERE email= ?";
        
        PreparedStatement pst1=conn.prepareStatement(req);
        pst1.setString(1, email.getText().toString());
      ResultSet rst=pst1.executeQuery();
        while(
                rst.next())
        {
            if(rst.getObject(10).equals(email.getText().toString()))
            {
                System.out.println("email existe");
            }
           
        }
     
          add()  ;
      
    }
    
   
    
    
    
 @FXML
    private void backup (ActionEvent event) throws IOException {
        Parent page1 =
FXMLLoader.load(getClass().getResource("Login.fxml"
));

Scene scene = new Scene(page1);

Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

stage.setScene(scene);

stage.show();
    }
   

    @FXML
    private void InsertPhoto(ActionEvent event) throws IOException {
  

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Resource File");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            this.addphoto.setText(selectedFile.toURI().toURL().toString());
          imviews.setImage(image);
        }
    }

    public void add() {
        ConnectionClass connectionClass=new ConnectionClass();
         Connection conn=connectionClass.getConnection();
  String requete  = "INSERT INTO `users`(`nom_user`, `prenom_user`, `pwd_user`, `date_naiss`, `tel_user`, `sexe`, `adresse`, `img`, `email`, `id_role`) VALUES (?,?,?,?,?,?,?,?,?,?)";      
       try {
       
           
          // System.out.print(res);
         if (firstname.getText().isEmpty()|| lastname.getText().isEmpty() ||email.getText().isEmpty()||password.getText().isEmpty()||newsexe.getValue().isEmpty()||phone.getText().isEmpty()||address.getText().isEmpty()) {
           
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
                     Object selectedItem = role.getSelectionModel().getSelectedItem();
         PreparedStatement pst = conn.prepareStatement(requete);
         
         
            if(selectedItem.equals("Client")){
                 pst.setInt(10,2);
            }else{
                 pst.setInt(10,3);
            }
           
            pst.setString(1, firstname.getText());
            pst.setString(2, lastname.getText());
            pst.setString(4, date.getValue().toString());
            pst.setString(9, email.getText());
            pst.setString(3, password.getText());
            pst.setString(6,newsexe.getValue());
            pst.setString(5,  phone.getText());
            pst.setString(8, addphoto.getText());
            pst.setString(7, address.getText());
                   
            pst.executeUpdate();
            
           
           System.out.print(pst);
            
            System.out.print(selectedItem); 

          String titre=" successfully Signup";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(titre);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
                    System.out.println("email ");

            
            
        
        }
        catch(Exception ex){
           
             String titre="  Signup Failed ";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(titre);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
            
            
                    System.out.println("email error");

          
        }
   
            }

 
    }



    


 
    
   

