/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author rania
 */
public class Article {
    private int id_article;
    private String titre_article;
    private String desc_article;
    private String photo_article;
    private String nom_artiste;
    private float prix_article;
    private int quantite_article;
    private int rate;
    private Galerie galerie;
    private User user;

   
    public Article(int id_article, String titre_article, String desc_article, String photo_article, String nom_artiste, float prix_article, int quantite_article, Galerie galerie) {
        this.id_article = id_article;
        this.titre_article = titre_article;
        this.desc_article = desc_article;
        this.photo_article = photo_article;
        this.nom_artiste = nom_artiste;
        this.prix_article = prix_article;
        this.quantite_article = quantite_article;
        this.galerie = galerie;
    }
    
public Article(int id_article, String titre_article, String desc_article, String nom_artiste, float prix_article, int quantite_article, Galerie galerie, User user) {
        this.id_article = id_article;
        this.titre_article = titre_article;
        this.desc_article = desc_article;
        
        this.nom_artiste = nom_artiste;
        this.prix_article = prix_article;
        this.quantite_article = quantite_article;
        this.galerie = galerie;
        this.user = user;
    }

    public Article(int id_article, String titre_article, String desc_article, String photo_article, String nom_artiste, float prix_article, int quantite_article) {
        this.id_article = id_article;
        this.titre_article = titre_article;
        this.desc_article = desc_article;
        this.photo_article = photo_article;
        this.nom_artiste = nom_artiste;
        this.prix_article = prix_article;
        this.quantite_article = quantite_article;
    }

 

    public Article(int id_article) {
        this.id_article = id_article;
    }
    

    public Article(int id_article, String titre_article, String desc_article, String photo_article, String nom_artiste, float prix_article, int quantite_article, Galerie galerie, User user) {
        this.id_article = id_article;
        this.titre_article = titre_article;
        this.desc_article = desc_article;
        this.photo_article = photo_article;
        this.nom_artiste = nom_artiste;
        this.prix_article = prix_article;
        this.quantite_article = quantite_article;
        this.galerie = galerie;
        this.user = user;
    }

    public Article(String titre_article, String desc_article, String photo_article, String nom_artiste, float prix_article, int quantite_article, Galerie galerie) {
        this.titre_article = titre_article;
        this.desc_article = desc_article;
        this.photo_article = photo_article;
        this.nom_artiste = nom_artiste;
        this.prix_article = prix_article;
        this.quantite_article = quantite_article;
        this.galerie = galerie;
    }

   //////////////////////////////////////////////////////////////////////////////////////////// 
    public Article() {
    }

    
   

    
///////////////////////////////////////////////////////////////////////////////////////////////
    public Galerie getGalerie() {
        return galerie;
    }

    public void setGalerie(Galerie galerie) {
        this.galerie = galerie;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "Article{" + "id_article=" + id_article + ", titre_article=" + titre_article + ", desc_article=" + desc_article + ", photo_article=" + photo_article + ", nom_artiste=" + nom_artiste + ", prix_article=" + prix_article + ", quantite_article=" + quantite_article + ", galerie=" + galerie + '}';
    }



   

   
    
}
