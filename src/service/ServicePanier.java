/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entite.Article;
import entite.Panier;
import entite.User;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author rania
 */
public class ServicePanier implements IService<Panier> {
    private Connection conn;
    
     public ServicePanier() {
        conn = DataSource.getInstance().getCnx();
        
    }
///////////////////////////////////////////////////////////////////////
    @Override
    public void insert(Panier p) {
        String requete = "INSERT INTO panier(id_article, id_user,qte) value(?,?,?)";
        
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, p.getArticle().getId_article());
            pst.setInt(2, p.getUser().getId_user());
            pst.setInt(3, p.getQte());
            
            
            pst.executeUpdate();
            System.out.println(" succes");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("echec!");
        }
        
    }

    @Override
    public void delete(Panier p) {
         try {
            String requete = "DELETE FROM panier WHERE id_panier=?";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, p.getId_panier());
            pst.executeUpdate();
            System.out.println(" supprimé!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("e non supprimé!");
        }
    }

    @Override
    public void update(Panier p) {
         String requete = "UPDATE panier SET qte=? WHERE id_panier=?";
        
        
       try {
            
            PreparedStatement pst = conn.prepareStatement(requete);
           pst.setInt(1, p.getQte());
           pst.setInt(2, p.getId_panier());
            pst.executeUpdate();
            System.out.println( " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println(" non modifié!");
        }
    }

    @Override
    public List<Panier> readAll() {
        
         List<Panier> list=new ArrayList<>();
            String requete="select * from panier ";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                ServiceArticle sa =new ServiceArticle();
            Article a =new Article();
            a=sa.readById(rs.getInt("id_galerie"));
            UserService us =new UserService();
            User u =new User();
            u=us.readById(rs.getInt("id_user"));
              Panier p=new Panier(rs.getInt("id_panier"),u,a,rs.getInt("qte"));

list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGalerie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; 
    }

    @Override
    public Panier readById(int id_panier) {
         Panier p=new Panier();
        PreparedStatement pst;
        try {
            String requete = "SELECT  FROM panier WHERE id_panier= ?";
         pst = conn.prepareStatement(requete);
       pst.setInt(1,id_panier);
        ResultSet rst = pst.executeQuery(requete);
        while (rst.next()) {
            ServiceArticle sa =new ServiceArticle();
            Article a =new Article();
            a=sa.readById(rst.getInt("id_article"));
           p.setArticle( a);
           
           UserService us =new UserService();
            User u =new User();
            u=us.readById(rst.getInt("id_user"));
             p.setUser( u);
             
           p.setId_panier(rst.getInt( "id_panier"));
            
        }
    }
         catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    }

 


     
