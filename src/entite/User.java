/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import service.Mailling;
import service.UserService;

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
    private Boolean block;
    private Boolean unblock;
    
    

    public User(int id_user, String nom_user, String prenom_user,  String email, String pwd_user, String sexe, int tel_user, String Img, String adresse) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
       
        this.email = email;
        this.pwd_user = pwd_user;
        this.sexe = sexe;
        this.tel_user = tel_user;
        this.Img = Img;
        this.adresse = adresse;
    }

    public User(int id_user, String nom_user, String prenom_user, String email, String sexe, int tel_user, String Img) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.email = email;
        this.sexe = sexe;
        this.tel_user = tel_user;
        this.Img = Img;
    }
  
   
  
   
   //******************************************************************************//

    public User() {
        
    }

    public User(int id_user) {
        this.id_user = id_user;
    }
    public User(String email) {
        this.email = email;
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
//********************************************************************************//
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

    public User(String text, String text0, String text1, String text2, Object value, int parseInt, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

//*********************************************************************************//
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

    public Boolean getBlock() {
        return block;
    }

    public void setBlock(Boolean block) {
        this.block = block;
    }

    public Boolean getUnblock() {
        return unblock;
    }

    public void setUnblock(Boolean unblock) {
        this.unblock = unblock;
    }

 
    
//******************************************************************************//

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", date_naiss=" + date_naiss + ", email=" + email + ", pwd_user=" + pwd_user + ", sexe=" + sexe + ", tel_user=" + tel_user + ", Img=" + Img + ", adresse=" + adresse + ", Role=" + Role + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
//**************************************************************************************//
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

 


/***************************************************************************************/

   public static String encrypMD5 (String data) {
try{
MessageDigest md =MessageDigest.getInstance ("MD5");
byte[] messageDigst = md.digest (data.getBytes () );
BigInteger num = new BigInteger (1, messageDigst);
String hashtext = num.toString (16);
while (hashtext.length () < 32) {
hashtext = "0" + hashtext;
}
return hashtext;} 
catch (NoSuchAlgorithmException e) {
throw new RuntimeException (e);
}

}
   /*****************************************************/
    public Integer rondomcode()
    {
Random rand=new Random();
int randomcode=rand.nextInt(999999);
 return randomcode; 
    }
   
    public void forgetpass(String email)
{
UserService sp = new UserService();
Mailling m=new Mailling();
int code=rondomcode();

if (sp.checkEmail(email).contains(email))
{
    Scanner s = new Scanner(System.in);
    m.sendemail(email,code);
  System.out.println("Enter code");
  int verifcode = s.nextInt();
  if (code == verifcode)
  {
      System.out.println("Enter new passwoed");
      String newpassword = s.next();
      if(!sp.Updatepassword(newpassword,email))
     {
         System.out.println("passwoed updated");
     }
     else
     {
         System.out.println("passwoed wasn't updated");
     }
      
  }
  else
  {
        System.out.println("Rong code");
  }

}
else
System.out.println(email +" was not found in our database\ntry again");

}
   
       public boolean signup(String mailorusername,String password) {
           boolean check;
        UserService sp = new UserService();
        List<String> list;
        list = new ArrayList<>();
        list.add(mailorusername);list.add(encrypMD5(password));
       if (sp.checksignin(mailorusername,encrypMD5(password)).equals(list))
{
      check=true;
    System.out.println("correct credentials");
   
}    
       else
       {
           check=false;
           System.out.println("correct credentials needed");

       }
       return check;
    }
    
   
}
  


   