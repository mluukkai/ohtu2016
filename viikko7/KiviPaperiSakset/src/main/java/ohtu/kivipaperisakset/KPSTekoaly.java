package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.*;

public class KPSTekoaly {

    private static final Scanner scanner = new Scanner(System.in);

    public boolean vaikea = false;
    public boolean pvp = false;
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        Tekoaly tekoaly;
        
        if (!vaikea) {
            tekoaly = new Tekoaly();
        } else {
            tekoaly = new TekoalyParannettu(20);
        }

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto;

        if (!pvp) {
            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
        } else {
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = scanner.nextLine();
        }

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            if (!pvp) {
                tokanSiirto = tekoaly.annaSiirto();
                System.out.println("Tietokone valitsi: " + tokanSiirto);
                tekoaly.asetaSiirto(ekanSiirto);
            } else {
                System.out.print("Toisen pelaajan siirto: ");
                tokanSiirto = scanner.nextLine();
            }

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
