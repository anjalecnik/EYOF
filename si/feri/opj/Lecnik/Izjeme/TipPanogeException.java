package si.feri.opj.Lecnik.Izjeme;

import si.feri.opj.Lecnik.Organizacija.SportnaPanoga;
/**
 * The TipPanogeException is a custom exception class designed to be thrown when the sport type of competition
 * scene does not match the sport type of match.
 * @author Anja Lecnik
 * @version 4.0
 */
public class TipPanogeException extends Exception{
    public TipPanogeException(SportnaPanoga panoga, String naziv, SportnaPanoga sportnaPanogaDodeljenega) {
        System.out.println("Tekme ni mogoče dodati na prizorišče, saj prizorišče sprejme tekme panoge " + panoga +
                ", na tekmo " + naziv + " pa je bil dodeljen športnik s panogo "+ sportnaPanogaDodeljenega +".");
    }
}
