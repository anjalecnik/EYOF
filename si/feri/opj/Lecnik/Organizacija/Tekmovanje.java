package si.feri.opj.Lecnik.Organizacija;
import si.feri.opj.Lecnik.Prostori.Prizorisce;

/**
 * Interface Tekmovanje
 */

public interface Tekmovanje {

    /**
     * Checks the validity of the competition venue specified by the given scene. The implementation of this method is
     * left to concrete subclasses, depending on their specific characteristics.
     * @param prizorisce the competition venue to check
     */
    void preveriVeljavnost(Prizorisce prizorisce);
}
