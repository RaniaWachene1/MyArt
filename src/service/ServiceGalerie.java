/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import entite.Galerie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author rania
 */

public class ServiceGalerie implements IService<Galerie>{
 private Connection conn;

    public ServiceGalerie() {
        conn = DataSource.getInstance().getCnx();
        
    }
    ///////////////////////////////////////////////CRUD AJOUTER GALERIE ///////////////////////////////////////////////////////// OK*
 @Override
    public void insert(Galerie g) {
        String requete = "insert into galeries (id_galerie,titre_galerie) values(?,?)";
        try {
           PreparedStatement pst = conn.prepareStatement(requete);
           pst.setInt(1, g.getId_galerie());
           pst.setString(2, g.getTitre_galerie());
           pst.executeUpdate();
           System.out.println("Gaterie ajoute !");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceArticle.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Gaterie non ajoute !");
        } 
}

    
    ///////////////////////////////////////////////CRUD SUPPRIMER ARTICLE /////////////////////////////////////////////////////////OK*
    @Override
    public void delete(Galerie g) {
        try {
            String requete = "DELETE FROM galeries WHERE id_galerie=?";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, g.getId_galerie());
            
            pst.executeUpdate();
            System.out.println("galerie supprimé!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
             System.out.println("galerie non supprimé!");
        }
    }
    ///////////////////////////////////////////////CRUD SUPPRIMER GALERIE BY ID /////////////////////////////////////////////////////////OK*
       public void deleteById(int id_galerie ) {
        try {
            String requete = "DELETE  FROM galeries WHERE id_galerie=?";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, id_galerie);
            
            pst.executeUpdate();
            System.out.println("galerie supprimé!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
             System.out.println("galerie non supprimé!");
        }
    }

    ///////////////////////////////////////////////CRUD MODIFIER GALERIE /////////////////////////////////////////////////////////
    @Override
    public void update(Galerie g) {
      String requete = "UPDATE  galeries SET titre_galerie=? WHERE id_galerie=?";
        try {
            System.out.println("updating    "+g.getTitre_galerie());
            PreparedStatement pst = conn.prepareStatement(requete);
             pst.setInt(2, g.getId_galerie());
            pst.setString(1, g.getTitre_galerie());
            pst.executeUpdate();
            System.out.println("galerie modifié!");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceGalerie.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("galerie non modifié!");
        }
    }
    
    
///////////////////////////////////////////////CRUD Afficher GALERIE /////////////////////////////////////////////////////////OK*
    @Override
    public List<Galerie> readAll() {
        List<Galerie> list=new ArrayList<>();
            String requete="select * from galeries";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Galerie g=new Galerie(rs.getInt("id_galerie"),rs.getString("titre_galerie") );
                list.add(g);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGalerie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }

    ///////////////////////////////////////////////CRUD Afficher par id GALERIE /////////////////////////////////////////////////////////NOK*
    @Override
    public Galerie readById(int id_galerie) {
       
        Galerie g = new Galerie();
        
    try {
         String requete = "SELECT * FROM galeries WHERE id_galerie= ? ";
         PreparedStatement pst;
         pst = conn.prepareStatement(requete);
         pst.setInt(1, id_galerie);
         ResultSet rst = pst.executeQuery();
        
        while (rst.next()) {
            g.setId_galerie(rst.getInt("id_galerie"));
            g.setTitre_galerie(rst.getString("titre_galerie"));
	}
    } catch (SQLException ex) {
        Logger.getLogger(ServiceGalerie.class.getName()).log(Level.SEVERE, null, ex);
    }
    return g;
}
  public int getgalerieFromName(String titre){
      int i=0;
      try {
            String requete = "Select *  FROM galeries WHERE titre_galerie=?";
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setString(1, titre);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {   System.out.println("Galierie Trouve");
                i= rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
             System.out.println("galerie inExistenteé!");
        }
      return i;
  
    }
}

 
        
      
      

   
