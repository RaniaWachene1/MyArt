/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entite.Galerie;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;
import service.ServiceGalerie;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class CategoryGController implements Initializable {

    @FXML
    private Label labelGN;
    @FXML
    private TextField txt_galerie;
    @FXML
    private Text labelG;
    @FXML
    private TableView<Galerie> GalleryTable;
    @FXML
    private TableColumn<Galerie, Integer> id_galeries;
    @FXML
    private TableColumn<Galerie, String> titre_galerie;
    @FXML
    private Button btnD_g;
    @FXML
    private Button btnU_g;
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_ra;
    @FXML
    private TextField txt_idgal;
    @FXML
    private Label label_id;
    @FXML
    private TextField txt_search;
    @FXML
    private Button btn_search;
    ObservableList<Galerie> CategoryListSearch;
    @FXML
    private Button myprofile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
      
        ObservableList<Galerie> List = FXCollections.observableArrayList();
        id_galeries.setCellValueFactory(new PropertyValueFactory<>("id_galerie"));
        titre_galerie.setCellValueFactory(new PropertyValueFactory<>("titre_galerie"));
          
//       
       

    }    
 Galerie g=new Galerie();
 ServiceGalerie sg=new ServiceGalerie();
 
 
 
 
    @FXML
    private void insert(ActionEvent event) throws IOException  {
        
        if (txt_galerie.getText().isEmpty() ) {
            txt_galerie.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(txt_galerie).play();
            String titre="Gallery Name is empty !";
String message = "Required fields are empty";
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(3000));
        
        }
        
        else{txt_galerie.setStyle(null);}
        
          if ( txt_galerie.getText().matches(".*[0-9].*")) {
             txt_galerie.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(txt_galerie).play();
                        String titre=" Gallery Name must be alphabetic !";
String message = "Please enter only letters !";
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(5000));

        }
            else{txt_galerie.setStyle(null);}


        
    if (  (!(txt_galerie.getText().isEmpty())) && (!( txt_galerie.getText().matches(".*[0-9].*"))) ) {
        ServiceGalerie sg=new ServiceGalerie();
         Galerie g=new Galerie( txt_galerie.getText());
           sg.insert(g);
              String titre=" Gallery Successfully added !";
String message =( txt_galerie.getText()+" Successfully added !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(5000));
       
    }
  
    }

    @FXML
    private void delete(ActionEvent event) {
          if (txt_galerie.getText().isEmpty() ) {
            String titre="Required fields are empty ! ";
String message =( " Gallery Name is empty !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(3000));
           
        }
          else{
        ServiceGalerie sg=new ServiceGalerie();
         Galerie g=new Galerie(Integer.parseInt(txt_idgal.getText()),txt_galerie.getText());
        sg.delete(g);
           String titre="Successfully deleted !";
String message =( " Successfully deleted !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(3000));
          }
    }

    @FXML
    private void update(ActionEvent event) {
        if (txt_idgal.getText().isEmpty() || txt_galerie.getText().isEmpty()) {
              Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
         }
         ServiceGalerie sg=new ServiceGalerie();
         Galerie g=new Galerie(Integer.parseInt(txt_idgal.getText()),txt_galerie.getText());
         System.out.println("donnée entre"+g);
        sg.update(g);
         String titre="Successfully updated !";
String message =( " Successfully updated !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(3000));
    }

    @FXML
    private void readAll(ActionEvent event) {
       
                ServiceGalerie sg=new ServiceGalerie();
                 ObservableList<Galerie> data =FXCollections.observableArrayList();
                 List<Galerie> list=new ArrayList<>();
                 list=sg.readAll();
                 for(Galerie e:list)
                 {
                                     data.add(e);

                 }
                 GalleryTable.setItems(data);

         


    }

    @FXML
    private void search(ActionEvent event) {
        ServiceGalerie st= new  ServiceGalerie();
        CategoryListSearch = st.SearchBycateg( txt_search.getText());
        GalleryTable.setItems(CategoryListSearch);
    }

    @FXML
    private void clicked(MouseEvent event) {
        Galerie a = GalleryTable.getSelectionModel().getSelectedItem();
    txt_idgal.setText(String.valueOf(a.getId_galerie()));
    txt_galerie.setText(String.valueOf(a.getTitre_galerie()));
   
    }

    @FXML
    private void profile(ActionEvent event) {
    }
    
    }
    

