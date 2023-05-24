/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author catal
 */
public class Date {

    int jour;
    int mois;
    int annee;
    int heure;
    int minute;

    public Date(int jour, int mois, int annee, int heure, int minute) throws ErreurDate {
        //Une date doit être postérieure au 1er janvier 2022, 0h00.
        boolean isPosterieur = annee >= 2022;

        if (isPosterieur) {
            setAnnee(annee);
            setMois(mois);
            setJour(jour);
            setHeure(heure);
            setMinute(minute);
        } else {
            throw new ErreurDate();
        }
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public int getHeure() {
        return heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setJour(int jour) throws ErreurDate {
        boolean isValid = false;

        //jour est inclus entre 1 et 31 si mois égale à 1, 3, 5, 7, 8, 10 ou 12.
        if (this.mois == 1 || this.mois == 3 || this.mois == 5 || this.mois == 7 || this.mois == 8 || this.mois == 10 || this.mois == 12) {
            if (jour >= 1 && jour <= 31) {
                isValid = true;
            }
        }
        //jour est inclus entre 1 et 30 si mois égale à 4, 6, 9 ou 11.
        if (this.mois == 4 || this.mois == 6 || this.mois == 9 || this.mois == 11) {
            if (jour >= 1 && jour <= 30) {
                isValid = true;
            }
        }
        //jour est inclus entre 1 et 29 si mois égale à 2 et annee est bissextile.
        //jour est inclus entre 1 et 28 si mois égale à 2 et annee n’est pas une année bissextile.
        if (this.mois == 2) {
            if (isBissextile(this.annee)) {
                if (jour >= 1 && jour <= 29) {
                    isValid = true;
                }
            } else {
                if (jour >= 1 && jour <= 28) {
                    isValid = true;
                }
            }
        }

        if (isValid) {
            this.jour = jour;
        } else {
            throw new ErreurDate();
        }

    }

    public void setMois(int mois) throws ErreurDate {
        //mois est inclus entre 1 et 12.
        if (mois >= 1 && mois <= 12) {
            this.mois = mois;
        } else {
            throw new ErreurDate();
        }

    }

    public void setAnnee(int annee) throws ErreurDate {
        // Une date doit être postérieure au 1er janvier 2022, 0h00.
        if (annee >= 2022) {
            this.annee = annee;
        } else {
            throw new ErreurDate();
        }
    }

    public void setHeure(int heure) throws ErreurDate {
        //heure est inclus entre 0 et 23.
        if (heure >= 0 && heure <= 23) {
            this.heure = heure;
        } else {
            throw new ErreurDate();
        }
    }

    public void setMinute(int minutes) throws ErreurDate {
        //minute est inclus entre 0 et 59.
        if (minutes >= 0 && minutes <= 59) {
            this.minute = minutes;
        } else {
            throw new ErreurDate();
        }
    }

    @Override
    public String toString() {
        //1er janvier 2022, 0h00
        return jour + " " + mois + " " + annee + ", " + heure + "h" + minute;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.jour;
        hash = 97 * hash + this.mois;
        hash = 97 * hash + this.annee;
        hash = 97 * hash + this.heure;
        hash = 97 * hash + this.minute;
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
        final Date other = (Date) obj;
        if (this.jour != other.jour) {
            return false;
        }
        if (this.mois != other.mois) {
            return false;
        }
        if (this.annee != other.annee) {
            return false;
        }
        if (this.heure != other.heure) {
            return false;
        }
        return this.minute == other.minute;
    }

    public boolean apres(Date uneDate) {
        //compare times
        //TODO implement
        if (this.getAnnee() > uneDate.getAnnee()) {
            return true;
        } else if (this.getAnnee() < uneDate.getAnnee()) {
            return false;
        } else { // start year is equal to end year
            if (this.getMois() > uneDate.getMois()) {
                return true;
            } else if (this.getMois() < uneDate.getMois()) {
                return false;
            } else { // start month is equal to end month
                if (this.getJour() > uneDate.getJour()) {
                    return true;
                } else if (this.getJour() < uneDate.getJour()) {
                    return false;
                } else { // start day is equal to end day
                    if (this.getHeure() > uneDate.getHeure()) {
                        return true;
                    } else if (this.getHeure() < uneDate.getHeure()) {
                        return false;
                    } else { // start hour is equal to end hour
                        if (this.getMinute() > uneDate.getMinute()) {
                            return true;
                        } else { // start minute is less than or equal to end minute
                            return false;
                        }
                    }
                }

            }
        }

    }

    public boolean isBissextile(int annee) {
        //depuits l'enoncer
        if (annee % 4 == 0 && annee % 100 == 0 || annee % 400 == 0) {
            return true;
        }
        return false;
    }
}
