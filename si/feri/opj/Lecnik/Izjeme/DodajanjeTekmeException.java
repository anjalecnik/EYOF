package si.feri.opj.Lecnik.Izjeme;

/**
 * Custom class DodajanjeTekmeException, designed to be thrown when an attempt is made to add a new game to stadion,
 * but the start time is after 8 PM.
 * @author Anja Lecnik
 * @version 4.0
 */

public class DodajanjeTekmeException extends Exception {
    public DodajanjeTekmeException() {
        System.out.println("Tekma se ne more začeti po 20. uri");
    }
}
