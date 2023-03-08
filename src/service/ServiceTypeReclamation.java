/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Etatreclamation;
import entite.Reclamation;
import entite.TypeReclamation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import utils.DataSource;


/**
 *
 * @author ASUS
 */
public class ServiceTypeReclamation implements IserviceR<TypeReclamation> {
    
Connection conn;
    public ServiceTypeReclamation(){
        conn=DataSource.getInstance().getConnection();
    }
    @Override
    public void ajouter(TypeReclamation t) {
        try {
            String query="INSERT INTO `typereclamation`( `nom`, `description`) "
                    + "VALUES ('"+t.getNom()+"','"+t.getDescription()+"')";
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(TypeReclamation t, int id) {
        try {
            
            String query="UPDATE `typereclamation` SET `nom`='"+t.getNom()+"',`description`='"+t.getDescription()+"' WHERE idtr="+id;
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
@Override
    public void supprimer(int id) throws Exception{
        
            String query="DELETE FROM `typereclamation` WHERE idtr="+id;
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        
    }

    @Override
    public List<TypeReclamation> afficher() {
        List<TypeReclamation> lr=new ArrayList<>();
        try {
            String query="SELECT * FROM `typereclamation`";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                TypeReclamation r=new TypeReclamation();
                r.setDescription(rs.getString("description"));
                r.setIdtr(rs.getInt("idtr"));
                r.setNom(rs.getString("nom"));
                lr.add(r);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;
    }
    public int getTypeByNom(String nom){
        TypeReclamation t=afficher().stream().filter(tr->tr.getNom().equals(nom)).findFirst().orElse(null);
        if(t!=null){
            return t.getIdtr();
        }
        else{
            return 0;
        }
    }
    public List<String> getAllNom(){
        List<String> ln=afficher().stream().map(tr->tr.getNom()).collect(Collectors.toList());
        return ln;
    }
    public String getTypeNomById(int id){
        TypeReclamation t=afficher().stream().filter(tr->tr.getIdtr()==id).findFirst().orElse(null);
        if(t!=null){
            return t.getNom();
        }
        else{
            return "";
        }
    }
    
}
