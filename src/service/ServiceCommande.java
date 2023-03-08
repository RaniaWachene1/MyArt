/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entite.Article;
import entite.Commande;
import entite.User;
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
public class ServiceCommande implements IService<Commande> {
     private Connection conn;

    public ServiceCommande() {
        conn = DataSource.getInstance().getCnx();
        
    }
    
    ///////////////////////////////////////////////CRUD AJOUTER commande /////////////////////////////////////////////////////////OK*
@Override
    public void insert(Commande c) {
        String requete = "insert into commande ( quantite_commande, id_user, id_article, date_commande, total_commande,etat_commande) values(,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
           pst.setInt(1, c.getQuantite_commande());
            pst.setInt(2,  c.getUser().getId_user());
            pst.setInt(3,  c.getArticle().getId_article());
           // pst.setDate(4, c.getDate_commande());
             pst.setFloat(5, c.getTotal_commande());
              pst.setString(6, c.getEtat_commande());
            pst.executeUpdate();
            System.out.println("commande ajouté!");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("commande non ajouté!");
        }

        

 
    }

///////////////////////////////////////////////CRUD SUPPRIMER commande /////////////////////////////////////////////////////////OK*
     @Override
    public void delete(Commande c) {
        try {
            String requete = "DELETE FROM Commande WHERE id_commande=?";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, c.getId_commande());
            pst.executeUpdate();
            System.out.println("Commande supprimé!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Commande non supprimé!");
        }
    }
    

    
    
///////////////////////////////////////////////CRUD MODIFIER ARTICLE /////////////////////////////////////////////////////////OK*
    @Override
    public void update(Commande c) {
        String requete = "UPDATE articles SET quantite_commande=?, id_user=?, id_article=?, date_commande=?, total_commande=?,etat_commande=?  WHERE id_commande=?";
        
        
       try {
            
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, c.getQuantite_commande());
            pst.setInt(2,  c.getUser().getId_user());
            pst.setInt(3,  c.getArticle().getId_article());
           // pst.setDate(4, c.getDate_commande());
             pst.setFloat(5, c.getTotal_commande());
              pst.setString(6, c.getEtat_commande());
              pst.setInt(7, c.getId_commande());
            pst.executeUpdate();
            System.out.println("commande " + c.getId_commande()+":" + " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("commande non modifié!");
        }

    }


///////////////////////////////////////////////CRUD Afficher ARTICLE BY ID/////////////////////////////////////////////////////////

    
   

    @Override
    public List<Commande> readAll() {
         List<Commande> list=new ArrayList<>();
            String requete="select * from commande ";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                UserService us =new UserService();
            User u =new User();
            u=us.readById(rs.getInt("id_user"));
             ServiceArticle sa =new ServiceArticle();
            Article a =new Article();
            a=sa.readById(rs.getInt("id_article"));
           
              Commande c=new Commande(rs.getInt("id_commande"),
                      rs.getInt("quantite_commande"),u,a,
                      
                      rs.getDate("date_commande"),
                      rs.getFloat("total_commande"),
                      rs.getString("etat_commande"));
                     

list.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGalerie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }

    @Override
    public Commande readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

    

