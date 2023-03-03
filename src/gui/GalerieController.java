/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import entite.Article;
import entite.Galerie;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    @FXML
    private Button pdf;
    
    ObservableList<Article> ProductListSearch;
    ValidationSupport ValidationSupport =new ValidationSupport();
    @FXML
    private TableColumn<Article, String> id_galerie;
 
 
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
        id_galerie.setCellValueFactory(new PropertyValueFactory<>("galerie"));
       // galerie.setCellValueFactory(new PropertyValueFactory<>("Titre_galerie"));
   //galerie.setCellFactory(ComboBoxTableCell.forTableColumn("titre_galerie",id_galerie)));
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
                //ValidationSupport.registerValidator(Txt_titre, Validator.createEmptyValidator("Product name is required"));
              

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
        
        if (Txt_titre.getText().isEmpty()){
        Txt_titre.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(Txt_titre).play();
        
        }
        
        else{Txt_titre.setStyle(null);}
        
        
       
        if (Txt_nomArtiste.getText().isEmpty()){
        Txt_nomArtiste.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(Txt_nomArtiste).play();
        
        }
        
        else{Txt_nomArtiste.setStyle(null);}
        
        
         if (desc.getText().isEmpty()){
        desc.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(desc).play();
        
        }
        
        else{desc.setStyle(null);}
         
         
          if (quantite.getText().isEmpty()){
        quantite.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(quantite).play();
        
        }
        
        else{
              quantite.setStyle(null);
          }
          
          
          
          
          
          
         if (Txt_nomArtiste.getText().isEmpty()){
        Txt_nomArtiste.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(Txt_nomArtiste).play();
        
        }
        
        else{Txt_nomArtiste.setStyle(null);}
         
         
          if (prix.getText().isEmpty()){
        prix.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(prix).play();
        
        }
        
        else
          {prix.setStyle(null); }
        
        if (photo.getText().isEmpty()){
        photo.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(photo).play();
        
        }
        
        else{photo.setStyle(null);}
        
        
        if (Txt_titre.getText().isEmpty() || photo.getText().isEmpty() || prix.getText().isEmpty() || quantite.getText().isEmpty() || nom_artiste.getText().isEmpty() || galerie.getValue() == null) {
           
            
            
            
            String titre="Required fields are empty !";
String message = "Required fields are empty";
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(3000));
            
        }
         else 
            
            if ( Txt_titre.getText().matches(".*[0-9].*")||Txt_titre.getText().matches(".*[%-@-.-/-!-;-,-_].*")
//                
                    )
            {
                Txt_titre.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(Txt_titre).play();
                        String titre=" Product Name must be alphabetic !";
String message = "Please enter only letters !";
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(4000));

        }
            else{Txt_titre.setStyle(null);}

        
        
        
