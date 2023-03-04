/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entite.Role;
import entite.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.PropertySheet.Item;
import service.ConnectionClass;
import service.UserService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CrudController implements Initializable {

    @FXML
    private TableColumn<User, Integer> id_user;
    @FXML
    private TableColumn<User, String> nom_user;
    @FXML
    private TableColumn<User, String> prenom_user;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> img;
    @FXML
    private TableColumn<User, Integer> tel_user;
    @FXML
    private TableColumn<User, Date> date_naiss;
    @FXML
    private TableColumn<User, String> sexe;
    @FXML
    private Button delete;
    private TextField lastname;
    private TextField firstname;
    private TextField address;
    private TextField phone;
    private DatePicker date;
    @FXML
    private AnchorPane text;
    private PasswordField pass;
    private PasswordField passc;
    @FXML
    private Button add;
    @FXML
    private Button addpho;
    @FXML
    private TableView<User> tableview;
    @FXML
    private AnchorPane txt4;
    @FXML
    private Button idbuttonc;
    @FXML
    private MenuBar idme;
    @FXML
    private Text txt2;
    @FXML
    private AnchorPane txttt;
    @FXML
    private Text text7;
    @FXML
    private Button readall;
    @FXML
    private TextField newlastname;
    @FXML
    private TextField newfirstname;
    @FXML
    private TextField newemail;
    @FXML
    private TextField newaddress;
    @FXML
    private TextField newphone;
    @FXML
    private PasswordField newpass;
    @FXML
    private PasswordField newpassc;
    @FXML
    private ComboBox<String> newrole;
    @FXML
    private DatePicker newdatenais;
    @FXML
    private ComboBox<String> newsexe;
    @FXML
    private TextField newid;
    @FXML
    private ImageView imageview;
    @FXML
    private Button newupdate;
    @FXML
    private TextField txtsearch;
    @FXML
    private Button btnsearch;
    
    ObservableList<User> UserListSearch;

    /**
     * Initializes the controller class.
     */
    private Statement ste;                          
private PreparedStatement pst;
private ResultSet rs;
    @FXML
    private TableColumn<User, Boolean> block;
    @FXML
    private TableColumn<User, Boolean> unblock;
    @FXML
    private Menu idhome;
    @FXML
    private Menu idgallery;
    @FXML
    private Menu idevent;
    @FXML
    private Menu idauction;
    @FXML
    private Button idblock;
    @FXML
    private Button idun;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     List<String> listgendre=new ArrayList<>();
     listgendre.add("Homme");
           listgendre.add("Femme");
           newsexe.setItems(FXCollections.observableArrayList(listgendre));
           
           /**********************************************/
           
           List<String> listrole=new ArrayList<>();
     listrole.add("Artiste");
           listrole.add("client");
            listrole.add("Admin");
           newrole.setItems(FXCollections.observableArrayList(listrole));
               /* Rating rate = new Rationg();
                // current value
                rate.getRating();
                pst.setDouble(11,rate.getRating());*/
          /************************************************/
           ObservableList<User> Listeu = FXCollections.observableArrayList();
          id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
           nom_user.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
           prenom_user.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
             date_naiss.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
              email.setCellValueFactory(new PropertyValueFactory<>("email"));
//              newpass.setCellValueFactory(new PropertyValueFactory<>("pwd_user"));
               sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
               tel_user.setCellValueFactory(new PropertyValueFactory<>("tel_user"));
                img.setCellValueFactory(new PropertyValueFactory<>("Img"));
          //     newaddress.setCellValueFactory(new PropertyValueFactory<>("adresse"));
           block.setCellValueFactory(new PropertyValueFactory<>("block"));
            unblock.setCellValueFactory(new PropertyValueFactory<>("unblock"));
//    
    }
     @FXML
    void unblocked(ActionEvent event) throws SQLException {
       
        // LAHNE VLOCKED TEKHO FALSE
        ConnectionClass connectionClass=new ConnectionClass();
         Connection conn=connectionClass.getConnection();
        String req = "insert into users (id_user, block) values (?,?) ";
         PreparedStatement pt = conn.prepareStatement(req);
         int a = Integer.parseInt(newid.getText()) ;
         pt.setInt(1,a);
         pt.setBoolean(2, false);
        ResultSet rs = pt.executeQuery();
        
    }
     @FXML
    void block(ActionEvent event) throws SQLException {
        // BLOCKED TEKHO TRUE
        ConnectionClass connectionClass=new ConnectionClass();
         Connection conn=connectionClass.getConnection();
        String req = "insert into users (id_user, unblock) values (?,?) ";
         PreparedStatement pt = conn.prepareStatement(req);
         int a = Integer.parseInt(newid.getText()) ;
         pt.setInt(1,a);
         pt.setBoolean(2, true);
        ResultSet rs =pt.executeQuery();
       

    }
  

