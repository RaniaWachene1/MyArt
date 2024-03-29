/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class CartController implements Initializable {

    @FXML
    private Button plus_btn;
    @FXML
    private Button mines_btn;
    @FXML
    private ImageView imview;
    @FXML
    private Button cancel_btn;
    @FXML
    private Button log_out_btn;
    @FXML
    private Button back_btn;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Label label_coupon;
    @FXML
    private TextField txt_coupon;
    @FXML
    private Button btn_coupon;
    @FXML
    private AnchorPane cartIteams;
    @FXML
    private Label name;
    @FXML
    private Label categoey;
    @FXML
    private Label price;
    @FXML
    private Label label_total;
    @FXML
    private Label total;
    @FXML
    private Button confirm;
    @FXML
    private RadioButton cod;
    @FXML
    private Button display;
    @FXML
    private Label qte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void plus(ActionEvent event) {
    }

    @FXML
    private void mines(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
         name.setText("Empty");
        price.setText("0");
        qte.setText("0");
        total.setText("0");
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("MarketG.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

    @FXML
    private void coupon(ActionEvent event) {
        
       if(txt_coupon.getText().equalsIgnoreCase("TheDevelopors")) 
       {total.getText();}
    }

    @FXML
    private void Display(ActionEvent event) {
        double tot =0;
        ArrayList<data> ar = new ArrayList();
        Node node = (Node) event.getSource();
  Stage stage = (Stage) node.getScene().getWindow();
        data liste = (data) stage.getUserData();
        name.setText(liste.getTitle());
        price.setText(liste.getPrix()+"");
        qte.setText(liste.getQte()+"");
        for(int i =0 ; i<= ar.size(); i++)
        {
         tot=tot+(liste.getPrix()*liste.getQte());
        }
        total.setText(tot+"");
    }
    
}
