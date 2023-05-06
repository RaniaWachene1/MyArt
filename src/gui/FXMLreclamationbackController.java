/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceReponse;
import Service.ServiceTypeReclamation;
import Service.Servicereclamation;
import entite.EtatReponse;
import entite.Etatreclamation;
import entite.Reclamation;
import entite.Reponse;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import myart.FXMain;

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
    private TableColumn<Reclamation, String> cetat;
    @FXML
    private TextField tfobjet;
    @FXML
    private TextArea tfdesc;
    public static int id;
    ServiceReponse srep=new ServiceReponse();
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
            if(!srep.checkSatisfaction(r.getIdr())){
                r.setEtat(Etatreclamation.Handled);
                sr.modifier(r, r.getIdr());
                Reponse rep=new Reponse();
                rep.setDescription(tfdesc.getText());
                rep.setObjet(tfobjet.getText());
                rep.setIdrec(r.getIdr());
                rep.setEtat(EtatReponse.Unsatisfied);
                srep.ajouter(rep);
                refresh();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("User already satistfied with your response");
                alert.showAndWait();
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
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
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
    private void show(ActionEvent event) {
        if(tvreclamation.getSelectionModel().getSelectedItem()!=null){
            id=tvreclamation.getSelectionModel().getSelectedItem().getIdr();
            Stage closestage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closestage.close();
        try {
            
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLshowreclamation.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Reclamation!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
