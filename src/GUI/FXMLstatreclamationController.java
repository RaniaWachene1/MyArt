/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;
import myart.FXMain;
import util.Mysql;

/**
 * FXML Controller class
 *
 * @author Skymil
 */
public class FXMLstatreclamationController implements Initializable {

    @FXML
    private BarChart<String, Integer> barchart;
    Connection conn=Mysql.getInstance().getConn();
    ObservableList<XYChart.Data> data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statistiqueReclamation();//#7f9db9
        // TODO
    }    
   public void statistiqueReclamation(){
       
        try {
            String query="select typereclamation.nom,count(reclam.idr) as nbr from typereclamation left JOIN reclam on typereclamation.idtr=reclam.idtyper GROUP BY typereclamation.nom";
            Statement statement=conn.createStatement();
            ResultSet resulset=statement.executeQuery(query);
            while(resulset.next()){
                data.add(new XYChart.Data<String,Integer>("Type:"+resulset.getString("nom"), resulset.getInt("nbr")));
                
            }
            XYChart.Series series=new XYChart.Series();
            series.getData().addAll(data);
            barchart.getData().add(series);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLstatreclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void back(ActionEvent event) {
         Stage stageclose=(Stage)((Node)event.getSource()).getScene().getWindow();
        stageclose.close();
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
