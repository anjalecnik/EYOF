package si.feri.opj.Lecnik.Prostori;

import si.feri.opj.Lecnik.Organizacija.SportnaPanoga;

/**
 * Class representing a stadion
 * @author Anja Lecnik
 * @version 3.0
 */

public class Stadion extends Prizorisce {

    /**
     * Returns a string representation of the competition scene/place, including its name, phone number, and sport field.
     * @return a string consisting of the competition scene/place's name, phone number, and sport field, separated by spaces.
     */
    @Override
    public String toString() {
        return "Stadion " + super.toString();
    }

    /**
     * Constructs a new stadium with the given name, phone number, competition capacity, and type of sport.
     * @param ime the name of the stadium.
     * @param telefon the phone number of the stadium.
     * @param kapaciteta the maximum number of competitions that can take place in the stadium at once.
     * @param sportnaPanoga the type of sport/discipline that the stadium is designed for.
     */
    public Stadion (String ime, long telefon, int kapaciteta, SportnaPanoga sportnaPanoga) {
        super(ime, telefon, kapaciteta, sportnaPanoga);
    }

    /**
     * Constructs a new stadium with the given name, phone number, competition capacity, and type of sport.
     * @param ime the name of the stadium.
     * @param telefon the phone number of the stadium.
     * @param kapaciteta the maximum number of competitions that can take place in the stadium at once.
     */
    public Stadion (String ime, long telefon, int kapaciteta) {
        super(ime, telefon, kapaciteta);
    }

    /**
     * Constructs a new stadium with the given name and phone number.
     * @param ime the name of the stadium.
     * @param telefon the phone number of the stadium.
     */
    public Stadion (String ime, long telefon) {
        super(ime, telefon);
    }

    /**
     * Constructs a new stadion with default values.
     */
    public Stadion() {
        super();
    }

    /**
     * Returns the maximum number of competitions that can take place in the competition scene at once.
     * @return an integer representing the capacity of the competition scene.
     */
    public int vrniKapaciteto() {
        return seznamTekem.length;
    }
}
