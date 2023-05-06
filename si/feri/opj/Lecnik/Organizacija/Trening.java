package si.feri.opj.Lecnik.Organizacija;

import si.feri.opj.Lecnik.Termini.Termin;

import java.io.Serializable;

/**
 * Class representing a training
 * @author Anja Lecnik
 * @version 3.0
 */
public class Trening extends Dogodek implements Serializable {
    private String imeTrenerja;

    /**
     * Returns a string representation of the training, including its name, date, coach name, and cancellation status.
     * @return a string containing the name, date, coach name, and cancellation status of the training
     */
    @Override
    public String toString() {
        return super.toString() + " " + imeTrenerja;
    }

    /**
     * Constructs a new training with the given name, date, cancellation status and coach name.
     * @param naziv the name of the training
     * @param odpovedano the cancellation status of the training
     * @param termin the date and time of the training
     * @param imeTrenerja the name of the coach leading the training
     */
    public Trening (String naziv, Termin termin, boolean odpovedano, String imeTrenerja) {
        super(naziv, termin, odpovedano);
        this.imeTrenerja = imeTrenerja;
    }

    /**
     * Constructs a new training with the given name, date and coach name.
     * @param naziv the name of the training
     * @param termin the date and time of the training
     * @param imeTrenerja the name of the coach leading the training
     */
    public Trening (String naziv, Termin termin, String imeTrenerja) {
        super (naziv, termin, false);
        this.imeTrenerja = imeTrenerja;
    }

    /**
     * Constructs a new training with the given name.
     * @param naziv the name of the training
     */
    public Trening (String naziv) {
        super(naziv);
    }

    /**
     * Constructs a new training with default values.
     */
    public Trening () {}

    public String getImeTrenerja() {
        return imeTrenerja;
    }
    public void setImeTrenerja(String imeTrenerja) {
        this.imeTrenerja = imeTrenerja;
    }

}
