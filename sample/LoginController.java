/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

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
    private Circle idc;
    @FXML
    private Circle idc2;
    @FXML
    private Label idk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ControlEmail(KeyEvent event) {
    }

    @FXML
    private void insert(ActionEvent event) {
    }
    
}
