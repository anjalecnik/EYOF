
import si.feri.opj.Lecnik.Izjeme.DodajanjeSportnikaException;
import si.feri.opj.Lecnik.Izjeme.TipPanogeException;
import si.feri.opj.Lecnik.Organizacija.SportnaPanoga;
import si.feri.opj.Lecnik.Prostori.Dvorana;
import si.feri.opj.Lecnik.Prostori.Prizorisce;
import si.feri.opj.Lecnik.Izjeme.DodajanjeTekmeException;
import si.feri.opj.Lecnik.Organizacija.Tekma;
import si.feri.opj.Lecnik.Organizacija.Trening;
import si.feri.opj.Lecnik.Osebe.Sportnik;
import si.feri.opj.Lecnik.Prostori.Stadion;
import si.feri.opj.Lecnik.Termini.Termin;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Zagonski {

    public static void main(String[] args) throws DodajanjeSportnikaException, DodajanjeTekmeException, TipPanogeException {

        //10. 3. 2023
        Sportnik sportnikJudo = new Sportnik("Charles", "Leclerc", 16, LocalDate.of(2008, 10,
                16), SportnaPanoga.JUDO);
        Sportnik sportnikAtletika = new Sportnik("AA", "BB", 0, LocalDate.of(2008, 3, 14), SportnaPanoga.ATLETIKA);

        Termin terminTekme = new Termin(LocalDateTime.of(2023, 2, 3, 7, 00,00));

        Tekma atletikaTekma = new Tekma("Atletika",terminTekme);
        Tekma judoTekma = new Tekma ("Judo", terminTekme);

        Stadion stadion = new Stadion("Lokacija", 7898, 9, SportnaPanoga.JUDO);

        //Izjema java.lang.IllegalArgumentException
        try {
            Stadion izjema = new Stadion("NegativnaVrednost", 444, -5, SportnaPanoga.JUDO);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Dvorana dvorana = new Dvorana("Zlatorog", 222, 3, SportnaPanoga.ATLETIKA, 3);

        judoTekma.dodajSportnikaNaTekmo(sportnikJudo);
        stadion.dodajTekmo(judoTekma);
        atletikaTekma.dodajSportnikaNaTekmo(sportnikAtletika);

        //Izjema TipPanoge
        try {
            stadion.dodajTekmo(atletikaTekma);
        }
        catch (TipPanogeException e) {
            e.printStackTrace();
        }

        atletikaTekma.preveriVeljavnost(stadion);
        judoTekma.preveriVeljavnost(stadion);

        sportnikAtletika.preveriVeljavnost(stadion);
        sportnikJudo.preveriVeljavnost(stadion);

        sportnikAtletika.dobiImena();
        sportnikJudo.dobiImena();

        //Izjema DodajanjeTekme
        Tekma neveljavnaTekma = new Tekma("NeveljavnaTekma", new Termin (LocalDateTime.of(2023, 4, 7, 21,00,00)));

        try {
            stadion.dodajTekmo(neveljavnaTekma);
        }
        catch (DodajanjeTekmeException e){
            e.printStackTrace();
        }

        //Izjema DodajanjeSportnika

        Sportnik stariSportnik = new Sportnik("Albert", "Einstein", 22, LocalDate.of(1980, 2, 3), SportnaPanoga.ATLETIKA);

        try {
            atletikaTekma.dodajSportnikaNaTekmo(stariSportnik);
        }
        catch (DodajanjeSportnikaException e) {
            e.printStackTrace();
            e.getMessage();
        }

    }
}
