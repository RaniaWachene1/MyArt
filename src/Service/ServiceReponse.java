/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entite.EtatReponse;
import entite.Etatreclamation;
import entite.Reclamation;
import entite.Reponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import util.Mysql;

/**
 *
 * @author ASUS
 */
public class ServiceReponse implements Iservice<Reponse>{
    Connection conn;
    public ServiceReponse(){
        conn=Mysql.getInstance().getConn();
    }
    @Override
    public void ajouter(Reponse t) {
        try {
            String query="INSERT INTO `reponse`(`description`, `objet`, `idrec`, `etat`) "
                    + "VALUES ('"+t.getDescription()+"','"+t.getObjet()+"','"+t.getIdrec()+"','"+t.getEtat()+"')";
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Reponse t, int id) {
        try {
            String query="UPDATE `reponse` SET `description`='"+t.getDescription()+"',`objet`='"+t.getObjet()+"',`idrec`='"+t.getIdrec()+"',`etat`='"+t.getEtat()+"' WHERE id="+id;
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) throws Exception {
        try {
            String query="DELETE FROM `reponse` WHERE id="+id;
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reponse> afficher() {
        List<Reponse> lr=new ArrayList<>();
        try {
            String query="SELECT * FROM `reponse`";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Reponse r=new Reponse();
                r.setEtat(EtatReponse.valueOf(rs.getString("etat")));
                r.setId(rs.getInt("id"));
                r.setIdrec(rs.getInt("idrec"));
                r.setObjet(rs.getString("objet"));
                r.setDescription(rs.getString("description"));
                
                lr.add(r);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;
    }
    public boolean checkSatisfaction(int idReclamation){
        List<Reponse> lr=afficher().stream().filter(rep->rep.getIdrec()==idReclamation).collect(Collectors.toList());
        for(Reponse r:lr){
            if(r.getEtat().equals(EtatReponse.Satisfied)){
                return true;
            }
            
        }
        return false;
    }
    
}
