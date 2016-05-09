package ohtu.kivipaperisakset;

import java.util.Scanner;

class Peli {
    private static Scanner scanner;
    
    public static void pelaa(Vastustaja p1, Vastustaja p2){
        Tuomari tuomari = new Tuomari();

        
        String ensimmainenSiirto = p1.siirto();
        String toinenSiirto = p1.siirto();

        while (onkoOkSiirto(ensimmainenSiirto) && onkoOkSiirto(toinenSiirto)) {
            tuomari.kirjaaSiirto(ensimmainenSiirto, toinenSiirto);
            System.out.println(tuomari);
            System.out.println();

            ensimmainenSiirto = p1.siirto();
            toinenSiirto = p1.siirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
