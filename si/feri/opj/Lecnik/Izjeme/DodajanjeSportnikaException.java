package si.feri.opj.Lecnik.Izjeme;

/**
 * Custom class DodajanjeSportnikaException, designed to be thrown when an underage or overage athlete is trying to be added
 * to a competition.
 * @author Anja Lecnik
 * @version 4.0
 */

public class DodajanjeSportnikaException extends Exception {
    public DodajanjeSportnikaException() {
            System.out.println("Športnik je premlad ali prestar.");
        }
}
