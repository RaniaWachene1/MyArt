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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import service.UserService;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     List<String> listgendre=new ArrayList<>();
     listgendre.add("Homme");
           listgendre.add("Femme");
           newsexe.setItems(FXCollections.observableArrayList(listgendre));
           
           
           
           List<String> listrole=new ArrayList<>();
     listrole.add("Artiste");
           listrole.add("client");
            listrole.add("Admin");
           newrole.setItems(FXCollections.observableArrayList(listrole));


    
    }
    
  

@FXML
    private void insert(ActionEvent event) {
        
        
            if (newfirstname.getText().isEmpty() ||newlastname.getText().isEmpty()||newemail.getText().isEmpty() ||
                  newpass.getText().isEmpty()) {
           
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
        }
         else if ( newfirstname.getText().matches(".*[0-9].*")||newfirstname.getText().matches(".*[%-@-.-/-!-;-,-_].*")||newlastname.getText().matches(".*[0-9].*")||newlastname.getText().matches(".*[%-@-.-/-!-;-,-_].*")) {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Please enter only letters ! ");
            a2.showAndWait();

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
                  "ea",
                  newaddress.getText(),
                 new Role(1))
                 ;
           us.insert(u);
           
           Alert a3 = new Alert(Alert.AlertType.INFORMATION);
            a3.setHeaderText(null);
            a3.setContentText("Successfully added ! ");
            a3.showAndWait();}
       
    }
    

    
//     LocalDate ld=date.getValue();
//        
//        UserService us=new UserService();
//        User u=new User(
//               lastname.getText(),
//               firstname.getText(),
//                date.getValue(),
//                email.getText(),
//               address.getText(),
//               phone.getText(),
//               pass.getText(),
//               passc. getText());
//                
//   
//        us.insert(u);
//    }

    @FXML
    private void update(ActionEvent event) {
          
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
                 
   Alert a3 = new Alert(Alert.AlertType.INFORMATION);
            a3.setHeaderText(null);
            a3.setContentText("Successfully update ! ");
            a3.showAndWait();
        us.update(u);
       
    }

    @FXML
    private void delete(ActionEvent event) {
        int n =Integer.parseInt(newid.getText());
    
        UserService us=new UserService();
        User u=new User(Integer.parseInt(newid.getText()));
                
       Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("successfuly deleted");
            a2.showAndWait();
        us.delete(u);
    }

 

    @FXML
    private void readAll(ActionEvent event) {
//         UserService us=new UserService();
//                 ObservableList<User> data =FXCollections.observableArrayList();
//                 List<User> list=new ArrayList<>();
//                 list=us.readAll();
//                 for(User e:list)
//                 {
//                     data.add(e);
//
//                 }
//                 tableview.setItems(data);

List<User> Listu=new ArrayList<>();
UserService us=new UserService();
Listu=us.readAll();
           

       
            ObservableList<User> uu=FXCollections.observableArrayList(Listu);
            System.out.println(uu);
               tableview.setItems(uu);
    }

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

}

   
