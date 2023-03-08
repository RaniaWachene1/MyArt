/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author rania
 */
public class Galerie {
    private int id_galerie;
    private String titre_galerie;
    private List<Galerie> galeries;

    public Galerie(List<Galerie> galeries) {
        this.galeries = galeries;
    }

    public Galerie() {
    }

    public Galerie(int id_galerie, String titre_galerie) {
        this.id_galerie = id_galerie;
        this.titre_galerie = titre_galerie;
    }

    public Galerie(String titre_galerie) {
        this.titre_galerie = titre_galerie;
    }

    
    public int getId_galerie() {
        return id_galerie;
    }

    public void setId_galerie(int id_galerie) {
        this.id_galerie = id_galerie;
    }

    public String getTitre_galerie() {
        return titre_galerie;
    }

    public void setTitre_galerie(String titre_galerie) {
        this.titre_galerie = titre_galerie;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Galerie other = (Galerie) obj;
        if (this.id_galerie != other.id_galerie) {
            return false;
        }
        return Objects.equals(this.titre_galerie, other.titre_galerie);
    }
    

    @Override
    public String toString() {
        return  titre_galerie + ' ';
    }

}