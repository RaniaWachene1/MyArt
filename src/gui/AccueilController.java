/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author rania
 */
public class AccueilController implements Initializable {


    @FXML
    private MenuBar id_menu;
    @FXML
    private Menu id_home;
    @FXML
    private Menu id_Gallery;
    @FXML
    private Menu id_events;
    @FXML
    private Menu id_auctions;
    @FXML
    private ImageView g;
    @FXML
    private ImageView e;
    @FXML
    private ImageView a;
    @FXML
    private Button id_galerie;
    @FXML
    private Button id_event;
    @FXML
    private Button id_auction;
    @FXML
    private ImageView idimg;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_signup;
    @FXML
    private ImageView logo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homeOnClicked(ActionEvent event) throws IOException {
         Parent page = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                

    }

    @FXML
    private void GalleryOnClicked(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("MarketG.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

    @FXML
    private void EventOnClicked(ActionEvent event) {
    }

    @FXML
    private void AuctionOnClicked(ActionEvent event) {
    }

    @FXML
    private void GalleryOnClicked(Event event) {
    }
    
}
