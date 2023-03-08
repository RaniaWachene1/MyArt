/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
    private Button cancel;
    @FXML
    private Button addphoto;
    
    
private Connection cnx;
private Statement ste;                          
private PreparedStatement pst;



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

  
    @Override
    public void initialize(URL url, ResourceBundle rb){
         role.getItems().addAll("Admin","Client","Artiste");
         newsexe.getItems().addAll("homme","femme");
        // TODO
    }    
    
    @FXML
    private void signup (ActionEvent event) {
     
       LocalDate ld =date.getValue();
       
        //cnx = ConnexionSource.getInstance().getConnection();
       String requete  = "insert into users (nom_user,prenom_user,date_naiss,email,pwd_user,sexe,tel_user,adresse)values (?,?,?, ?,? ,?, ?, ? )";
        try {
         if (firstname.getText().isEmpty()|| lastname.getText().isEmpty() ||email.getText().isEmpty()||password.getText().isEmpty()||newsexe.getValue().isEmpty()||phone.getText().isEmpty()||address.getText().isEmpty()) {
           
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
        }
         PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, firstname.getText());
            pst.setString(2, lastname.getText());
            pst.setString(3, date.getValue().toString());
            pst.setString(4, email.getText());
            pst.setString(5, password.getText());
            pst.setString(6,newsexe.getValue().toString());
            pst.setString(7, phone.getText());
            pst.setString(10, address.getText());

           
            pst.execute();
             Alert a3 = new Alert(Alert.AlertType.INFORMATION);
            a3.setHeaderText(null);
            a3.setContentText("Successfully added ! ");
            a3.showAndWait();
           
        }catch(Exception ex){
          
        }
       
    }

    @FXML
    private void backup(ActionEvent event) {
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
    }

    

////    private void cancel(ActionEvent event) {
////        Stage stage = (Stage) cancel.getScene().getWindow(); 
////        stage.close();
////        Platform.exit();  
////    }
////
////   
////    private void backup(ActionEvent event) throws IOException {
////        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
////        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
////        Scene scene = new Scene(root);
////        stage.setScene(scene);
////        stage.show();
////        
        
//    }
    


 
    
   

