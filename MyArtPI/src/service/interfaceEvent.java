/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entite.Evenements;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author WASSIM
 */

public interface interfaceEvent<Evenements> {
    
    public void ajouterEvent (Evenements Evenements); 
    public void afficherEvent (Evenements Evenements);
    public void supprimerEvent(Evenements Evenements);
    public void modifierEvent(Evenements Evenements);
    List<Evenements>afficherEvent();
          
    
}
