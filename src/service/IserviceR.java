/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface IserviceR<T> {
      public void ajouter (T t) ; 
        public void modifier (T t, int id ) ; 
       public void supprimer(int id) throws Exception ; 
        public List<T> afficher () ; 
}
