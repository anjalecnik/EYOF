package si.feri.opj.Lecnik.Osebe;
import si.feri.opj.Lecnik.Organizacija.SportnaPanoga;
import si.feri.opj.Lecnik.Organizacija.Tekma;
import si.feri.opj.Lecnik.Organizacija.Tekmovanje;
import si.feri.opj.Lecnik.Prostori.Prizorisce;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class representing an athlete
 * @author Anja Lecnik
 * @version 4.0
 */
public class Sportnik implements Tekmovanje, Serializable {
    private String ime;
    private String priimek;
    private int stevilkaSportnika;
    private LocalDate datumRojstva;
    private SportnaPanoga sportnaPanoga;
    private Tekma[] seznamLastnihTekem = new Tekma[5];

    /**
     * Returns a string representation of the athlete, including their name, surname, date of birth, competition number,
     * and sport field.
     * @return a string consisting of the athlete's name, surname, date of birth (in "dd.mm.yyyy" format), competition number,
     * and sport field, separated by spaces.
     */
    @Override
    public String toString() {
        return ime + " " + priimek + " " + datumRojstva +" " + stevilkaSportnika + " " + sportnaPanoga;
    }

    /**
     * Returns the names of the matches on the athlete's personal list of matches.
     * Prints the names to the console.
     */
    public void dobiImena() {
        for (int i = 0; i<seznamLastnihTekem.length; i++) {
            if (seznamLastnihTekem[i] != null) {
                System.out.println(seznamLastnihTekem[i].getNaziv());
            }
        }
    }

    /**
     * Constructs a new athlete with the given name, surname, competition number, date of birth, and sport type.
     * @param ime the name of the athlete
     * @param priimek the surname of the athlete
     * @param stevilkaSportnika the competition number of the athlete
     * @param datumRojstva the date of birth of the athlete
     * @param sportnaPanoga the sport type of the athlete
     */
    public Sportnik (String ime, String priimek, int stevilkaSportnika, LocalDate datumRojstva, SportnaPanoga sportnaPanoga) {
        this(ime, priimek);
        this.stevilkaSportnika = stevilkaSportnika;
        this.datumRojstva = datumRojstva;
        this.sportnaPanoga = sportnaPanoga;
    }

    /**
     * Constructs a new athlete with the given name and surname.
     * @param ime the name of the athlete
     * @param priimek the surname of the athlete
     */
    private Sportnik (String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    /**
     * Constructs a new athlete with default values.
     */
    public Sportnik() {}

    /**
     * Checks whether this athlete is added to a match in the given competition scene and if so, adds that match to their
     * personal list of matches.
     * @param prizorisce the competition scene to check for matches
     */
    public void preveriVeljavnost(Prizorisce prizorisce) {
        for (int i = 0; i < prizorisce.getSeznamTekem().length; i++) {
            if (prizorisce.getSeznamTekem()[i]!= null && prizorisce.getSeznamTekem()[i].sportnikObstaja(this.priimek)) {
                for (int j = 0; j<this.seznamLastnihTekem.length; j++) {
                    if (this.seznamLastnihTekem[j] == null) {
                        this.seznamLastnihTekem[j] = prizorisce.getSeznamTekem()[i];
                        break;
                    }
                }
            }
        }
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getStevilkaSportnika() {
        return stevilkaSportnika;
    }

    public void setStevilkaSportnika(int stevilkaSportnika) {
        this.stevilkaSportnika = stevilkaSportnika;
    }

    public LocalDate getDatumRojstva() {
        return datumRojstva;
    }

    public void setDatumRojstva(LocalDate datumRojstva) {
        this.datumRojstva = datumRojstva;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public Tekma[] getSeznamLastnihTekem() {
        return seznamLastnihTekem;
    }

    public void setSeznamLastnihTekem(Tekma[] seznamLastnihTekem) {
        this.seznamLastnihTekem = seznamLastnihTekem;
    }
    public SportnaPanoga getSportnaPanoga() {return sportnaPanoga;}
}