@FXML
    private void insert(ActionEvent event) {
        
        
        
        
            if ( newlastname.getText().isEmpty()){
        newlastname.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(newlastname).play();
       
        }
       
        else{newlastname.setStyle(null);}
            /*****************************************************/
            
              if (newfirstname.getText().isEmpty()){
        newfirstname.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(newfirstname).play();
       
        }
       
        else{newfirstname.setStyle(null);}
        
        /***********************************************************/
        
         if ( newemail.getText().isEmpty()){
        newemail.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(newemail).play();
       
        }
       
        else{newemail.setStyle(null);}
         
         /****************************************************/
        
        if (newphone.getText().isEmpty()){
       newphone.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(newphone).play();
       
        }
       
        else{newphone.setStyle(null);}
        /********************************************************/
        if (newaddress.getText().isEmpty()){
       newaddress.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(newaddress).play();
       
        }
       
        else{newphone.setStyle(null);}
        
        /********************************************************/
        
        
        if (img.getText().isEmpty()){
       imageview.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(imageview).play();
       
        }
       
        else{imageview.setStyle(null);}
        
        
        
        /******************************************************************************************************************/
            if (newfirstname.getText().isEmpty() ||newlastname.getText().isEmpty()||newemail.getText().isEmpty() ||
                  newpass.getText().isEmpty()) {
                
                           String titre="Required fields are empty !";
                          String message = "Required fields are empty";
                          TrayNotification tray = new TrayNotification();
                          AnimationType type = AnimationType.POPUP;
                          tray.setAnimationType(type);
                          tray.setTitle(titre);
                          tray.setMessage(message);
                          tray.setNotificationType(NotificationType.ERROR);
                          tray.showAndDismiss(Duration.millis(3000));
                
                
           

        }
         else if ( newfirstname.getText().matches(".*[0-9].*")||newfirstname.getText().matches(".*[%-@-.-/-!-;-,-_].*")||newlastname.getText().matches(".*[0-9].*")||newlastname.getText().matches(".*[%-@-.-/-!-;-,-_].*")) {

                            newfirstname.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
                            new animatefx.animation.Shake(newfirstname).play();
                            String titre=" Product Name must be alphabetic !";
                            String message = "Please enter only letters !";
                             TrayNotification tray = new TrayNotification();
                             AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(4000));


        }
               else  { LocalDate ld =newdatenais.getValue();
               
         UserService us=new UserService();
         User u=new User( newfirstname.getText(),
                 newlastname.getText(),
                ld,
                newemail.getText(),
                 newpass.getText(),
                 newsexe.getValue(),
               Integer.parseInt(newphone.getText()),
                  "a",
                  newaddress.getText(),
                 new Role(1))
                 ;
           us.insert(u);
             String titre=" Successfully added ";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(3000));
     }
   
        
       
    }
    

    /**********************************************************************************************************************/

    @FXML
    private void update(ActionEvent event) {
//          TablePosition tablePosition=tableview.getSelectionModel().getSelectedCells().get(0);
//        int row=tablePosition.getRow();
//        User item=tableview.getItems().get(row);
//        TableColumn tableColumn=tablePosition.getTableColumn();
//        String data= (String) tableColumn.getCellObservableValue(item).getValue();    
//    System.out.println(data);
         UserService us=new UserService();
       User u=new User(
                
               Integer.parseInt(newid.getText()),
               newfirstname.getText(),
                 newlastname.getText(),
                
                newemail.getText(),
                 newpass.getText(),
                 newsexe.getValue(),
               Integer.parseInt(newphone.getText()),
                 addpho.getText(),
                  newaddress.getText()
                  );
     String titre=" successfly update";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(3000));
       
    }
/*********************************************************************************************************************/
    @FXML
    private void delete(ActionEvent event) {
        int n =Integer.parseInt(newid.getText());
    
        UserService us=new UserService();
        User u=new User(Integer.parseInt(newid.getText()));
                
       
        us.delete(u);
         String titre=" successfly Delete";
            String message = email.getText();
            TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(3000));
    }

 /****************************************************************************************************************/

    @FXML
    private void readAll(ActionEvent event) {
    

List<User> Listu =new ArrayList<>();
UserService us=new UserService();
Listu=us.readAll();
           

       
            ObservableList<User> uu=FXCollections.observableArrayList(Listu);
            System.out.println(uu);
               tableview.setItems(uu);
    }
/*******************************************************************************************************************/
    @FXML
    private void insertphoto(ActionEvent event) throws IOException {
        
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Resource File");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            this.addpho.setText(selectedFile.toURI().toURL().toString());
         imageview.setImage(image);
        }
    }
/************************************************************************************************************************/
    @FXML
    private void actionSearch(ActionEvent event) {
        UserService st= new UserService();
        UserListSearch = st.likeByUser(txtsearch.getText());
        tableview.setItems(UserListSearch);
    }
/**************************************************************************************************************************/
    @FXML
    private void handleMouse(MouseEvent event) {
        
        User u = tableview.getSelectionModel().getSelectedItem();
         newid.setText(String.valueOf(u.getId_user()));
         newfirstname.setText(String.valueOf(u.getPrenom_user()));
         newlastname.setText(String.valueOf(u.getNom_user()));

         newemail.setText(String.valueOf(u.getEmail()));
         newpass.setText(String.valueOf(u.getPwd_user()));
  //      newsexe.setText(String.valueOf(u.getSexe()));
        newphone.setText(String.valueOf(u.getTel_user()));
        addpho.setText(String.valueOf(u.getImg()));
       newaddress.setText(String.valueOf(u.getAdresse()));
      date_naiss .setText(String.valueOf(u.getDate_naiss()));
   
   
    }

    @FXML
    private void cancel(ActionEvent event) {
    }
    
    
    
    
    
    
    
    /***********************************************/

    //private void statisticss(ActionEvent event) throws IOException {
         // Parent page = FXMLLoader.load(getClass().getResource("statistics.fxml"));
              //  Scene scene = new Scene(page);
                //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                //stage.setScene(scene);
                //stage.setResizable(false);
              //  stage.show();
        
        
   // }
//
//    @FXML
//    private void cancel(ActionEvent event) {
//        
//    }

    

    
    }



   
