/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entite.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
/**
 *
 * @author Acer
 */
public class RoleService implements InterService <Role>{
    
    private Connection conn;                        
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement ste; 
    
 public RoleService() {
        conn = DataSource.getInstance().getConnection();
    }
 //********************************insert******************************************//ok
    @Override
    public void insert(Role r) {
    String requete = "INSERT INTO `role`(`id_role`, `desc_role`) VALUES (?,?)";
        try {
   
         PreparedStatement pst= conn.prepareStatement(requete);
         
        pst.setInt(1, r.getId_role());
        pst.setString(2, r.getDesc_role());
        pst.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(RoleService.class.getName()).log(Level.SEVERE, null, ex);
    }     
    }
 
  //****************************************delete*********************************************//ok

 
    @Override
    public void delete(Role r) {
         try {
        pst = conn.prepareStatement("delete from Role where id_role= ?");
     
        pst.setInt(1, r.getId_role());
        pst.executeUpdate();
    } 
         catch (SQLException ex) {
         Logger.getLogger(RoleService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
//***************************************** update********************************************//OK
    @Override
   
    
    public void update(Role r) {
        String requete = "UPDATE role SET Desc_role=? WHERE id_role=?";
        
        
       try {
            
            PreparedStatement pst = conn.prepareStatement(requete);
         
          pst.setString(1, r.getDesc_role());
            pst.setInt(2, r.getId_role());
            pst.executeUpdate();
            System.out.println("Id_role" + r.getId_role()+":" + " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("role non modifié!");
        }
    
    }
//********************************************readAll*****************************************//ok
    @Override
    public List<Role> readAll() {
         List<Role> list = new ArrayList<>();
       String requete= "select * from role ";
      try {
        ste = conn.createStatement();                  
        rs=ste.executeQuery("select * from role");                         
        while(rs.next()){
        Role r = new Role(rs.getInt("id_role"),rs.getString("desc_role"));
            list.add(r);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(RoleService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
//***************************************readById**********************************************//no
    @Override
    public Role readById(int Id_role) {
          Role r = new Role();
   try {
       pst = conn.prepareStatement("select * from role where Id_role=?"); 
       pst.setInt(1, Id_role);
        rs =pst.executeQuery();
        if (rs.next()) {
      r.setId_role(rs.getInt(1));  
        r.setDesc_role(rs.getString(2));
		}
   } catch (SQLException ex) {
       Logger.getLogger(RoleService.class.getName()).log(Level.SEVERE, null, ex);
   }
   return r;
   
  }
    
   
    
    
    
    
    
    
    
    
    
    
}
    
   
