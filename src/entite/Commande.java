/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import java.util.Date;

/**
 *
 * @author rania
 */
public class Commande {
     private int id_commande;
     private int quantite_commande;
    private User user;
    private Article article;
    private Date date_commande;
    private float total_commande;
    private String etat_commande;
    

    public Commande() {
    }

    public Commande(int quantite_commande, User user, Article article, Date date_commande, float total_commande, String etat_commande) {
        this.quantite_commande = quantite_commande;
        this.user = user;
        this.article = article;
        this.date_commande = date_commande;
        this.total_commande = total_commande;
        this.etat_commande = etat_commande;
    }

    
    public Commande(int id_commande, int quantite_commande, User user, Article article, Date date_commande, float total_commande, String etat_commande) {
        this.id_commande = id_commande;
        this.quantite_commande = quantite_commande;
        this.user = user;
        this.article = article;
        this.date_commande = date_commande;
        this.total_commande = total_commande;
        this.etat_commande = etat_commande;
    }

    public String getEtat_commande() {
        return etat_commande;
    }

    public void setEtat_commande(String etat_commande) {
        this.etat_commande = etat_commande;
    }

    
    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getQuantite_commande() {
        return quantite_commande;
    }

    public void setQuantite_commande(int quantite_commande) {
        this.quantite_commande = quantite_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
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

    public float getTotal_commande() {
        return total_commande;
    }

    public void setTotal_commande(float total_commande) {
        this.total_commande = total_commande;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", quantite_commande=" + quantite_commande + ", user=" + user + ", article=" + article + ", date_commande=" + date_commande + ", total_commande=" + total_commande + ", etat_commande=" + etat_commande + '}';
    }



    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Commande other = (Commande) obj;
        return this.id_commande == other.id_commande;
    }

   
    
    
    
    
}
