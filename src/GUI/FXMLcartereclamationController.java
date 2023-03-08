/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.MyListener;
import entite.Etatreclamation;
import entite.Reclamation;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import service.ServiceTypeReclamation;
import service.Servicereclamation;

/**
 * FXML Controller class
 *
 * @author Skymil
 */
public class FXMLcartereclamationController implements Initializable {

    @FXML
    private Label labeltitre;
    @FXML
    private Label labeltype;
    @FXML
    private Label labeldate;
    @FXML
    private Label labeletat;
    private Reclamation r;
    ServiceTypeReclamation str=new ServiceTypeReclamation();
    Servicereclamation sr=new Servicereclamation();
    @FXML
    private Label labeldesc;
    private MyListener myListener;
    @FXML
    private ImageView image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void remplireData(Reclamation r,MyListener myListener){
        this.r=r;
        this.myListener=myListener;
        Paint paint;
        labeldate.setText(r.getDater().toString());
        labeltitre.setText(r.getTitre());
        labeltype.setText(str.getTypeNomById(r.getId_typer()));
        labeletat.setText(r.getEtat().name());
        if(r.getEtat().equals(Etatreclamation.NON_TRAITE)){
            paint=new Color(1, 0, 0, 1);
        }
        else {
            paint=new Color(0.2, 0.8, 0, 1);
        }
        
        labeletat.setTextFill(paint);
        
        labeldesc.setText(r.getDescription());
        if(r.getImage().equals("")){
            File filed=new File("C:\\Users\\Acer\\Documents\\NetBeansProjects\\MyArt\\src\\gui\\IMG\\claims-1024x571.png");
        Image imgd=new Image(filed.toURI().toString());
        image.setImage(imgd);
        }
        else{
            File file=new File("C:\\Users\\Acer\\Documents\\NetBeansProjects\\MyArt\\src\\gui\\IMG\\"+r.getImage());
        Image img=new Image(file.toURI().toString());
        image.setImage(img);
        }
        
    }

    @FXML
    private void selectionreclamation(MouseEvent event) {
        myListener.onclickListener(r);
    }
    
}
