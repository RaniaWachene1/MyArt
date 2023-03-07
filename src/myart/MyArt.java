/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myart;

import Service.ServiceTypeReclamation;
import Service.Servicereclamation;
import entite.Etatreclamation;
import entite.Reclamation;
import entite.TypeReclamation;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.FilterBadWord;

/**
 *
 * @author ASUS
 */
public class Myart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceTypeReclamation st=new ServiceTypeReclamation();
        Servicereclamation sr=new Servicereclamation();
        Reclamation r=new Reclamation("aaa", "qaa", "aa", new Date(2023-1900,2,12), 19, 1, Etatreclamation.TRAITE);
        TypeReclamation tr=new TypeReclamation("test2", "uuuu");
        try {
            //st.ajouter(tr);
            //st.modifier(tr, 2);
            //System.out.println(st.afficher());
            //st.supprimer(2);
            //sr.ajouter(r);
            //sr.modifier(r, 3);
            //sr.supprimer(8);
            //System.out.println(st.getAllNom());
            //System.out.println(FilterBadWord.filter("hello fucking world"));
            System.out.println(FilterBadWord.checkBadWords("fuck"));
        } catch (IOException ex) {
            Logger.getLogger(Myart.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("'hello world'");
        
                
    }
    
}
