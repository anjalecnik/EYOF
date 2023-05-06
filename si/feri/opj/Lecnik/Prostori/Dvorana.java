package si.feri.opj.Lecnik.Prostori;

import si.feri.opj.Lecnik.Organizacija.SportnaPanoga;

/**
 * Class representing a sports hall
 * @author Anja Lecnik
 * @version 3.0
 */

public class Dvorana extends Prizorisce {
    private int steviloDodatnihDvoran;

    /**
     * Returns a string representation of this Dvorana object, including its name, phone number, capacity, sport, and
     * number of additional halls.
     * @return a string representation of this Dvorana object
     */

    @Override
    public String toString() {
        return ("Dvorana " + super.toString() + " " + steviloDodatnihDvoran);
    }

    /**
     * Constructor for creating a new sports hall with a specified name, phone number, capacity, sport type, and number
     * of additional halls.
     * @param ime the name of the sports hall
     * @param telefon the phone number of the sports hall
     * @param kapaciteta the maximum capacity of the sports hall
     * @param sportnaPanoga the type of sport that the sports hall is designed for
     * @param steviloDodatnihDvoran the number of additional halls that the sports hall has
     */
    public Dvorana (String ime, long telefon, int kapaciteta, SportnaPanoga sportnaPanoga, int steviloDodatnihDvoran) {
        super(ime, telefon, kapaciteta, sportnaPanoga);
        this.steviloDodatnihDvoran = steviloDodatnihDvoran;
    }

    /**
     * Constructor for creating a new sports hall with a specified name and phone number.
     * @param ime the name of the sports hall
     * @param telefon the phone number of the sports hall
     */
    public Dvorana (String ime, long telefon) {
        super(ime, telefon);
    }

    /**
     * Constructor for creating a new sports hall with number of additional halls.
     * @param steviloDodatnihDvoran the number of additional halls that the sports hall has
     */
    public Dvorana (int steviloDodatnihDvoran) {
        this.steviloDodatnihDvoran = steviloDodatnihDvoran;
    }

    /**
     * Returns the total capacity of the sports hall, including any additional sports halls that may be available.
     * If there are additional sports halls available, the capacity of the main sports hall is added to the number of additional sports hall.
     * @return the total capacity of the sports hall
     */
    @Override
    public int vrniKapaciteto() {
        if (steviloDodatnihDvoran>=1) {
            return (seznamTekem.length + steviloDodatnihDvoran);
        }
        else {
            return seznamTekem.length;
        }
    }

    public int getSteviloDodatnihDvoran() {
        return steviloDodatnihDvoran;
    }

    public void setSteviloDodatnihDvoran(int stevilkaSportnika) {
        this.steviloDodatnihDvoran = stevilkaSportnika;
    }

}
