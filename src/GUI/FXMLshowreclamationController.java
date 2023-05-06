/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.Servicereclamation;
import entite.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import myart.FXMain;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLshowreclamationController implements Initializable {

    @FXML
    private Label labeltitre;
    @FXML
    private Label labeldesc;
    @FXML
    private Label labeldate;
    @FXML
    private Label labeltype;
    @FXML
    private Label labelimage;
    @FXML
    private Label labelstate;

    /**
     * Initializes the controller class.
     */
    Servicereclamation sr=new Servicereclamation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Reclamation r=sr.getById(FXMLreclamationbackController.id);
        labeldate.setText(r.getDater()+"");
        labeldesc.setText(r.getDescription()+"");
        labelimage.setText(r.getImage()+"");
        labelstate.setText(r.getEtat()+"");
        labeltitre.setText(r.getTitre()+"");
        labeltype.setText(r.getId_typer()+"");
    }    

    @FXML
    private void back(ActionEvent event) {
        Stage closestage=(Stage)((Node)event.getSource()).getScene().getWindow();
        closestage.close();
        try {
            
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLreclamationback.fxml"));
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
