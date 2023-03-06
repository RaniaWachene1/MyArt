/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Evenements;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.Evenement_Crud;

/**
 * FXML Controller class
 *
 * @author WASSIM
 */
public class AddeventController implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private TextField place_event;
    private TextField nom_event;
    private DatePicker date_event;
    @FXML
    private Label labelPN;
    @FXML
    private TextField name_event;
    @FXML
    private Label labelC;
    @FXML
    private Label labelAN;
    @FXML
    private Text labelProduct;
    @FXML
    private ImageView imview;
    @FXML
    private TableView<?> ProductTable;
    @FXML
    private TableColumn<?, ?> id_ev;
    @FXML
    private TableColumn<?, ?> name_ev;
    @FXML
    private TableColumn<?, ?> place_ev;
    @FXML
    private TableColumn<?, ?> date_ev;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txt_GS;
    @FXML
    private Button btn_GS;
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
    private Button btn_read;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        btnUpdate.setOnAction(supprimer -> {
                                    Alert alert = new Alert(AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation Dialog");
                                    alert.setHeaderText("Are you sure you want to delete the event?");
                                    alert.setContentText("Click yes to continue or no to cancel.");

                                    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                                    Optional<ButtonType> result = alert.showAndWait();
                                    if (result.isPresent() && result.get() == buttonTypeYes) {
                                        // user clicked "Yes"
                                        // handle "Yes" button event
                                        afficher1.supprimer_Evenement(evenement.getId_event());
                                        try {
                                            Parent ajouter_event_parent = FXMLLoader.load(getClass().getResource("/tn/esprit/codefellaz/views/liste_evenements.fxml"));
                                            Scene ajouter_event_scene = new Scene(ajouter_event_parent);
                                            Stage ajout_stage = (Stage) ((Node) supprimer.getSource()).getScene().getWindow();
                                            ajout_stage.hide();
                                            ajout_stage.setScene(ajouter_event_scene);
                                            ajout_stage.show();
                                        } catch (IOException ex) {
                                            System.out.println(ex.getMessage());
                                        }

                                    } else {
                                        try {
                                            Parent ajouter_event_parent = FXMLLoader.load(getClass().getResource("/tn/esprit/codefellaz/views/liste_evenements.fxml"));
                                            Scene ajouter_event_scene = new Scene(ajouter_event_parent);
                                            Stage ajout_stage = (Stage) ((Node) supprimer.getSource()).getScene().getWindow();
                                            ajout_stage.hide();
                                            ajout_stage.setScene(ajouter_event_scene);
                                            ajout_stage.show();
                                        } catch (IOException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                    }

                                });
        
        
       

  
        
        
        
        
        
        
        
    }

    @FXML
    private void insert(ActionEvent event) {
        
        
         DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate today = LocalDate.now();
        if (nom_event.getText().isEmpty() || place_event.getText().isEmpty() ||date_event.getValue().format(dateFormatter).isEmpty()) {
            
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
        }
         
         else{
            Evenements Evenements= new Evenements(  nom_event.getText(), place_event.getText(), date_event.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        Evenement_Crud Crud1=new Evenement_Crud();
          
                 
           Crud1.ajouterEvent(Evenements);
           Alert a3 = new Alert(Alert.AlertType.INFORMATION);
            a3.setHeaderText(null);
            a3.setContentText("Successfully added ! ");
            a3.showAndWait();
        
//              ServiceGalerie sg=new ServiceGalerie();
//              int intGalerie=sg.getgalerieFromName( galerie.getValue());
//              Galerie g= new Galerie();
//              g.setId_galerie(intGalerie);
//

//          g,
         }
    }
    
    
    @fxml
    
    btnUpdate.setOnAction(supprimer -> {
                                    Alert alert = new Alert(AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation Dialog");
                                    alert.setHeaderText("Are you sure you want to delete the event?");
                                    alert.setContentText("Click yes to continue or no to cancel.");

                                    ButtonType buttonTypeYes = new ButtonType("Yes", ButtonData.YES);
                                    ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);
                                    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                                    Optional<ButtonType> result = alert.showAndWait();
                                    if (result.isPresent() && result.get() == buttonTypeYes) {
                                        // user clicked "Yes"
                                        // handle "Yes" button event
                                        afficher1.supprimer_Evenement(evenement.getId_event());
                                        try {
                                            Parent ajouter_event_parent = FXMLLoader.load(getClass().getResource("/tn/esprit/codefellaz/views/liste_evenements.fxml"));
                                            Scene ajouter_event_scene = new Scene(ajouter_event_parent);
                                            Stage ajout_stage = (Stage) ((Node) supprimer.getSource()).getScene().getWindow();
                                            ajout_stage.hide();
                                            ajout_stage.setScene(ajouter_event_scene);
                                            ajout_stage.show();
                                        } catch (IOException ex) {
                                            System.out.println(ex.getMessage());
                                        }

                                    } else {
                                        try {
                                            Parent ajouter_event_parent = FXMLLoader.load(getClass().getResource("/tn/esprit/codefellaz/views/liste_evenements.fxml"));
                                            Scene ajouter_event_scene = new Scene(ajouter_event_parent);
                                            Stage ajout_stage = (Stage) ((Node) supprimer.getSource()).getScene().getWindow();
                                            ajout_stage.hide();
                                            ajout_stage.setScene(ajouter_event_scene);
                                            ajout_stage.show();
                                        } catch (IOException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                    }

                                });
    

    
    

   
        
        
        

   

   
    
    
                 
    
    

}