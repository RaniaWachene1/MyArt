/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myart;
import entite.Article;
import entite.Galerie;
import utils.DataSource;
import service.UserService;
import entite.User;
import service.RoleService;
import entite.Role;
import java.time.LocalDate;
import java.util.Date;
import service.ServiceArticle;
import service.ServiceGalerie;
/**
 *
 * @author rania
 */
public class MyArt {

//    /**
//     * @param args the command line arguments
//     */
  public static void main(String[] args) {
     // TODO code application logic here
     DataSource ds1 =DataSource.getInstance();
    System.out.println(ds1);
//     
  LocalDate ld=LocalDate.of(1999, 03, 06);
//     
//     
//
 Galerie g =new Galerie(10, "P");
        Galerie g1 =new Galerie(3, "Photographie");
Article a1 =new Article( 8,"p", "deschk bBVkjNV KJvn slkv nl_article",  "photo_article", "nom_artiste", 10, 10,g);
// Article a1 =new Article( "p", "deschk bBVkjNV KJvn slkv nl_article",  "photo_article", "nom_artiste", 10, 10,g);
  ServiceArticle pst=new ServiceArticle();
  
//   pst.insert(a1);
  // pst.deleteById(7);
  // pst.delete(a1);
  //  pst.update(a1);
  // pst.readById();
//  pst.readAll().forEach(System.out::println);
   
//  ServiceGalerie pst=new ServiceGalerie();
// 
//       pst.insert(g);
         // pst.delete(g);
         //  pst.readAll().forEach(System.out::println);
         //   pst.update(g1);
  
//Role r=new Role(1,"Admin");
//UserService pst =new UserService();
//User u1 =new User( "Admin", "admin", ld, "Admin@gmail.com", "admin", "femme", 00000, "Img", "adresse",r);
//////RoleService pst =new RoleService();
//
//pst.insert(u1);
  //pst.insert(u1);
////pst.readById(2);
////pst.readAll().forEach(System.out::println);
//pst.update(u1);
//
//  // RoleService r=new RoleService();
//  //Role role=new Role();
//  //role=r.readById(1);
//    //  System.out.println(role);
//    }
//
//  
}}
