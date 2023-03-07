/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceTypeReclamation;
import Service.Servicereclamation;
import entite.Etatreclamation;
import entite.Reclamation;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import myart.FXMain;
import util.FilterBadWord;

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
    @FXML
    private ImageView img;
    @FXML
    private AnchorPane anchore;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.addAll(str.getAllNom());
        cbtype.setItems(data);
        tfimage.setDisable(true);
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws MalformedURLException, IOException {
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreure ajout reclamation");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            int idtr=str.getTypeByNom(cbtype.getSelectionModel().getSelectedItem());
            Reclamation r=new Reclamation();
            
            if(FilterBadWord.checkBadWords(tadesc.getText())|| FilterBadWord.checkBadWords(tftitre.getText())){
                Alert alertbd=new Alert(Alert.AlertType.WARNING);
                alertbd.setTitle("erreure ajout reclamation");
                alertbd.setContentText("-Attention de ne pas mettre des gros mots\n");
                alertbd.showAndWait();
            }
            
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

    @FXML
    private void gotousergstreclam(ActionEvent event) {
        Stage stageclose=(Stage)((Node)event.getSource()).getScene().getWindow();
        stageclose.close();
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLgstreclamationuser.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Reclamation!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void upload(ActionEvent event) {
        FileChooser open=new FileChooser();
        Stage stage=(Stage)anchore.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null){
            String filename=file.getName();
            tfimage.setText(filename);
            Image imag=new Image(file.toURI().toString());
            img.setImage(imag);
        }
    }
    
}