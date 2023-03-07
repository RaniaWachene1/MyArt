/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import entite.Article;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import org.controlsfx.control.Rating;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class ArticleGController implements Initializable {

    @FXML
    private Label label_titre;
    @FXML
    private Label label_prix;
    @FXML
    private ImageView image;
    Double res;
  private PreparedStatement pst;
  private ResultSet rs;
  private Article article;
 private MyListener myListener;
Connection conn = DataSource.getInstance().getCnx();
    @FXML
    private Rating rating;
    @FXML
    private Label label_rating;
    @FXML
    private Button ratee;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       rating.ratingProperty().addListener(new ChangeListener <Number>(){
           @Override
           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newR) {
               res= (double) newR;
               label_rating.setText(""+newR);
           }
           
       });
    }  
       void rated(TouchEvent event) {

           
    }
   
    public void setData(Article article, MyListener myListener) throws MalformedURLException {
        this.article = article;
        this.myListener = myListener;
        label_titre.setText(article.getTitre_article());
        label_prix.setText(MyArt.CURRENCY + article.getPrix_article());
        label_rating.setText(String.valueOf(article.getRate()));
      
       String path =article.getPhoto_article().substring(6);
        File imageFile = new File(path);
     Image images = new Image(imageFile.toURI().toString());
     //mage imag = new Image(getClass().getResourceAsStream(article.getPhoto_article()));
     image.setImage(images);
//         Image imag = new Image(path);
//        System.out.println(path);
//                System.out.println(imag);
//
//        image.setImage(imag);
        
}
    @FXML
    private void click(MouseEvent event) {
         myListener.onClickListener(article);
    }

    @FXML
    private void rating(ActionEvent event) {
        
        
         String req = "UPDATE `articles` SET `rate`= ? WHERE `id_user`= ?";
               try {
                   pst = conn.prepareStatement(req);
                   pst.setDouble(1, res);
                   pst.setInt(2, 2);
                   
                   int row = pst.executeUpdate();
                   System.out.println(pst);
                   
               } catch (SQLException ex) {
                   Logger.getLogger(ArticleGController.class.getName()).log(Level.SEVERE, null, ex);
               }
         
        
        
    }

    public interface MyListener {
    public void onClickListener(Article article);
}
}

