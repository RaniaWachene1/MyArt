/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceReponse;
import entite.EtatReponse;
import entite.Reclamation;
import entite.Reponse;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import myart.FXMain;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLreponseuserController implements Initializable {

    @FXML
    private TableView<Reponse> tcreponse;
    @FXML
    private TableColumn<Reponse, String> tcobjet;
    @FXML
    private TableColumn<Reponse, String> tcdescription;
    @FXML
    private TableColumn<Reponse, String> tcidrec;
    @FXML
    private TableColumn<Reponse, String> tcetat;
    ServiceReponse sr=new ServiceReponse();
    @FXML
    private Button btnsatistied;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    

    @FXML
    private void selectresponse(MouseEvent event) {
        if(tcreponse.getSelectionModel().getSelectedItem()!=null){
            btnsatistied.setDisable(tcreponse.getSelectionModel().getSelectedItem().getEtat().equals(EtatReponse.Satisfied));
        }
    }

    @FXML
    private void satisfied(ActionEvent event) {
        if(tcreponse.getSelectionModel().getSelectedItem()!=null){
            Reponse rep=tcreponse.getSelectionModel().getSelectedItem();
            rep.setEtat(EtatReponse.Satisfied);
            sr.modifier(rep, rep.getId());
            System.out.println(rep);
            refresh();
        }
        
    }

    @FXML
    private void back(ActionEvent event) {
        Stage stageclose=(Stage)((Node)event.getSource()).getScene().getWindow();
        stageclose.close();
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLreclamationfront.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Reclamation!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ObservableList<Reponse> data=FXCollections.observableArrayList();
     public void refresh(){
        data.clear();
        data.addAll(sr.afficher());
        tcdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tcidrec.setCellValueFactory(new PropertyValueFactory<>("idRec"));
        tcobjet.setCellValueFactory(new PropertyValueFactory<>("objet"));
        tcreponse.setItems(data);
    }
    
}
