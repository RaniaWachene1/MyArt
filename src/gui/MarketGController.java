/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import gui.ArticleGController.MyListener;
import entite.Article;
import entite.Galerie;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import service.ServiceArticle;
import service.ServiceGalerie;

/**
 * FXML Controller class
 *
 * @author rania
 */
public class MarketGController implements Initializable {

    @FXML
    private Button btn_search;
    @FXML
    private VBox chosenArticle;
    @FXML
    private Button add_panier;
    @FXML
    private Label titre;
    @FXML
    private Label prix;
    @FXML
    private ImageView imgviw;
    @FXML
    private Label labelq;
    @FXML
    private TextField txt_quantite;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
  
      List<Article> articles = new ArrayList<>();
    private Image imag;
     private MyListener myListener;
    
Connection conn = DataSource.getInstance().getCnx();
    @FXML
    private MenuBar id_menu;
    @FXML
    private Menu id_home;
    @FXML
    private Menu id_Gallery;
    @FXML
    private Button btn_logout;
    @FXML
    private Button Card;
    @FXML
    private ComboBox<String> Category;
    ObservableList<Article> ProductListSearch;
    
    
    
    
    private List<Article> getData() {
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
 try {
            String req = "SELECT * from articles";
            PreparedStatement pst = conn.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                
                articles.add(new Article (rs.getInt("id_article"),
                        
                        rs.getString("titre_article"),
                        rs.getString("desc_article"),
                        rs.getString("photo_article"),
                        rs.getString("nom_artiste"),
                        rs.getFloat("prix_article"),
                        rs.getInt("quantite_article")
                
                
                ));
                              

            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        
System.out.println(articles);
        return articles;
    }
Article a = new Article();
    private void setChosenFruit(Article article) {
        
        a = article;
        
        titre.setText(article.getTitre_article());
        prix.setText(MyArt.CURRENCY + article.getPrix_article());
        //getClass().getResourceAsStream(getData().get(0)+"")
        imag = new Image(getClass().getResourceAsStream(""));
        imgviw.setImage(imag);
//        chosenArticle.setStyle("-fx-background-color: #" + article.getColor() + ";\n" +
//                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        articles.addAll(getData());
        int column = 0;
        int row = 1;
        if (articles.size() > 0) {
            setChosenFruit(articles.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Article article) {
                    setChosenFruit(article);
                }
            };
        }
        try {
            for (int i = 0; i < articles.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ArticleG.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ArticleGController itemController = fxmlLoader.getController();
//           itemController.setData( new Article(),new ArticleGController.MyListener() {
//                    @Override
//                    public void onClickListener(Article article) {
//                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//                    }
//              });
          itemController.setData(articles.get(i), myListener );
                
           
                if (column == 2) {
                    column = 0;
                    row++;
                }

               
                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(20));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ServiceGalerie sg=new ServiceGalerie();
        List<Galerie> list=new ArrayList<>();
        list=sg.readAll();
        List<String> list2=list.stream().map(e->e.getTitre_galerie()).collect(Collectors.toList());
        System.out.println(list2);
        Category.setItems(FXCollections.observableArrayList(list2));
        
        
}
    @FXML
    private void addToCart(ActionEvent event) throws IOException {
        System.out.print(a);
               data datas = new data(a.getTitre_article(),Integer.parseInt(txt_quantite.getText().toString()),a.getPrix_article());
               
                Parent page = FXMLLoader.load(getClass().getResource("Cart.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(datas);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
   }

    @FXML
    private void viewCart(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("Cart.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
    }

    @FXML
    private void SearchByCategory(ActionEvent event) {
         ServiceArticle st= new  ServiceArticle();
        ProductListSearch = st.SearchByGalerie(Category.getValue());
    //  tableview.setItems(ProductListSearch);
    }
    
}
class data{
    private String title;
    private int qte;
    private double prix;

    public data(String title, int qte, double prix) {
        this.title = title;
        this.qte = qte;
        this.prix = prix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
}



