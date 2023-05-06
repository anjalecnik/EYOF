package si.feri.opj.Lecnik.Prostori;
import si.feri.opj.Lecnik.Izjeme.TipPanogeException;
import si.feri.opj.Lecnik.Izjeme.DodajanjeTekmeException;
import si.feri.opj.Lecnik.Organizacija.SportnaPanoga;
import si.feri.opj.Lecnik.Organizacija.Tekma;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Abstract class representing a competition scene/place
 * @author Anja Lecnik
 * @version 4.0
 */

public abstract class Prizorisce implements Serializable {
    private String ime;
    private long telefon;
    protected Tekma[] seznamTekem;
    private SportnaPanoga sportnaPanoga;


    /**
     * Returns a string representation of the competition scene/place, including its name, phone number, and sport field.
     * @return a string consisting of the competition scene/place's name, phone number, and sport field, separated by spaces.
     */
    @Override
    public String toString() {
        return ime + " " + telefon + " " + sportnaPanoga;
    }

    /**
     * Constructs a new competition scene with the given name, phone number, competition capacity, and type of sport.
     * @param ime the name of the competition scene.
     * @param telefon the phone number of the competition scene.
     * @param kapacitetaTekem the maximum number of competitions that can take place in the competition scene at once.
     * @param sportnaPanoga the type of sport/discipline that the competition scene is designed for.
     */
    public Prizorisce(String ime, long telefon, int kapacitetaTekem, SportnaPanoga sportnaPanoga) {
        this(ime, telefon, kapacitetaTekem);
        this.sportnaPanoga = sportnaPanoga;
    }

    /**
     * Constructs a new competition scene with the given name, phone number and competition capacity.
     * @param ime the name of the competition scene.
     * @param telefon the phone number of the competition scene.
     * @param kapacitetaTekem the maximum number of competitions that can take place in the competition scene at once.
     * @throws IllegalArgumentException if the given competition capacity is not positive.
     */
    public Prizorisce(String ime, long telefon, int kapacitetaTekem) {
        this(ime, telefon);
        if (kapacitetaTekem<=0) {
          throw new java.lang.IllegalArgumentException();
        }
        this.seznamTekem = new Tekma[kapacitetaTekem];
    }

    /**
     * Constructs a new competition scene with the given name and phone number.
     * @param ime the name of the competition scene.
     * @param telefon the phone number of the competition scene.
     */
    public Prizorisce(String ime, long telefon) {
        this(ime);
        this.telefon = telefon;
    }

    /**
     * Constructs a new competition scene with the given name.
     * @param ime the name of the competition scene.
     */
    public Prizorisce(String ime) {
        this.ime = ime;
    }

    /**
     * Constructs a new competition scene with default values.
     */
    public Prizorisce() {
    }

    /**
     * Adds a new competition to the array of competitions (seznamTekem) for the current competition scene. Throws a
     * DodajanjeTekmeException if the competition is trying to be added to a stadium and starts after 20:00. Throws a
     * TipPanogeException if the sport type of the competition being added is different from the sport type of the
     * competition scene.
     * @param tekma the competition to be added to the array of competitions for the current competition scene.
     * @throws DodajanjeTekmeException if the competition is trying to be added to a stadium and starts after 20:00.
     * @throws TipPanogeException if the sport type of the competition being added is different from the sport type of
     * the competition scene.
     */
    public void dodajTekmo(Tekma tekma) throws DodajanjeTekmeException, TipPanogeException {
        if (this instanceof Stadion && tekma.getTermin().getTermin().getHour() >= 20) {
            throw new DodajanjeTekmeException();
        }
        else if (tekma.getTermin().getTermin().getHour() < 20) {
            for (int i = 0; i<tekma.getSeznamSportnikov().length; i++) {
                if(tekma.getSeznamSportnikov()[i]!=null) {
                    if (tekma.getSeznamSportnikov()[i].getSportnaPanoga().equals(this.sportnaPanoga)) {
                        for (int j = 0; j < seznamTekem.length; j++) {
                            if (seznamTekem[j] == null) {
                                seznamTekem[j] = tekma;
                                break;
                            }
                        }
                    } else {
                        throw new TipPanogeException(this.getSportnaPanoga(), tekma.getNaziv(), tekma.getSeznamSportnikov()[i].getSportnaPanoga());
                    }
                }
            }
        }
    }

    /**
     * Removes all the competitions from the array seznamTekem.
     */
    public void odstraniTekme() {
        for (int i = 0; i < seznamTekem.length; i++) {
            seznamTekem[i] = null;
        }
    }

    /**
     * Calculates the percentage of occupancy of the competition scene by checking the number of taken spaces in the
     * seznamTekem array and dividing it by the total capacity of the array.
     * @return the occupancy percentage as a double value.
     */
    public double vrniZasedenost() {
        double zasedenaMesta = 0;
        for (Tekma tekma : seznamTekem) {
            if (tekma != null) {
                zasedenaMesta++;
            }
        }
        double zasedenost = zasedenaMesta / vrniKapaciteto();
        return zasedenost;
    }

    /**
     * Calculates and returns the capacity of a Prizorisce (competition venue). The implementation of this method is
     * left to concrete subclasses, depending on their specific characteristics.
     * @return the capacity of the competition venue as an integer value.
     */
    public abstract int vrniKapaciteto();

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public long getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public Tekma[] getSeznamTekem() {
        return seznamTekem;
    }

    public SportnaPanoga getSportnaPanoga() {
        return sportnaPanoga;
    }
}

