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
    //private User user;
    private Date date_commande;
    private float total_commande;
    private int quantite_article;

    public Commande() {
    }

    public Commande(int id_commande, Date date_commande, float total_commande, int quantite_article) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.total_commande = total_commande;
        this.quantite_article = quantite_article;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public float getTotal_commande() {
        return total_commande;
    }

    public void setTotal_commande(float total_commande) {
        this.total_commande = total_commande;
    }

    public int getQuantite_article() {
        return quantite_article;
    }

    public void setQuantite_article(int quantite_article) {
        this.quantite_article = quantite_article;
    }
   
    
    
    
    
    
}
