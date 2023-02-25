/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author rania
 */
public class Panier {
    private int id_panier;
    private User user;
    private Article article;
    private int qte;

    public Panier() {
    }
    

    public Panier(int id_panier, User user, Article article, int qte ) {
        this.id_panier = id_panier;
        this.user = user;
        this.article = article;
        this.qte = qte;
    }

    public Panier(User user, Article article, int qte) {
        this.user = user;
        this.article = article;
        this.qte = qte;
    }
    

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", user=" + user + ", article=" + article + ", qte=" + qte + '}';
    }

   

   

   

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
        final Panier other = (Panier) obj;
        return this.id_panier == other.id_panier;
    }
    
    
    

    
}