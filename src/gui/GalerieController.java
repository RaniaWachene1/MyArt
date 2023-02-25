/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entite.Article;
import entite.Galerie;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.ServiceArticle;
import service.ServiceGalerie;
import java.sql.*;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class GalerieController implements Initializable {

    @FXML
    private Label labelPN;
    @FXML
    private TextField Txt_titre;
    @FXML
    private Label labelC;
    @FXML
    private ComboBox<String> galerie;
    @FXML
    private TextArea desc;
    @FXML
    private TextField quantite;
    @FXML
    private Label labelPrice;
    @FXML
    private Label labeQuantity;
    @FXML
    private TextField prix;
    @FXML
    private Label labelAN;
    @FXML
    private TextField Txt_nomArtiste;
    @FXML
    private Label labelDesc;
    @FXML
    private Text labelProduct;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<Article> ProductTable;
    @FXML
    private TableColumn<Article, Integer> readP;
    @FXML
    private TableColumn<Article, String> titre_article;
    @FXML
    private TableColumn<Article, Integer> id_galerie;
    @FXML
    private TableColumn<Article, String> nom_artiste;
    @FXML
    private TableColumn<Article, Float> prix_article;
    @FXML
    private TableColumn<Article, Integer> quantite_article;
    @FXML
    private TableColumn<Article, String> photo_article;
    @FXML
    private TableColumn<Article, String> desc_article;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txt_GS;
    @FXML
    private Button btn_GS;
    @FXML
    private MenuBar id_menu;
    @FXML
    private Menu id_home;
    @FXML
    private Menu id_Gallery;
    @FXML
    private Menu id_events;
    @FXML
    private Menu id_auctions;
    @FXML
    private Button btn_read;
    @FXML
    private Button photo;
    @FXML
    private ImageView imview;
    @FXML
    private Label labelidPP;
    @FXML
    private TextField txt_idp;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  ObservableList<String> list = FXCollections.observableList("a","b");
        
        // TODO
        ObservableList<Article> Liste = FXCollections.observableArrayList();
        readP.setCellValueFactory(new PropertyValueFactory<>("id_article"));
        titre_article.setCellValueFactory(new PropertyValueFactory<>("titre_article"));
        id_galerie.setCellValueFactory(new PropertyValueFactory<>("id_galerie"));
        nom_artiste.setCellValueFactory(new PropertyValueFactory<>("nom_artiste"));
        prix_article.setCellValueFactory(new PropertyValueFactory<>("prix_article"));
        quantite_article.setCellValueFactory(new PropertyValueFactory<>("quantite_article"));
        photo_article.setCellValueFactory(new PropertyValueFactory<>("photo_article"));
        desc_article.setCellValueFactory(new PropertyValueFactory<>("desc_article"));
        ServiceGalerie sg=new ServiceGalerie();
        List<Galerie> list=new ArrayList<>();
        list=sg.readAll();
        List<String> list2=list.stream().map(e->e.getTitre_galerie()).collect(Collectors.toList());
        System.out.println(list2);
        galerie.setItems(FXCollections.observableArrayList(list2));
    }    

    @FXML
    private void InsertPhoto(ActionEvent event) throws FileNotFoundException, IOException {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Resource File");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            this.photo.setText(selectedFile.toURI().toURL().toString());
           imview.setImage(image);
        }
    }

    @FXML
    private void insert(ActionEvent event) throws Exception {
        
        if (Txt_titre.getText().isEmpty() || photo.getText().isEmpty() || prix.getText().isEmpty() || quantite.getText().isEmpty() || nom_artiste.getText().isEmpty() || galerie.getValue() == null) {
            
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
        }
         else if ( Txt_titre.getText().matches(".*[0-9].*")||Txt_titre.getText().matches(".*[%-@-.-/-!-;-,-_].*")
                 ||nom_artiste.getText().matches(".*[0-9].*")||nom_artiste.getText().matches(".*[%-@-.-/-!-;-,-_].*") ) {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Please enter only letters ! ");
            a2.showAndWait();

        }
         else if ( prix.getText().matches(".*[a-z].*")||quantite.getText().matches(".*[a-z].*"))
            {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Please enter only Numbers ! ");
            a2.showAndWait();

        }
         else{
        ServiceGalerie sa=new ServiceGalerie();
          Galerie g= new Galerie();
                      int intGalerie=sa.getgalerieFromName( galerie.getValue());

           g.setId_galerie(intGalerie);

        
         Article a=new Article( Txt_titre.getText(),
                 desc.getText(),
                 nom_artiste.getText(),
                 photo.getText(),
                 Float.parseFloat(prix.getText()),
                 Integer.parseInt(quantite.getText()),
                 g);
                 ServiceArticle servicearticle=new ServiceArticle();
           servicearticle.insert(a);
           Alert a3 = new Alert(Alert.AlertType.INFORMATION);
            a3.setHeaderText(null);
            a3.setContentText("Successfully added ! ");
            a3.showAndWait();
        
//              ServiceGalerie sg=new ServiceGalerie();
//              int intGalerie=sg.getgalerieFromName( galerie.getValue());
//              Galerie g= new Galerie();
//              g.setId_galerie(intGalerie);
//

//          g,
         }
    }

    @FXML
    private void update(ActionEvent event) throws Exception {
//                ServiceGalerie sa=new ServiceGalerie();
//                Galerie g= new Galerie();
         if (txt_idp.getText().isEmpty() || Txt_titre.getText().isEmpty() || photo.getText().isEmpty() 
                 || prix.getText().isEmpty() || quantite.getText().isEmpty() || nom_artiste.getText().isEmpty() || galerie.getValue() == null ) {
              Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Required fields are empty ! ");
            al.showAndWait();
         }
         else{
            ServiceArticle sa=new ServiceArticle();
           Article a=new Article(
                  Integer.parseInt(txt_idp.getText()),
                   Txt_titre.getText(),
                 desc.getText(),
                   photo.getText(),
                 nom_artiste.getText(),
                 Float.parseFloat(prix.getText()),
                 Integer.parseInt(quantite.getText()));
                 sa.update(a);
  Alert a5 = new Alert(Alert.AlertType.INFORMATION);
            a5.setHeaderText(null);
            a5.setContentText("Successfully updated ! ");
            a5.showAndWait();}
         
            
    }

    @FXML
    private void delete(ActionEvent event) throws Exception{

if (txt_idp.getText().isEmpty()){
    Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText(" Please enter the ID ! ");
            al.showAndWait();
}
else{
 int n=Integer.parseInt(txt_idp.getText());
        ServiceArticle  es=new ServiceArticle ();
         Article e=new Article(Integer.parseInt(txt_idp.getText()));
        es.delete(e);
Alert a5 = new Alert(Alert.AlertType.INFORMATION);
            a5.setHeaderText(null);
            a5.setContentText("Successfully deleted ! ");
            a5.showAndWait();}
 
    }

    @FXML
    private void load(ActionEvent event) {
       
    }

    @FXML
    private void readAll(ActionEvent event) throws Exception {
        List<Article> liste=new ArrayList<>();
        ServiceArticle sa= new ServiceArticle();
        liste=sa.readAll();
        ObservableList<Article> data =FXCollections.observableArrayList(liste);
                 System.out.println(sa);
                ProductTable.setItems(data);    
    }
    
}
