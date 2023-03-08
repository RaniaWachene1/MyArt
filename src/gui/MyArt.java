/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author AcerunBlock
 */
public class MyArt extends Application {


    
     public static final String CURRENCY = "$";

     @Override
    public void start(Stage primaryStage) throws IOException {
//FXMLLoader loader=new FXMLLoader(getClass().getResource("Accueil.fxml"));
FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
 //FXMLLoader loader=new FXMLLoader(getClass().getResource("Crud.fxml"));

        System.out.println(loader.getLocation());
        Parent root=loader.load();
         System.out.println("MyArt");
        StackPane stackpane=new StackPane();
        stackpane.getChildren().add(root);
        Scene scene = new Scene(stackpane);
        primaryStage.setScene(scene);
                primaryStage.setTitle("MyArt");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
 
}
