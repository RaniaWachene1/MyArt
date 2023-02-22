package service;

import java.sql.SQLException;
import java.util.List; 

public interface Iservice_1<T> {

        public void ajouter (T t) ; 
        public void modifier (T t, int id ) ; 
       public void supprimer(int id) throws Exception ; 
        public List<T> afficher () ; 
    
    
}
