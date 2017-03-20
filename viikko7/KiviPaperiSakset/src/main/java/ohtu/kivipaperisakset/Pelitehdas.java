package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author nikok
 */
public class Pelitehdas {
    
    public static void pelaa(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        Tuomari tuomari = new Tuomari();
        
        String ekanSiirto = "k";
        String tokanSiirto = "k";
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = pelaaja1.getSiirto(tokanSiirto);
            
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = pelaaja2.getSiirto(ekanSiirto);
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }
        
    }
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
}
