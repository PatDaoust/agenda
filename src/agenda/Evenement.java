/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

import java.util.Objects;

/**
 *
 * @author catal
 */
public class Evenement {

    String nom;
    Date debut;
    Date fin;
    //La durée d’un évènement s’étend entre sa date de début incluse et sa date de fin incluse.

    public Evenement(String nom, Date debut, Date fin) throws ErreurEvenement {

        setNom(nom);
        setDebut(debut);
        //sa date de début doit précédersa date de fin.
        if (fin.apres(debut)) {
            setFin(fin);
        } else {
            throw new ErreurEvenement("la date de début doit précédersa date de fin");
        }

    }

    public String getNom() {
        return nom;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setNom(String nom) throws ErreurEvenement {
        //Le nom d’un évènement ne doit pas être vide.
        if (nom.equals("")) {
            throw new ErreurEvenement("Le nom d’un évènement ne doit pas être vide");
        } else {
            this.nom = nom;
        }

    }

    public void setDebut(Date debut) throws ErreurEvenement {
        //Un évènement ne peut pas avoir une durée nulle
        if (debut != null) {
            this.debut = debut;
        } else {
            throw new ErreurEvenement("Un évènement ne peut pas avoir une durée nulle");
        }

    }

    public void setFin(Date fin) throws ErreurEvenement {
        //Un évènement ne peut pas avoir une durée nulle
        if (debut != null) {
            this.fin = fin;
        } else {
            throw new ErreurEvenement("Un évènement ne peut pas avoir une durée nulle");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nom);
        hash = 19 * hash + Objects.hashCode(this.debut);
        hash = 19 * hash + Objects.hashCode(this.fin);
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
        final Evenement other = (Evenement) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.debut, other.debut)) {
            return false;
        }
        return Objects.equals(this.fin, other.fin);
    }

    public boolean overlaps(Evenement other) {
        ////check if events chevaucher
        if (!debut.apres(other.getFin()) && fin.apres(other.getDebut())) {
            // The events overlap
            return true;
        } else {
            // The events do not overlap
            return false;
        }
    }

    public boolean overlaps(Date otherDate) throws ErreurDate {
        //int jour, int mois, int annee, int heure, int minute)
        Date otherStart = new Date(
                otherDate.getJour(), otherDate.getMois(), otherDate.getAnnee(),
                otherDate.getHeure(), otherDate.getMinute()
        );
        Date otherEnd = new Date(
                otherDate.getJour(), otherDate.getMois(), otherDate.getAnnee(),
                otherDate.getHeure(), otherDate.getMinute() + 1
        );
        return (!(debut.apres(otherEnd)) && fin.apres(otherStart));
    }

    @Override
    public String toString() {
        return "Evenement{" + "nom=" + nom + ", debut=" + debut + ", fin=" + fin + '}';
    }

}
