/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entite.Role;
import entite.User;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import service.RoleService;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane LoginPane;
    @FXML
    private ImageView img;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Label LoginMessageLabel;
    @FXML
    private Text txt1;
    @FXML
    private Button signup;
    @FXML
    private Button login;
    @FXML
    private Button cancel;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private Button passwordfailed;
    @FXML
    private Label idk;


     Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private Circle idc;
    @FXML
    private Circle idc2;
   

       
   
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // sout TODO
        System.out.println("eza");
        idc.setVisible(false);
                idc2.setVisible(false);

    }    

    private void ControlEmail(InputMethodEvent event) {
       String test= email.getText();
        if (test.contains("@gmail"))
        {
            idc.setVisible(true);
              idc2.setVisible(false);

            
        }
        else{
             idc2.setVisible(true);
              idc.setVisible(false);
        }
    }

    @FXML
    private void ControlEmail(KeyEvent event) {
         String test= email.getText();
        if (test.contains("@gmail"))
        {
            idc.setVisible(true);
              idc2.setVisible(false);

            
        }
        else{
             idc2.setVisible(true);
              idc.setVisible(false);
        }
    }

    @FXML
    private void insert(ActionEvent event) {
        
       UserService su=new UserService();
        RoleService rs=new RoleService();
        User u=su.login(email.getText(), password.getText());
        Role r=new Role();
        r=rs.readById(u.getRole().getId_role());
        switch(r.getDesc_role()){
            case "Admin" :/**/ System.out.println("Admin"); break;
            case "Client":/**/  System.out.println("Client");break;
            case "Artiste":/**/System.out.println("Artise");break;
        
        default : idk.setVisible(true);
        }
    }
    
}
