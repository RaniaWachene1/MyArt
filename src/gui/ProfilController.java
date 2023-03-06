/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.mysql.cj.protocol.Resultset;
import com.sun.javafx.fxml.LoadListener;
import entite.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import service.ConnectionClass;
import service.UserService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import gui.LoginController.*;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ProfilController extends LoginController {

    @FXML
    private ImageView idimage;
    @FXML
    private ImageView idlogo;
    @FXML
    private MenuBar idmenu;
    @FXML
    private Button idaddpho;
    @FXML
    private ImageView imgdeg;
    @FXML
    private ImageView iduserimg;
    @FXML
    private TextField newfirstname1;
    @FXML
    private TextField newlastname1;
    @FXML
    private TextField newemail1;
    @FXML
    private TextField newaddress1;
    @FXML
    private TextField newphone1;
    @FXML
    private ComboBox<String> newsexe1;
    @FXML
    private DatePicker newdatenais1;
    @FXML
    private PasswordField newpassc1;
    @FXML
    private PasswordField newpass1;
    @FXML
    private ComboBox<String> newrole1;
    @FXML
    private Button newupdate;
    @FXML
    private Button logout1;
    @FXML
    private Button info;
    /**
     * Initializes the controller class.
     */
  public void init(ActionEvent event){
      
      Node node = (Node) event.getSource();
  Stage stage = (Stage) node.getScene().getWindow();
        LoginController l = new LoginController();
        
        
          newrole1.getItems().addAll("Client","Artiste");
         newsexe1.getItems().addAll("homme","femme");
        
        /*******************************************************************************************/


        
        List<String> listgendre=new ArrayList<>();
     listgendre.add("Homme");
           listgendre.add("Femme");
        
           
           /**********************************************/
           
           List<String> listrole=new ArrayList<>();
     listrole.add("Artiste");
           listrole.add("client");
      
      
  }
            

    @FXML
    public void update(ActionEvent event) {
//         UserService us=new UserService();
//       User u=new User(
//                
//             
//               newfirstname1.getText(),
//                 newlastname1.getText(),
//                
//                newemail1.getText(),
//                 newpass1.getText(),
//                 newsexe1.getValue(),
//               Integer.parseInt(newphone1.getText()),
//                 idaddpho.getText(),
//                  newaddress1.getText()
//                  );
//     String titre=" successfly update";
//            String message = newemail1.getText();
//            TrayNotification tray = new TrayNotification();
//AnimationType type = AnimationType.POPUP;
//tray.setAnimationType(type);
//tray.setTitle(titre);
//tray.setMessage(message);
//tray.setNotificationType(NotificationType.SUCCESS);
//tray.showAndDismiss(Duration.millis(3000));
//       
   
       
    }
 /*************************************************************************/   
    @FXML
    private void logout (ActionEvent event) throws IOException {
        Parent page1 =
FXMLLoader.load(getClass().getResource("Login.fxml"
));

Scene scene = new Scene(page1);

Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

stage.setScene(scene);

stage.show();
    }
/***********************************************************************/
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
            this.idaddpho.setText(selectedFile.toURI().toURL().toString());
          iduserimg.setImage(image);
        }
    }

    @FXML
    private void information(ActionEvent event) {
          
      Node node = (Node) event.getSource();
  Stage stage = (Stage) node.getScene().getWindow();
             User u = (User) stage.getUserData();

        LoginController l = new LoginController();
                
       ConnectionClass connectionClass=new ConnectionClass();
         Connection conn=connectionClass.getConnection();
//        conn = DataSource.getInstance().getConnection();
        
        try {
          //  String ema = em;
                  String req="SELECT * FROM `users` WHERE email= ?";


           PreparedStatement pst1 = conn.prepareStatement(req);
             pst1.setString(1,u.getEmail());
             
             ResultSet rst=pst1.executeQuery();
             System.out.print(pst1);
      
        while(rst.next()){
           newphone1.setText(rst.getInt(6)+"");
           newfirstname1.setText(rst.getString(3));
          newlastname1.setText(rst.getString(2));
           newemail1.setText(rst.getString(10));
           newaddress1.setText(rst.getString(8));
           //Image imgdegs = new Image(getClass().getResourceAsStream(rst.getString(9)+""));
          // imgdeg = new ImageView(imgdegs);
            newpass1.setText(rst.getString(4));
           newsexe1.getItems().addAll(rst.getString(7));
         newdatenais1.setValue(rst.getDate(5).toLocalDate());//tValue(rst.getString(5));
           newrole1.getItems().add(rst.getString(11));
        }
        } catch (SQLException ex) {
            Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }






}
