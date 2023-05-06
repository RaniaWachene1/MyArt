/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author ASUS
 */
public class Reponse {
    private int id;
    private String description;
    private String objet;
    private int idrec;
    private EtatReponse etat;

    public Reponse() {
    }

    public Reponse(String description, String objet, int idrec, EtatReponse etat) {
        this.description = description;
        this.objet = objet;
        this.idrec = idrec;
        this.etat = etat;
    }

    public Reponse(int id, String description, String objet, int idrec, EtatReponse etat) {
        this.id = id;
        this.description = description;
        this.objet = objet;
        this.idrec = idrec;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public int getIdrec() {
        return idrec;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }

    public EtatReponse getEtat() {
        return etat;
    }

    public void setEtat(EtatReponse etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", description=" + description + ", objet=" + objet + ", idrec=" + idrec + ", etat=" + etat + '}';
    }
    
}
