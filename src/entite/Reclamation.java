/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import java.util.Date ; 
import java.util.Objects ; 

public class Reclamation  {

    

    private int idr ; 
    private String titre ; 
    private String description ; 
    private String image ; 
    private Date dater ; 
    private int id_user ; 
    private int id_typer  ;
    private Etatreclamation etat ; 
    

public Reclamation() {
    }
 public Reclamation( String titre, String description, String image, Date dater, int id_user, int id_typer, Etatreclamation etat) {
   
    this.titre = titre;
        this.description = description;
        this.image = image;
        this.dater = dater;
        this.id_user = id_user;
        this.id_typer = id_typer;
        this.etat = etat;
    }

 public Reclamation(int idr, String titre, String description, String image, Date dater, int id_user, int id_typer, Etatreclamation etat) {
        this.idr = idr;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.dater = dater;
        this.id_user = id_user;
        this.id_typer = id_typer;
        this.etat = etat;
    }

   public int getIdr() {
        return idr;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Date getDater() {
        return dater;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_typer() {
        return id_typer;
    }

    public Etatreclamation getEtat() {
        return etat;
    }

   
    
    

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_typer(int id_typer) {
        this.id_typer = id_typer;
    }

    public void setEtat(Etatreclamation etat) {
        this.etat = etat;
    }
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idr;
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
        final Reclamation other = (Reclamation) obj;
        if (this.idr != other.idr) {
            return false;
        }
        return true;
    }
@Override
    public String toString() {
        return "Reclamation{" + "idr=" + idr + ", titre=" + titre + ", description=" + description + ", image=" + image + ", dater=" + dater + ", id_user=" + id_user + ", id_typer=" + id_typer + ", etat=" + etat + '}'+"\n";
    }
}