/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
    
}
