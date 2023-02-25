/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import entite.Article;
import entite.Galerie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
/**
 *
 * @author rania
 */

public class ServiceArticle implements IService<Article> {
     private Connection conn;

    public ServiceArticle() {
        conn = DataSource.getInstance().getCnx();
        
    }
    
    ///////////////////////////////////////////////CRUD AJOUTER ARTICLE /////////////////////////////////////////////////////////OK*
@Override
    public void insert(Article a) {
        String requete = "insert into articles (titre_article,desc_article,photo_article,nom_artiste,prix_article,quantite_article,id_galerie) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
           pst.setString(1, a.getTitre_article());
           pst.setString(2, a.getDesc_article());
           pst.setString(3, a.getPhoto_article());
            pst.setString(4, a.getNom_artiste());
            pst.setFloat(5, a.getPrix_article());
            pst.setInt(6, a.getQuantite_article());
            pst.setInt(7,  a.getGalerie().getId_galerie());
            pst.executeUpdate();
            System.out.println("Article ajouté!");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Article non ajouté!");
        }

        

 
    }

///////////////////////////////////////////////CRUD SUPPRIMER ARTICLE /////////////////////////////////////////////////////////OK*
     @Override
    public void delete(Article a) {
        try {
            String requete = "DELETE FROM articles WHERE titre_article=?";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setString(1, a.getTitre_article());
            pst.executeUpdate();
            System.out.println("Article supprimé!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Article non supprimé!");
        }
    }
    

///////////////////////////////////////////////CRUD SUPPRIMER ARTICLE BY ID /////////////////////////////////////////////////////////OK*
    public void deleteById(int id_article) {
        String requete = "DELETE FROM articles WHERE id_article=?";
        try {
            
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, id_article);
            pst.executeUpdate();
             System.out.println("Article supprimé !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Article non supprimé !");
        }
    }
    
    
///////////////////////////////////////////////CRUD MODIFIER ARTICLE /////////////////////////////////////////////////////////OK*
    @Override
    public void update(Article a) {
        String requete = "UPDATE articles SET titre_article=?,desc_article=?,photo_article=?,nom_artiste=?,prix_article=?,quantite_article=?,id_galerie=?  WHERE id_article=?";
        
        
       try {
            
            PreparedStatement pst = conn.prepareStatement(requete);
           pst.setString(1, a.getTitre_article());
           pst.setString(2, a.getDesc_article());
           pst.setString(3, a.getPhoto_article());
            pst.setString(4, a.getNom_artiste());
            pst.setFloat(5, a.getPrix_article());
            pst.setInt(6, a.getQuantite_article());
            pst.setInt(7, a.getGalerie().getId_galerie());
            pst.setInt(8, a.getId_article());
            pst.executeUpdate();
            System.out.println("Article_id " + a.getId_article()+":" + " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Article non modifié!");
        }

    }


///////////////////////////////////////////////CRUD Afficher ARTICLE BY ID/////////////////////////////////////////////////////////

    @Override
    public Article readById(int id_article) {
        
        Article a=new Article();
        PreparedStatement pst;
        try {
            String requete = "SELECT  FROM articles WHERE id_article= ?";
         pst = conn.prepareStatement(requete);
       pst.setInt(1,id_article);
        ResultSet rst = pst.executeQuery(requete);
        while (rst.next()) {
           a.setTitre_article(rst.getString( "titre_article"));
           a.setDesc_article(rst.getString( "desc_article"));
           a.setPhoto_article(rst.getString( "photo_article"));
           a.setNom_artiste(rst.getString( "nom_artiste"));
            a.setPrix_article(rst.getFloat("prix_article"));
            a.setQuantite_article(rst.getInt("quantite_article"));
            ServiceGalerie sg =new ServiceGalerie();
            Galerie g =new Galerie();
            g=sg.readById(rst.getInt("id_galerie"));
           a.setGalerie( g);
           a.setId_article(rst.getInt( "id_article"));
            
        }}
 catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

///////////////////////////////////////////////CRUD Afficher ARTICLE /////////////////////////////////////////////////////////OK*
    @Override
    public List<Article> readAll() {
         List<Article> list=new ArrayList<>();
            String requete="select * from articles ";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                ServiceGalerie sg =new ServiceGalerie();
            Galerie g =new Galerie();
            g=sg.readById(rs.getInt("id_galerie"));
           
              Article a=new Article(rs.getInt("id_article"), rs.getString("titre_article"),rs.getString("desc_article"),
                      rs.getString("photo_article"),rs.getString("nom_artiste"), rs.getFloat("prix_article"),
                      rs.getInt("quantite_article") ,g);

list.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGalerie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }
    


    
    
}
