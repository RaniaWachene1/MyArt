/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entite.User;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;


public class UserService implements IService <User>{
       
private Connection conn;
private Statement ste;                          
private PreparedStatement pst;
private ResultSet rs;

    public UserService() { 
       conn = DataSource.getInstance().getCnx();
    }
 @Override
    public void insert(User t) {
         String requete = "insert into user (id_user,nom_user,prenom_user)values (?,?,?);";
        try {
   
         PreparedStatement pst = conn.prepareStatement(requete);
         
        pst.setInt(1, t.getId_user());
        pst.setString(2, t.getNom_user());
        pst.setString(3, t.getPrenom_user());
        
        
        pst.executeUpdate();
          System.out.println("user ajoute");
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("user non ajoute");
    }           
        }

//    @Override
//    public void insert(User t) {
//         String requete = "insert into user (id_user,nom_user,prenom_user,role,date_naiss,email,pwd_user,sexe,tel_user,Img,adresse)values (?,?,?, ?,? ,?, ?, ?,? ,?, ?);";
//        try {
//   
//         PreparedStatement pst = conn.prepareStatement(requete);
//         
//        pst.setInt(1, t.getId_user());
//        pst.setString(2, t.getNom_user());
//        pst.setString(3, t.getPrenom_user());
//        pst.setString(4, t.getRole());
//        pst.setString(5, t.getDate_naiss());
//        pst.setString(6, t.getEmail());
//        pst.setString(7, t.getPwd_user());
//        pst.setString(8, t.getSexe());
//        pst.setInt(9, t.getTel_user());
//        pst.setString(10, t.getImg());
//        pst.setString(11, t.getAdresse());
//        
//        pst.executeUpdate();
//          System.out.println("user ajoute");
//    } catch (SQLException ex) {
//        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println("user non ajoute");
//    }           
//        }
    
//******************************************************************************//
    public void delete(int id_user) {
          
    try {
        pst = conn.prepareStatement("delete from user where id_user= ?");
        pst.setInt(1,id_user);
        pst.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
//******************************************************************************//
    @Override
    public void update(User t) {
        try {
        pst = conn.prepareStatement("update user set nom_user= ?,prenom_user= ?,role= ?,date_naiss= ?,email= ?,pwd_user= ?,sexe= ?,tel_user= ?,Img= ?,adresse = ? where id_user = ?;");
          pst.setInt(1, t.getId_user());
        pst.setString(2, t.getNom_user());
        pst.setString(3, t.getPrenom_user());
        pst.setString(4, t.getRole());
        pst.setString(5, t.getDate_naiss());
        pst.setString(6, t.getEmail());
        pst.setString(7, t.getPwd_user());
        pst.setString(8, t.getSexe());
        pst.setInt(9, t.getTel_user());
        pst.setString(10, t.getImg());
        pst.setString(11, t.getAdresse());
          
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }
 //******************************************************************************//
    
    @Override
    public List<User> readAll() {
        List<User> list = new ArrayList<>();
       String requete="select * from user";
      try {
        ste = conn.createStatement();                  
        rs=ste.executeQuery(requete);                         
        while(rs.next()){
           User u = new User (rs.getInt("id_user"),rs.getString("nom_user"),rs.getString("prenom_user"));
            list.add(u);
        }   
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
//    @Override
//    public List<User> readAll() {
//        List<User> list = new ArrayList<>();
//       String requete="select * from user";
//      try {
//        ste = conn.createStatement();                  
//        rs=ste.executeQuery(requete);                         
//        while(rs.next()){
//           User u = new User (rs.getInt("id_user"),rs.getString("nom_user"),rs.getString("prenom_user"),rs.getString("role"),rs.getString("date_naiss"),rs.getString("email"),rs.getString("pwd_user"),rs.getString("sexe"),rs.getInt("tel_user"),rs.getString("Img"),rs.getString("adresse"));
//            list.add(u);
//        }   
//    } catch (SQLException ex) {
//        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return list;
//}
//******************************************************************************//


    @Override
    public User readById(int id) {
          User u = new User();
    try {
        pst = conn.prepareStatement("select id_user,nom_user,prenom_user,role,date_naiss,email,pwd_user,sexe,tel_user,Img,adresse from utilisateur where id_user=?");
       
        rs=pst.executeQuery();
        while (rs.next()) {
        u.setId_user(rs.getInt("id_user"));  
        u.setNom_user(rs.getString("nom_user"));
	u.setPrenom_user(rs.getString("prenom_user"));
	u.setRole(rs.getString("role"));
        u.setDate_naiss(rs.getString("date_naiss")); 
        u.setEmail(rs.getString("email")); 
        u.setPwd_user(rs.getString("pwd_user")); 
        u.setSexe(rs.getString("sexe"));
        u.setTel_user(rs.getInt("tel_user"));
        u.setImg(rs.getString("Img"));
        u.setAdresse(rs.getString("adresse"));
	}
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return u;
    }

    @Override
    public void delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        }
  

   