//         if ( 
//                nom_artiste.getText().matches(".*[0-9].*")||nom_artiste.getText().matches(".*[%-@-.-/-!-;-,-_].*")
//                    )
//            {
//                Txt_nomArtiste.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
//        new animatefx.animation.Shake(Txt_nomArtiste).play();
//                        String titre=" Artist Name must be alphabetic !";
//String message = "Please enter only letters !";
//TrayNotification tray = new TrayNotification();
//AnimationType type = AnimationType.POPUP;
//tray.setAnimationType(type);
//tray.setTitle(titre);
//tray.setMessage(message);
//tray.setNotificationType(NotificationType.ERROR);
//tray.showAndDismiss(Duration.millis(4000));
//
//        }
//            else{Txt_nomArtiste.setStyle(null);}
        
        
        
        if ( 
                prix.getText().matches(".*[a-z].*")
                    )
            {
                prix.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(prix).play();
                        String titre=" Price must be number !";
String message = "Please enter only Numbers !";
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(4000));

        }
            else{prix.setStyle(null);}
        
        
        
        
         if ( 
                quantite.getText().matches(".*[a-z].*")
                    )
            {
                quantite.setStyle("-fx-border-color:red ; -fx-border-width:2px ;");
        new animatefx.animation.Shake(quantite).play();
                        String titre=" Quantity must be number !";
String message = "Please enter only Numbers !";
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(4000));

        }
            else{quantite.setStyle(null);}
        
        
        
        
    
   if ((!(Txt_titre.getText().isEmpty() && photo.getText().isEmpty() && prix.getText().isEmpty() && quantite.getText().isEmpty() && nom_artiste.getText().isEmpty() && galerie.getValue() == null))
    &&(!( Txt_titre.getText().matches(".*[0-9].*")))&&(!( Txt_nomArtiste.getText().matches(".*[0-9].*")))&&(!( prix.getText().matches(".*[a-z].*")))&&(!( quantite.getText().matches(".*[a-z].*"))))
   {

        ServiceGalerie sa=new ServiceGalerie();
          Galerie g= new Galerie();
                      int intGalerie=sa.getgalerieFromName( galerie.getValue());

           g.setId_galerie(intGalerie);

        
         Article a=new Article( Txt_titre.getText(),
                 desc.getText(),
                 photo.getText(),
                 nom_artiste.getText(),
                 
                 Float.parseFloat(prix.getText()),
                 Integer.parseInt(quantite.getText()),
                 g);
                 ServiceArticle servicearticle=new ServiceArticle();
           servicearticle.insert(a);
//           Alert a3 = new Alert(Alert.AlertType.INFORMATION);
//            a3.setHeaderText(null);
//            a3.setContentText("Successfully added ! ");
//            a3.showAndWait();
        
//              ServiceGalerie sg=new ServiceGalerie();
//              int intGalerie=sg.getgalerieFromName( galerie.getValue());
//              Galerie g= new Galerie();
//              g.setId_galerie(intGalerie);
//

//          g,
String titre=" Product Successfully added !";
String message =( Txt_titre.getText()+" Successfully added !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(4000));

         }
   else{
   
   String titre="Add product failed !";
String message =("Failed to add "+ Txt_titre.getText()+" , please try again !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(1000));
   
   
   }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void update(ActionEvent event) throws Exception {
//                ServiceGalerie sa=new ServiceGalerie();
//                Galerie g= new Galerie();
         if (txt_idp.getText().isEmpty() || Txt_titre.getText().isEmpty() || photo.getText().isEmpty() 
                 || prix.getText().isEmpty() || quantite.getText().isEmpty() || nom_artiste.getText().isEmpty() || galerie.getValue() == null ) {
             String titre="Update product failed !";
String message =("Failed to update "+ Txt_titre.getText()+" , please try again !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(4000));
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
  String titre="Product Successfully updated !";
String message =( Txt_titre.getText()+" Successfully updated !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(4000));}
         
            
    }

    @FXML
    private void delete(ActionEvent event) throws Exception{

 int n=Integer.parseInt(txt_idp.getText());
        ServiceArticle  es=new ServiceArticle ();
         Article e=new Article(Integer.parseInt(txt_idp.getText()));
        es.delete(e);
         String titre="Product Successfully deleted !";
String message =( " Successfully deleted !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(3000));
        
        
}
 
    

    @FXML
    private void load(ActionEvent event) {
       
    }

    @FXML
    private void readAll(ActionEvent event) throws Exception {
//        List<Article> liste=new ArrayList<>();
//        ServiceArticle sa= new ServiceArticle();
//        Article a = new Article();
//        liste=sa.readAll();
//        ObservableList<Article> data =FXCollections.observableArrayList(liste);
//       
//        System.out.println(liste.get(0).getGalerie().getTitre_galerie());
//                 System.out.println(sa);
//                ProductTable.setItems(data);    

List<Article> liste=new ArrayList<>();
        ServiceArticle sa= new ServiceArticle();
        liste=sa.readAll();
        ObservableList<Article> data =FXCollections.observableArrayList(liste);
                 System.out.println(sa);
                ProductTable.setItems(data); 
    }

    @FXML
    private void addpdf(ActionEvent event) {
        ServiceArticle vs=new ServiceArticle();
           Document document = new Document() ;
        try { 
            PdfWriter.getInstance(document, new FileOutputStream("C://pdf/article.pdf"));
            document.open();
            Image img = Image.getInstance("C://img/logo.png") ;
            document.add(img);
            Paragraph ph0 = new Paragraph("        ");
            Paragraph ph1 = new Paragraph("MyArt !");
            Paragraph ph2 = new Paragraph("        ");
            Paragraph ph3 = new Paragraph("List of available products ");
             Paragraph ph4 = new Paragraph("        ");
            PdfPTable table = new PdfPTable(7);
            PdfPCell cell;
            table.addCell("ID : ");
            table.addCell("Product : ");
            table.addCell("Category : ");
            table.addCell("Artist : "); 
            table.addCell("Price : ");
            table.addCell("Quantity : ");
            table.addCell("Description : "); 
            vs.readAll().forEach(e
                    -> {
                table.addCell(String.valueOf(e.getId_article()));
                
                 table.addCell(e.getTitre_article()); 
                 
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(String.valueOf(e.getGalerie()));
        table.addCell(e.getNom_artiste());
           table.addCell(String.valueOf(e.getPrix_article()));
                                table.addCell(String.valueOf(e.getQuantite_article()));
                                table.addCell(e.getDesc_article());
    
  }
            );
            document.add(ph0);
            document.add(ph1);
            document.add(ph2);
            document.add(ph3);
            document.add(ph4);
            document.add(table);
            document.addAuthor("MyArt");
             String titre="Downloaded !";
String message =( " File downloaded Successfully   !");
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.SUCCESS);
tray.showAndDismiss(Duration.millis(3000));
            
            
            
        } catch (Exception e) {
            System.out.println(e);
             String titre=" Error!";
String message = "The file could not be downloaded ";
TrayNotification tray = new TrayNotification();
AnimationType type = AnimationType.POPUP;
tray.setAnimationType(type);
tray.setTitle(titre);
tray.setMessage(message);
tray.setNotificationType(NotificationType.ERROR);
tray.showAndDismiss(Duration.millis(3000));
        }
        document.close();
            
        
    }

    @FXML
    private void clicked(MouseEvent event) {
         Article a = ProductTable.getSelectionModel().getSelectedItem();
    txt_idp.setText(String.valueOf(a.getId_article()));
    Txt_titre.setText(String.valueOf(a.getTitre_article()));
    galerie.setValue(String.valueOf(a.getGalerie().getTitre_galerie()));
    Txt_nomArtiste.setText(String.valueOf(a.getNom_artiste()));
    prix.setText(String.valueOf(a.getPrix_article()));
    quantite.setText(String.valueOf(a.getQuantite_article()));
     photo.setText(String.valueOf(a.getPhoto_article()));
    desc.setText(String.valueOf(a.getDesc_article()));
    }

    @FXML
    private void actionSearch(ActionEvent event) {
        ServiceArticle st= new  ServiceArticle();
        ProductListSearch = st.SearchByArticle(txt_GS.getText());
        ProductTable.setItems(ProductListSearch);
    }
}
        
        
        
        
        
        
        
        
        
    
    

