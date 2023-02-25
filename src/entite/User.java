/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class User {
    
    private int id_user;
    private String nom_user ;
    private String prenom_user;
    private LocalDate date_naiss;
    private String email;
    private String pwd_user;
    private String sexe;
    private int tel_user;
    private String Img;
    private String adresse; 
   
 
    private Role Role;
   
  
   
   //******************************************************************************//

    public User() {
    }
   //******************************************************************************//

    public User(int id_user, String nom_user, String prenom_user, LocalDate date_naiss, String email, String pwd_user, String sexe, int tel_user, String Img, String adresse, Role role) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.date_naiss = date_naiss;
        this.email = email;
        this.pwd_user = pwd_user;
        this.sexe = sexe;
        this.tel_user = tel_user;
        this.Img = Img;
        this.adresse = adresse;
        this.Role = role;
    }
//***********************************************//
    public User(String nom_user, String prenom_user, LocalDate date_naiss, String email, String pwd_user, String sexe, int tel_user, String Img, String adresse, Role Role) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.date_naiss = date_naiss;
        this.email = email;
        this.pwd_user = pwd_user;
        this.sexe = sexe;
        this.tel_user = tel_user;
        this.Img = Img;
        this.adresse = adresse;
        this.Role = Role;
    }

   

    //******************************************************************************//
    public int getId_user() {
        return id_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public LocalDate getDate_naiss() {
        return date_naiss;
    }

 

  

    public String getEmail() {
        return email;
    }

    public String getPwd_user() {
        return pwd_user;
    }

    public String getSexe() {
        return sexe;
    }

    public int getTel_user() {
        return tel_user;
    }

    public String getImg() {
        return Img;
    }

    public String getAdresse() {
        return adresse;
    }

    public Role getRole() {
        return Role;
    }

    public User(int id_user) {
        this.id_user = id_user;
    }

   
  
   
    
//******************************************************************************//
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public void setDate_naiss(LocalDate date_naiss) {
        this.date_naiss = date_naiss;
    }

   

  

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd_user(String pwd_user) {
        this.pwd_user = pwd_user;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setTel_user(int tel_user) {
        this.tel_user = tel_user;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setRole(Role Role) {
        this.Role = Role;
    }

   

    

   
    
//******************************************************************************//

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", date_naiss=" + date_naiss + ", email=" + email + ", pwd_user=" + pwd_user + ", sexe=" + sexe + ", tel_user=" + tel_user + ", Img=" + Img + ", adresse=" + adresse + ", Role=" + Role + '}';
    }

    

  

   

   


   
   
   
   
   
    
    
    
}
