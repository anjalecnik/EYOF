package si.feri.opj.Lecnik.Termini;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class representing the term of competition/training
 * @author Anja Lecnik
 * @version 1.0
 */
public class Termin implements Serializable {
    private LocalDateTime termin;

    /**
     * Returns a string representation of the Termin object, including the date and time of the competition/match.
     * @return a string consisting of the date and time of the competition/match, in the format "day month year ob hour:minute".
     */
    @Override
    public String toString() {
        return "" + termin.getDayOfMonth() + " " + termin.getMonth() + " " + termin.getYear() + " ob " + termin.getHour()
                + ":" +termin.getMinute();
    }

    /**
     * Constructs a new instance of a term with a specified date and time.
     * @param termin the date and time of the term.
     */
    public Termin (LocalDateTime termin) {
        this.termin = termin;
    }

    /**
     * Constructs a new term with default values.
     */
    public Termin () {}

    public LocalDateTime getTermin() {
        return termin;
    }

    public void setTermin(LocalDateTime termin) {
        this.termin = termin;
    }
}
