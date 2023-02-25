/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class CommandeFXMLController implements Initializable {

    @FXML
    private Label lbEmail;
    @FXML
    private Label name_client;
    @FXML
    private Button Actualité;
    @FXML
    private Button profile;
    @FXML
    private Hyperlink log_out;
    @FXML
    private TableView<?> tvCommande;
    @FXML
    private TableColumn<?, ?> clmDate;
    @FXML
    private TableColumn<?, ?> clmMontant;
    @FXML
    private TableColumn<?, ?> clmUser;
    @FXML
    private TextField recherche;
    @FXML
    private Button btnD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ImprimPDF(ActionEvent event) {
    }

    @FXML
    private void Details(ActionEvent event) {
    }
    
}
