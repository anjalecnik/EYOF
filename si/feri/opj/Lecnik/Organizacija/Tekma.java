package si.feri.opj.Lecnik.Organizacija;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;

import si.feri.opj.Lecnik.Izjeme.DodajanjeSportnikaException;
import si.feri.opj.Lecnik.Osebe.Sportnik;
import si.feri.opj.Lecnik.Prostori.Prizorisce;
import si.feri.opj.Lecnik.Termini.Termin;

/**
 * Class representing a competition
 * @author Anja Lecnik
 * @version 3.0
 */

public class Tekma extends Dogodek implements Tekmovanje, Serializable {
    private Sportnik[] seznamSportnikov = new Sportnik[10];

    /**
     * Returns a string representation of the competition, including its name, date, status, and competitors.
     * @return a string representation of the competition
     */
    @Override
    public String toString() {
        return super.toString() + " ";
    }

    /**
     * Constructs a new competition with the given name and date.
     * @param naziv the name of the competition
     * @param termin the date of the competition
     */
    public Tekma (String naziv, Termin termin) {
        super(naziv, termin, false);
    }

    /**
     * Constructs a new competition with default values.
     */
    public Tekma () {}

    /**
     * Determines if a given athlete is eligible to compete in the current match based on their age.
     * @param sportnik the athlete to check eligibility for, including name, surname, competition number, and date of birth
     * @return true if the athlete is between 14 and 18 years old (inclusive), false otherwise
     */
    public boolean lahkoTekmuje (Sportnik sportnik) {
        LocalDate trenutniDatum = LocalDate.now();
        Period period = Period.between(sportnik.getDatumRojstva(), trenutniDatum);
        int starost = period.getYears();
        return starost >= 14 && starost <= 18;
    }

    /**
     * Method dodajSportnikaNaTekmo() adds the given athlete to the list of competitors (array seznamSportnikov)
     * if they meet the age requirements. Otherwise, it throws a DodajanjeSportnikaException.
     * @param sportnik the athlete to be added, including their name, surname, competition number and date of birth
     * @throws DodajanjeSportnikaException if the athlete does not meet the age requirements for the competition
     */
    public void dodajSportnikaNaTekmo(Sportnik sportnik) throws DodajanjeSportnikaException{
        if (lahkoTekmuje(sportnik)) {
            for (int i = 0; i < seznamSportnikov.length; i++) {
                if (seznamSportnikov[i] == null) {
                    seznamSportnikov[i] = sportnik;
                    return;
                }
            }
        }
        throw new DodajanjeSportnikaException();
    }

    /**
     * Method odstraniSportnikaSTekme() with a parameter Sportnik sportnik removes an athlete, passed as an argument,
     * from the list of the competitors (array seznamSportnikov)
     * @param sportnik is a variable which includes athlete's name, surname, competition number and date of birth
     */
    public void odstraniSportnikaSTekme(Sportnik sportnik) {
        for (int i = 0; i<seznamSportnikov.length; i++) {
            if (seznamSportnikov[i] != null && seznamSportnikov[i] == sportnik) {
                seznamSportnikov[i] = null;
                return;
            }
        }
    }

    /**
     * Method odstraniSportnikaSTekme() removes an athlete from the list of competitors (array seznamSportnikov) based on
     * their competition number passed as an argument.
     * @param stevilkaSportnika competition number of the athlete to be removed
     * @return true if the athlete is successfully removed, false if the athlete is not found
     */
    public boolean odstraniSportnikaSTekme (int stevilkaSportnika) {
        for (int i = 0; i<seznamSportnikov.length; i++) {
            if (seznamSportnikov[i] != null && seznamSportnikov[i].getStevilkaSportnika() == stevilkaSportnika) {
                seznamSportnikov[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of competitors who have been added to the array seznamSportnikov.
     * @return the number of competitors signed up for the match.
     */
    public int vrniSteviloSportnikovNaTekmi() {
        int stejSportnike = 0;
        for (Sportnik sportnik : seznamSportnikov) {
            if (sportnik != null) {
                stejSportnike++;
            }
        }
        return stejSportnike;
    }

    /**
     * Method sportnikObstaja() with a parameter priimek checks whether the surname, passed as an argument,  is already
     * in the array seznamSportnikov, thus if a certain player is already signed to a match.
     * @param priimek is an attribute from variable Sportnik, representing their surname
     * @return the method returns a boolean (true if the surname is already on the list and false if it's not)
     */
    public boolean sportnikObstaja (String priimek) {
        for (Sportnik sportnik : seznamSportnikov) {
            if (sportnik != null && sportnik.getPriimek().equals(priimek)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether this match has been added to the specified competition scene. If the match has been added, prints a
     * message indicating that it can be held. If the match has not been added, prints a message indicating that it cannot be
     * held.
     * @param prizorisce the competition scene to check
     */
    public void preveriVeljavnost(Prizorisce prizorisce) {
        for (int i = 0; i< prizorisce.vrniKapaciteto();i++) {
            if (prizorisce.getSeznamTekem()[i] == this) {
                System.out.println("Tekma " + this.getNaziv() +" se lahko izvede");
                return;
            }
        }
        System.out.println("Tekma " + this.getNaziv() + " ni bila dodana na prizorišče.");
    }
    public Sportnik[] getSeznamSportnikov() {
        return seznamSportnikov;
    }
}
