/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.ServiceTypeReclamation;
import entite.TypeReclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLtypereclamationbackController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    @FXML
    private TableView<TypeReclamation> tvtype;
    @FXML
    private TableColumn<TypeReclamation, Integer> cid;
    @FXML
    private TableColumn<TypeReclamation, String> cnom;
    @FXML
    private TableColumn<TypeReclamation, String> cdesc;
    ServiceTypeReclamation str=new ServiceTypeReclamation();
    ObservableList<TypeReclamation> data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        TypeReclamation t=new TypeReclamation(tfnom.getText(), tfdesc.getText());
        str.ajouter(t);
        refresh();
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        if(tvtype.getSelectionModel().getSelectedItem()!=null){
            int id=tvtype.getSelectionModel().getSelectedItem().getIdtr();
            TypeReclamation t=new TypeReclamation(tfnom.getText(), tfdesc.getText());
            str.modifier(t, id);
            refresh();
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        if(tvtype.getSelectionModel().getSelectedItem()!=null){
            int id=tvtype.getSelectionModel().getSelectedItem().getIdtr();
            try{
                str.supprimer(id);
            }
            catch(Exception ex){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type reclamation");
                alert.setContentText("Supprission interdite car il existe des reclamation liee a ce type");
                alert.showAndWait();
            }
            
            refresh();
        }
    }

    @FXML
    private void gotogstrec(ActionEvent event) {
        Stage closestage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closestage.close();
        try {
            
            Parent root=FXMLLoader.load(getClass().getResource("/gui/FXMLreclamationback.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Reclamation!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLtypereclamationbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refresh(){
        data.clear();
        data.addAll(str.afficher());
        cid.setCellValueFactory(new PropertyValueFactory<>("idtr"));
        cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cdesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        
        tvtype.setItems(data);
    }
    
}
