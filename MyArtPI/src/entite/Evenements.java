/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import service.Evenement_Crud;
import service.interfaceEvent;
import java.time.LocalDate;

/**
 *
 * @author WASSIM
 */
public class Evenements {

    

  private int id_event;
   private String nom_event;
    private String lieu_event;
          private String  date_event;

 
public Evenements() {
    }
 public Evenements(int id_event,String nom_event, String lieu_event, String date_event) {
     this.id_event = id_event;   
     this.nom_event = nom_event;
        this.lieu_event = lieu_event;
        this.date_event = date_event;
    }
   
    public Evenements(String nom_event, String lieu_event, String date_event) {
        this.nom_event = nom_event;
        this.lieu_event = lieu_event;
        this.date_event = date_event;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getLieu_event() {
        return lieu_event;
    }

    public void setLieu_event(String lieu_event) {
        this.lieu_event = lieu_event;
    }

    public String getDate_event() {
        return date_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    @Override
    public String toString() {
        return "Personne{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", lieu_event=" + lieu_event + ", date_event=" + date_event + '}';
    }

    public void getNom_event(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getLieu_event(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getDate_event(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}