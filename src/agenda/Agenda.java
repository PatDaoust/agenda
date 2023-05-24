/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenda;

import java.util.ArrayList;

/**
 *
 * @author catal
 */
public class Agenda {

    ArrayList<Evenement> evenments = new ArrayList<Evenement>();

    public Agenda() {
    }

    public boolean ajouter(Evenement e) {
        //ajouter  un évènement d’un agenda
        //Les évènements d’un agenda doivent tous avoir des noms différents
        //et ne doivent pas se chevaucher
        //L’ajout d’un évènement renvoie un booléen permettant de savoir si l’ajout a été effectué

        //iterate evenments
        for (Evenement evenment : evenments) {
            //check name, if any match e.nom, return false
            if (evenment.nom.equals(e.nom)) {
                return false;
            }
            //check if events are same time. if any match, return false
            if (evenment.overlaps(e)) {
                return false;
            }
        }
        //none of the events match, add e to evenments and return true
        evenments.add(e);
        return true;
    }

    public boolean supprimer(String nom) {
        //supprimer un évènement d’un agenda
        //La supression d’un évènement renvoie un booléen permettant de savoir si l’ajout a été effectué
        for (Evenement evenment : evenments) {
            //check name, if any match e.nom, return false
            if (evenment.nom.equals(nom)) {
                //remove event
                evenments.remove(evenment);
                return true;
            }
        }
        return false;
    }

    public String chercherEvenement(Date d) throws ErreurDate {
        //chercher quel évènement a lieu à une date donnée
        //La recherche d’un évènement à une certaine date renvoie le nom de l’évènement prévu s’il existe,
        //le mot vide sinon.
        //iterate evenments
        for (Evenement evenment : evenments) {
            //check id date overlaps, if yes return event,nom
            if (evenment.overlaps(d)) {
                return evenment.nom;
            }
        }
        //l’évènement prévu n'existe pas
        return "vide";
    }

    public Date dateDebut(String nom) throws ErreurAgenda {
        //connaitre la date de début d’un évènement prévu par son nom.
        //. Si l'évènement qui n’est pas présent dans l’agenda, l’exception ErreurAgenda est levée.
        //iterate evenments
        for (Evenement evenment : evenments) {
            //if name matches, return the start date
            if (evenment.nom.equals(nom)) {
                return evenment.debut;
            }
        }
        //if not found throws ErreurAgenda
        throw new ErreurAgenda();
    }

    public Date dateFin(String nom) throws ErreurAgenda {
        //connaitre la date de fin d’un évènement prévu par son nom.
        //. Si l'évènement qui n’est pas présent dans l’agenda, l’exception ErreurAgenda est levée.
        for (Evenement evenment : evenments) {
            //if name matches, return the end date
            if (evenment.nom.equals(nom)) {
                return evenment.fin;
            }
        }
        //if not found throws ErreurAgenda
        throw new ErreurAgenda();
    }

    public boolean prevu(String nom) {
        //chercher par son nom si un évènement est présent dans l’agenda
        for (Evenement evenment : evenments) {
            if (evenment.nom.equals(nom)) {
                return true;
            }
        }
        //évènement not found
        return false;
    }

    public static void main(String[] args) throws ErreurDate, ErreurEvenement {

        /*
        //System.out.println("Hello World, Java Program");
        //create events
        Date date1 = new Date(2, 1, 2023, 7, 42);
        Date date2 = new Date(2, 1, 2025, 7, 42);
        Date date3 = new Date(2, 1, 2023, 7, 42);
        Date date4 = new Date(2, 1, 2025, 7, 42);
        Date date5 = new Date(2, 1, 2026, 7, 42);
        Date date6 = new Date(2, 1, 2027, 7, 42);
        Evenement evenement1 = new Evenement("pet kittens", date1, date2);
        Evenement evenement2 = new Evenement("pet kittens", date3, date4);
        Evenement evenement3 = new Evenement("pet kittens", date5, date6);
        //check if overlap: before, not, after
        System.out.println(evenement1.overlaps(evenement2));
        System.out.println(evenement1.overlaps(evenement3));
         */
    }

}
