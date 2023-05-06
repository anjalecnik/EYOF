package si.feri.opj.Lecnik.Organizacija;

import si.feri.opj.Lecnik.Termini.Termin;

import java.io.Serializable;

/**
 * Class representing an event
 * @author Anja Lecnik
 * @version 3.0
 */

public class Dogodek implements Serializable {
    private String naziv;
    private Termin termin;
    private boolean odpovedano;

    /**
     * Returns a string representation of the event's name, date, and status.
     * Overrides the toString method of Dogodek (event)
     * @return a string in the format "name date status"
     */
    @Override
    public String toString() {
        return naziv + " " + termin + " " + odpovedano;
    }

    /**
     * Constructs a new event with the given name, date, and status.
     * @param naziv the name of the event
     * @param termin the date of the event
     * @param odpovedano the status of the event (true if cancelled, false if not)
     */
    public Dogodek (String naziv, Termin termin, boolean odpovedano) {
        this(naziv, termin);
        this.odpovedano = odpovedano;
    }

    /**
     * Constructs a new event with the given name and status.
     * @param naziv the name of the event
     * @param termin the status of the event (true if cancelled, false if not)
     */
    public Dogodek (String naziv, Termin termin) {
        this(naziv);
        this.termin = termin;
    }

    /**
     * Constructs a new event with the given name.
     * @param naziv the name of the event
     */
    public Dogodek (String naziv) {
        this.naziv = naziv;
    }
    /**
     * Constructs a new event with default values.
     */
    public Dogodek () {
    }
    public Termin getTermin() {
        return termin;
    }
    public void setTermin(Termin termin) {
        this.termin = termin;
    }
    public boolean isOdpovedano() {
        return odpovedano;
    }
    public void setOdpovedano(boolean odpovedano) {
        this.odpovedano = odpovedano;
    }
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
