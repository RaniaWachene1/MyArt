/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.ServiceTypeReclamation;
import service.Servicereclamation;
import entite.Etatreclamation;
import entite.Reclamation;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLreclamationfrontController implements Initializable {

    @FXML
    private TextField tftitre;
    @FXML
    private TextArea tadesc;
    @FXML
    private TextField tfimage;
    @FXML
    private ComboBox<String> cbtype;
    ServiceTypeReclamation str=new ServiceTypeReclamation();
    Servicereclamation sr=new Servicereclamation();
    ObservableList<String> data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.addAll(str.getAllNom());
        cbtype.setItems(data);
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreure ajout reclamation");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            int idtr=str.getTypeByNom(cbtype.getSelectionModel().getSelectedItem());
            Reclamation r=new Reclamation();
            r.setDescription(tadesc.getText());
            r.setTitre(tftitre.getText());
            r.setImage(tfimage.getText());
            r.setId_typer(idtr);
            r.setId_user(15);
            r.setDater(new Date(System.currentTimeMillis()));
            r.setEtat(Etatreclamation.NON_TRAITE);
            sr.ajouter(r);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reclamation");
            alert.setContentText("ajout reclamation avec succes");
            alert.showAndWait();
        }
        
    }
    public String controleDeSaisie(){
        String erreur="";
        if(tftitre.getText().trim().isEmpty()){
            erreur+="Titre vide!\n";
        }
        if(tadesc.getText().trim().isEmpty()){
            erreur+="Description vide!\n";
        }
        if(cbtype.getSelectionModel().getSelectedItem()==null){
            erreur+="type reclamtion vide!\n";
        }
        return erreur;
    }
    
}
