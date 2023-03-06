/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myartpi;

/**
 *
 * @author WASSIM
 */
import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import entite.Evenements;
import java.time.LocalDate;
//import tn.esprit.codefellaz.entities.Reponse;
import utils.MyConnection;
import service.Evenement_Crud;
//import tn.esprit.codefellaz.services.ReponseCRUD;

/**
 *
 * @author ASUS
 */
public class MyArtPI extends Application {
    
    
    
    public static void main(String[] args) {

       
        Evenement_Crud crud1 = new Evenement_Crud();
        Evenements e = new Evenements( "tunssdss", "sfqd", "10/12/2012");
 //crud1.ajouterEvent(e);
        //crud1.supprimerEvent(e);
       // crud1.modifierEvent(e); 
        
        //System.out.println(crud1.afficherEvent());
           // crud1.afficherEvent().forEach(System.out::println);
        //ReponseCRUD crud1=new ReponseCRUD();
        //Reponse Reponse1=new Reponse(3,"MMM");
        //crud1.ajouterReponse(Reponse1);
        //crud1.modifierReponse(Reponse1);
        //System.out.println(crud1.afficherReponses());
        // crud1.supprimerReponse(Reponse1);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
    
}


   

    
    
    
    /**
     * @Override public void start(Stage primaryStage) throws Exception {
     *
     * Parent root =
     * FXMLLoader.load(getClass().getResource("/tn/esprit/codefellaz/views/Menu.fxml"))
     * ; Scene scene = new Scene(root);
     *
     * primaryStage.setTitle("MON APPLICATION JAVAFX");
     * primaryStage.setScene(scene); primaryStage.show();
        }
     */

