
/**
 *
 * @author WASSIM
 */

    
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;
import entite.Evenements;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Meriem
 */

public class Evenement_Crud implements interfaceEvent<Evenements>{

    Connection cnx1;
    public Evenement_Crud() {
        cnx1=MyConnection.getInstance().getCnx();
    }

    @Override
    public void ajouterEvent(Evenements Evenements) {
        String requete = "insert into evenement (nom_event,lieu_event,date_event) values "
                + "('" + Evenements.getNom_event() + "','" + Evenements.getLieu_event() + "'," + Evenements.getDate_event() + ")";
        try {
            Statement st = cnx1.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(Evenement_Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
   
   /* public void insertPst(Personne p) {
        String requete = "insert into personne(nom,prenom,age) values(?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setInt(3, p.getAge());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

   
    
    
    
    
    
    
    
    
    
    
  
   /** @Override
    public void ajouterEvent(Evenements Evenements){
        try {
            
            String requete="INSERT INTO evenements(`id_event`, `nom_event`, `lieu_event`, `date_event`) VALUES (?,?,?,?)";
            PreparedStatement pst2=cnx1.prepareStatement(requete);
            //  LocalDate date_event = Evenements.getDate_event();
            //java.sql.Date sqlDate_event = java.sql.Date.valueOf(date_event);
            pst2.setInt(1, Evenements.getId_event());
            pst2.setString(2, Evenements.getNom_event());
            pst2.setString(3, Evenements.getLieu_event());
            pst2.setString(4, Evenements.getDate_event());
           // pst2.setDate(4, sqlDate_event);
            
     // LocalDate     
            pst2.executeUpdate();
            System.out.println("Evenement ajouté avec succès");//}

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
    }*/
    
     @Override
    public void supprimerEvent(Evenements Evenements){
        try {
            String requete="DELETE FROM evenement WHERE `id_event`=?";
            PreparedStatement pst=cnx1.prepareStatement(requete);
            pst.setInt(1, Evenements.getId_event());
            pst.executeUpdate();
            System.out.println("Evenement supprimé avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

     @Override
    public void modifierEvent(Evenements Evenements) {
        try {
            Statement ste = cnx1.createStatement();
            String req = "UPDATE `evenement` SET `nom_event`='"+Evenements.getNom_event()+"',`lieu_event`='"+Evenements.getLieu_event()+"',`date_event`='"+Evenements.getDate_event()+"' WHERE `id_event` = '"+Evenements.getId_event()+"'";
            ste.executeUpdate(req);
            ste.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
            
       @Override
    public List<Evenements> afficherEvent() {
        List<Evenements> event_list = new ArrayList<>();
        try {
            Statement ste = cnx1.createStatement();
            String req = "SELECT * FROM evenement";
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                Evenements event = new Evenements();
                event.setId_event(res.getInt(1));
                event.setNom_event(res.getString(2));
                event.setLieu_event(res.getString(3));
                event.setDate_event(res.getString(4));
                
                event_list.add(event);
            }
            ste.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return event_list;

    }     
    
    
   

    @Override
    public void afficherEvent(Evenements Evenements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
     
     
    
    
    
    
    
    
    
    
    
    
}
