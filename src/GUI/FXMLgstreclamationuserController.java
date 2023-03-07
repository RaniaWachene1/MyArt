/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.MyListener;
import Service.ServiceTypeReclamation;
import Service.Servicereclamation;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import entite.Etatreclamation;
import entite.Reclamation;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import myart.FXMain;
import util.PdfGenerator;

/**
 * FXML Controller class
 *
 * @author Skymil
 */
public class FXMLgstreclamationuserController implements Initializable {

    @FXML
    private TextField tftitre;
    @FXML
    private ComboBox<String> cbtypereclamation;
    @FXML
    private TextArea tfdescription;
    @FXML
    private TextField tfimage;
    @FXML
    private GridPane grid;
    @FXML
    private TextField tfrecherche;
    ServiceTypeReclamation str=new ServiceTypeReclamation();
    Servicereclamation sr=new Servicereclamation();
    ObservableList<String> data=FXCollections.observableArrayList();
    @FXML
    private AnchorPane anchore;
    @FXML
    private Label idgetter;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.addAll(str.getAllNom());
        cbtypereclamation.setItems(data);
        tfimage.setDisable(true);
        
        recherche_avance();
    }    

    @FXML
    private void modifier(ActionEvent event) {
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("erreure ajout reclamation");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            
            int idtr=str.getTypeByNom(cbtypereclamation.getSelectionModel().getSelectedItem());
            Reclamation ramodifier=sr.getById(Integer.parseInt(idgetter.getText()));
            if(ramodifier.getEtat().equals(Etatreclamation.TRAITE)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("erreure modification reclamation");
                alert.setContentText("This claim is already treated");
                alert.showAndWait();
            }
            else{
                Reclamation r=new Reclamation();
                r.setDescription(tfdescription.getText());
                r.setTitre(tftitre.getText());
                r.setImage(tfimage.getText());
                r.setId_typer(idtr);
                r.setId_user(15);
                r.setDater(new Date(System.currentTimeMillis()));
                r.setEtat(Etatreclamation.NON_TRAITE);
                sr.modifier(r,Integer.valueOf(idgetter.getText()));
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Reclamation");
                alert.setContentText("ajout reclamation avec succes");
                alert.showAndWait();
                refresh(sr.afficher());
            }
            
        }
    }
    public String controleDeSaisie(){
        String erreur="";
        if(tftitre.getText().trim().isEmpty()){
            erreur+="Titre vide!\n";
        }
        if(tfdescription.getText().trim().isEmpty()){
            erreur+="Description vide!\n";
        }
        if(cbtypereclamation.getSelectionModel().getSelectedItem()==null){
            erreur+="type reclamtion vide!\n";
        }
        
        return erreur;
    }

    @FXML
    private void supprimer(ActionEvent event) {
        sr.supprimer(Integer.valueOf(idgetter.getText()));
        refresh(sr.afficher());
    }

    @FXML
    private void uploadimg(ActionEvent event) {
        FileChooser open=new FileChooser();
        Stage stage=(Stage)anchore.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null){
            String filename=file.getName();
            tfimage.setText(filename);
            Image img=new Image(file.toURI().toString());
            image.setImage(img);
        }
    }

    @FXML
    private void generatepdf(ActionEvent event) {
        PdfGenerator pg=new PdfGenerator();
        String date=LocalDateTime.now().toLocalDate().toString();
        String path="C:\\Users\\ASUS\\Desktop\\PIDEV\\MyArt\\src\\pdf\\"+"MesReclamations"+date+".pdf";
        Document doc=pg.createPDF(path);
        doc.add(generateTablePDF());
        doc.close();
        
    }

    @FXML
    private void tri(ActionEvent event) {
        refresh(sr.afficher()
                .stream()
                .sorted((r1,r2)->r1.getDater().compareTo(r2.getDater()))
                .collect(Collectors.toList()));
    }
    MyListener myListener;
    public void selectedReclamation(Reclamation r){
        idgetter.setText(r.getIdr()+"");
    }
    public void refresh(List<Reclamation> reclamations){
        grid.getChildren().clear();
        //List<Reclamation> reclamations=sr.afficher();
        if(reclamations.size()>0){
            selectedReclamation(reclamations.get(0));
            myListener=new MyListener() {
                @Override
                public void onclickListener(Reclamation r) {
                    selectedReclamation(r);
                    fillData(r);
                    
                }
            };
        }
        int column=0;
        int row=1;
        for(int i=0;i<reclamations.size();i++){
            try {
                FXMLLoader load=new FXMLLoader();
                load.setLocation(getClass().getResource("/GUI/FXMLcartereclamation.fxml"));
                AnchorPane anchorPane=load.load();
                FXMLcartereclamationController itemController=load.getController();
                itemController.remplireData(reclamations.get(i),myListener);
                if(column==2){
                    column=0;
                    row++;
                }
                grid.add(anchorPane,column++,row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException ex) {
                Logger.getLogger(FXMLgstreclamationuserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void fillData(Reclamation r){
        tfdescription.setText(r.getDescription());
        tftitre.setText(r.getTitre());
        cbtypereclamation.setValue(str.getTypeNomById(r.getId_typer()));
        tfimage.setText(r.getImage());
        File file=new File("C:\\Users\\ASUS\\Desktop\\PIDEV\\MyArt\\src\\img\\"+r.getImage());
        Image img=new Image(file.toURI().toString());
        image.setImage(img);
    }
    public Table generateTablePDF(){
        int row=1;
        String imgPath="C:\\Users\\ASUS\\Desktop\\PIDEV\\MyArt\\src\\img\\";
        PdfFont bold=null;
        try {
            bold=PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
        } catch (IOException ex) {
            Logger.getLogger(FXMLgstreclamationuserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Table table =new Table(new float[7]).useAllAvailableWidth();
        table.setMarginTop(5);
        table.setMarginBottom(5);
        table.setMarginRight(5);
        table.setMarginLeft(5);
            
        Cell cell=new Cell(1,7).add(new Paragraph("Liste des reclamations").setFont(bold));
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setPadding(5);
        //bg color
        cell.setBackgroundColor(new DeviceRgb(27, 142, 171));
        table.addCell(cell);
        table.setTextAlignment(TextAlignment.CENTER);
        
        table.addCell(new Cell(1,1).add(new Paragraph("Id reclamation")).setFont(bold));
        table.addCell(new Cell(1,1).add(new Paragraph("Titre reclamation")).setFont(bold));
        table.addCell(new Cell(1,1).add(new Paragraph("Type reclamation")).setFont(bold));
        table.addCell(new Cell(1,1).add(new Paragraph("Description reclamation")).setFont(bold));
        table.addCell(new Cell(1,1).add(new Paragraph("Date reclamation")).setFont(bold));
        table.addCell(new Cell(1,1).add(new Paragraph("Etat reclamation")).setFont(bold));
        table.addCell(new Cell(1,1).add(new Paragraph("Image reclamation")).setFont(bold));
        
        List<Reclamation> reclamations=sr.afficher();
        for(Reclamation r:reclamations){
            table.addCell(r.getIdr()+"");
            table.addCell(r.getTitre()+"");
            table.addCell(str.getTypeNomById(r.getId_typer())+"");
            table.addCell(r.getDescription()+"");
            table.addCell(r.getDater()+"");
            table.addCell(r.getEtat()+"");
            String currentPath=imgPath+r.getImage();
            try {
                com.itextpdf.layout.element.Image img;
                img=new com.itextpdf.layout.element.Image(ImageDataFactory.create(currentPath));
                img.setWidth(70);
                img.setHeight(70);
                table.addCell(img.setAutoScale(true));
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(FXMLgstreclamationuserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            row++;
        }
        return table;
        
        
    }

    @FXML
    private void gotoajouterreclamation(ActionEvent event) {
        Stage stageclose=(Stage)((Node)event.getSource()).getScene().getWindow();
        stageclose.close();
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLreclamationfront.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Reclamation!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void recherche_avance(){
        refresh(sr.afficher());
        ObservableList<Reclamation> reclamations=FXCollections.observableArrayList(sr.afficher());
        FilteredList<Reclamation> filtreddata=new FilteredList<>(reclamations,r->true);
        tfrecherche.textProperty().addListener((observable,oldValue,newValue)->{
            filtreddata.setPredicate(recl->{
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                String newValuelowercase=newValue.toLowerCase();
                if(recl.getDescription().toLowerCase().indexOf(newValuelowercase)!=-1){
                    return true;
                }
                else if(recl.getTitre().toLowerCase().indexOf(newValuelowercase)!=-1){
                    return true;
                }
                else if(String.valueOf(recl.getEtat()).toLowerCase().indexOf(newValuelowercase)!=-1){
                    return true;
                }
                else if(String.valueOf(recl.getDater()).toLowerCase().indexOf(newValuelowercase)!=-1){
                    return true;
                }
                else{
                    return false;
                }
            });
            refresh(filtreddata);
        });
    }
    
}
