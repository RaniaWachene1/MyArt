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
import javafx.scene.text.Text;
import service.ServiceGalerie;

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
    private TextField txt_GS;
    @FXML
    private Button btn_GS;
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_ra;
    @FXML
    private TextField txt_idgal;
    @FXML
    private Label label_id;
    

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
            
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
        }
         else if ( txt_galerie.getText().matches(".*[0-9].*")||txt_galerie.getText().matches(".*[%-@-.-/-!-;-,-_].*")) {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Please enter only letters ! ");
            a2.showAndWait();

        }
        ServiceGalerie sg=new ServiceGalerie();
         Galerie g=new Galerie( txt_galerie.getText());
           sg.insert(g);
           Alert a3 = new Alert(Alert.AlertType.INFORMATION);
            a3.setHeaderText(null);
            a3.setContentText("Successfully added ! ");
            a3.showAndWait();
       
    }

    @FXML
    private void delete(ActionEvent event) {
          if (txt_galerie.getText().isEmpty() ) {
            
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
        }
          else{
        ServiceGalerie sg=new ServiceGalerie();
         Galerie g=new Galerie(Integer.parseInt(txt_idgal.getText()),txt_galerie.getText());
        sg.delete(g);
        Alert a4 = new Alert(Alert.AlertType.INFORMATION);
            a4.setHeaderText(null);
            a4.setContentText("Successfully deleted ! ");
            a4.showAndWait();}
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
        Alert a5 = new Alert(Alert.AlertType.INFORMATION);
            a5.setHeaderText(null);
            a5.setContentText("Successfully updated ! ");
            a5.showAndWait();
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
    
    }
    

