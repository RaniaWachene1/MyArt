/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Etatreclamation;
import entite.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceTypeReclamation;
import service.Servicereclamation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLreclamationbackController implements Initializable {

    @FXML
    private TableView<Reclamation> tvreclamation;
    @FXML
    private TableColumn<Reclamation, Integer> cid;
    @FXML
    private TableColumn<Reclamation, String> ctitre;
    @FXML
    private TableColumn<Reclamation, String> cdesc;
    @FXML
    private TableColumn<Reclamation, Date> cdate;
    @FXML
    private TableColumn<Reclamation, String> ctype;
    @FXML
    private TableColumn<Reclamation, Integer> cidu;
    @FXML
    private TableColumn<Reclamation, String> cimage;
    ObservableList<Reclamation> data=FXCollections.observableArrayList();
    ServiceTypeReclamation str=new ServiceTypeReclamation();
    Servicereclamation sr=new Servicereclamation();
    @FXML
    private TableColumn<?, ?> cetat;
    @FXML
    private Button userss;
    @FXML
    private Button galleryy;
    @FXML
    private Button eventss;
    @FXML
    private Button claimss;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    

    @FXML
    private void traiter(ActionEvent event) {
        if(tvreclamation.getSelectionModel().getSelectedItem()!=null){
            Reclamation r=tvreclamation.getSelectionModel().getSelectedItem();
            if(r.getEtat().equals(Etatreclamation.NON_TRAITE)){
                r.setEtat(Etatreclamation.TRAITE);
                sr.modifier(r, r.getIdr());
                refresh();
            }
            
            
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        if(tvreclamation.getSelectionModel().getSelectedItem()!=null){
            int id=tvreclamation.getSelectionModel().getSelectedItem().getIdr();
            sr.supprimer(id);
            refresh();
        }
        
    }

    @FXML
    private void gotogsttype(ActionEvent event) {
        Stage closestage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closestage.close();
        try {
            
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLtypereclamationback.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Reclamation!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLreclamationbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refresh(){
        data.clear();
        data.addAll(sr.afficher());
        cid.setCellValueFactory(new PropertyValueFactory<>("idr"));
        cdate.setCellValueFactory(new PropertyValueFactory<>("dater"));
        cdesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        cimage.setCellValueFactory(new PropertyValueFactory<>("image"));
        cidu.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        cetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        ctype.setCellValueFactory(
                cellData->new SimpleObjectProperty<>(str.getTypeNomById(cellData.getValue().getId_typer())
                ));
        ctitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        
        
        tvreclamation.setItems(data);
    }

    @FXML
    private void stat(ActionEvent event) {
         Stage stageclose=(Stage)((Node)event.getSource()).getScene().getWindow();
        stageclose.close();
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLstatreclamation.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Reclamation!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLreclamationbackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onclickedusers(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("Crud.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

    @FXML
    private void onclickedgalleryy(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("CategoryG.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

//    @FXML
//    private void onclickedevents(ActionEvent event) {
//    }
//
//    @FXML
//    private void onclickedclaimss(ActionEvent event) {
//    }
//    
//
//

    @FXML
    private void gotoclaims(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("FXMLreclamationback.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }
}
