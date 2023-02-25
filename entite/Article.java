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
public class Article {
    private int id_article;
    private String titre_article;
    private String desc_article;
    private Date date_article;
    private String photo_article;
    private String nom_artiste;
    private int likes_article;
    private float prix_article;
    private int quantite_article;
    private int id_galerie;

    public Article() {
    }

    public Article(int id_article, String titre_article, String desc_article, Date date_article, String photo_article, String nom_artiste, int likes_article, float prix_article, int quantite_article, int id_galerie) {
        this.id_article = id_article;
        this.titre_article = titre_article;
        this.desc_article = desc_article;
        this.date_article = date_article;
        this.photo_article = photo_article;
        this.nom_artiste = nom_artiste;
        this.likes_article = likes_article;
        this.prix_article = prix_article;
        this.quantite_article = quantite_article;
        this.id_galerie = id_galerie;
    }

   
    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getTitre_article() {
        return titre_article;
    }

    public void setTitre_article(String titre_article) {
        this.titre_article = titre_article;
    }

    public String getDesc_article() {
        return desc_article;
    }

    public void setDesc_article(String desc_article) {
        this.desc_article = desc_article;
    }

    public Date getDate_article() {
        return date_article;
    }

    public void setDate_article(Date date_article) {
        this.date_article = date_article;
    }

    public String getPhoto_article() {
        return photo_article;
    }

    public void setPhoto_article(String photo_article) {
        this.photo_article = photo_article;
    }

    public String getNom_artiste() {
        return nom_artiste;
    }

    public void setNom_artiste(String nom_artiste) {
        this.nom_artiste = nom_artiste;
    }

    public int getLikes_article() {
        return likes_article;
    }

    public void setLikes_article(int likes_article) {
        this.likes_article = likes_article;
    }

    public float getPrix_article() {
        return prix_article;
    }

    public void setPrix_article(float prix_article) {
        this.prix_article = prix_article;
    }

    public int getQuantite_article() {
        return quantite_article;
    }

    public void setQuantite_article(int quantite_article) {
        this.quantite_article = quantite_article;
    }

    public int getId_galerie() {
        return id_galerie;
    }

    public void setId_galerie(int id_galerie) {
        this.id_galerie = id_galerie;
    }

    @Override
    public String toString() {
        return "Article{" + "id_article=" + id_article + ", titre_article=" + titre_article + ", desc_article=" + desc_article + ", date_article=" + date_article + ", photo_article=" + photo_article + ", nom_artiste=" + nom_artiste + ", likes_article=" + likes_article + ", prix_article=" + prix_article + ", quantite_article=" + quantite_article + ", id_galerie=" + id_galerie + '}';
    }
    
}
