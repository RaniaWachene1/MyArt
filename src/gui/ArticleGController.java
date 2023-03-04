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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    
    public static int idArticle;
  private PreparedStatement pst;
  private ResultSet rs;
  private Article article;
 private MyListener myListener;
Connection conn = DataSource.getInstance().getCnx();
    @FXML
    private Rating rating;
    @FXML
    private Label label_rating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       rating.ratingProperty().addListener(new ChangeListener <Number>(){
           @Override
           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newR) {
               label_rating.setText(""+newR);
           }
           
       });
    }    
  

    public void setData(Article article, MyListener myListener) throws MalformedURLException {
        this.article = article;
        this.myListener = myListener;
        label_titre.setText(article.getTitre_article());
        label_prix.setText(MyArt.CURRENCY + article.getPrix_article());
        //quantite.setText(String.valueOf(fruit.getQuantite()));
        String path =  "file://C:/xampp/htdocs/imgfile:/C:/xampp/htdocs/img/"+article.getPhoto_article();
        
//     Image imag = new Image(getClass().getResourceAsStream(article.getPhoto_article()));
//     image.setImage(imag);
         Image imag = new Image(path);
        System.out.println(path);
                System.out.println(imag);

        image.setImage(imag);
        
}


    @FXML
    private void click(MouseEvent event) {
         myListener.onClickListener(article);
    }

 


    public interface MyListener {
    public void onClickListener(Article article);
}
}

