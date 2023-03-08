/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Etatreclamation;
import entite.Reclamation;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import utils.FilterBadWord;

/**
 *
 * @author ASUS
 */
public class Servicereclamation implements IserviceR<Reclamation>{
    Connection conn;
    public Servicereclamation(){
        conn=DataSource.getInstance().getConnection();
    }
    @Override
    public void ajouter(Reclamation t) {
        try {
            String query="";
            try {
                query = "INSERT INTO `reclam`"
                        + "(`titre`, `description`,"
                        + " `image`, `dater`, `id_user`,"
                        + " `idtyper`, `etat`) VALUES "
                        + "('"+FilterBadWord.filter(t.getTitre())+"',"
                        + "'"+FilterBadWord.filter(t.getDescription())+"','"+t.getImage()+"',"
                        + "'"+t.getDater()+"','"+t.getId_user()+"',"
                        + "'"+t.getId_typer()+"','"+t.getEtat()+"')";
            } catch (IOException ex) {
                Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
            }
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Reclamation t, int id) {
        try {
            String query="";
            try {
                query = "UPDATE `reclam` SET `titre`='"+FilterBadWord.filter(t.getTitre())+"',"
                        + "`description`='"+FilterBadWord.filter(t.getDescription())+"',"
                        + "`image`='"+t.getImage()+"',"
                        + "`dater`='"+t.getDater()+"',"
                        + "`id_user`='"+t.getId_user()+"',"
                        + "`idtyper`='"+t.getId_typer()+"',"
                        + "`etat`='"+t.getEtat()+"' WHERE idr="+id;
            } catch (IOException ex) {
                Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
            }
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String query="DELETE FROM `reclam` WHERE idr="+id;
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reclamation> afficher() {
        List<Reclamation> lr=new ArrayList<>();
        try {
            String query="SELECT * FROM `reclam`";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Reclamation r=new Reclamation();
                r.setDater(rs.getDate("dater"));
                r.setDescription(rs.getString("description"));
                r.setEtat(Etatreclamation.valueOf(rs.getString("etat")));
                r.setId_typer(rs.getInt("idtyper"));
                r.setId_user(rs.getInt("id_user"));
                r.setImage(rs.getString("image"));
                r.setTitre(rs.getString("titre"));
                r.setIdr(rs.getInt("idr"));
                lr.add(r);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;
    }
    public Reclamation getById(int id){
        return afficher().stream().filter(r->r.getIdr()==id).findAny().orElse(null);
    }
    
}
