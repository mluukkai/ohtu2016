/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author mremes
 */
public class KPS {

    private static final Scanner scanner = new Scanner(System.in);
    private Tuomari tuomari;
    private Tekoaly tekoaly;
    private String kysely;

    public void pelaa(String mode) {
        tuomari = new Tuomari();
        if(!isMode(mode)) return;
        boolean pelataan = true;
        while (pelataan) pelataan = kierros();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    private boolean isMode(String mode) {
        if (mode.equals("a")) tekoaly = null;
        else if (mode.equals("b")) tekoaly = TekoalyYksinkertainen.tekoaly;
        else if (mode.equals("c")) tekoaly = TekoalyParannettu.tekoaly20;
        else return false;
        kysely = toinenPelaaja();
        return true;
    }
    
    private boolean kierros() {
        String ekanSiirto, tokanSiirto;
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = scanner.nextLine();
        System.out.print(kysely);
        tokanSiirto = toinenVastaus();
        if (!jatkuu(ekanSiirto, tokanSiirto)) return false;
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        System.out.println(tuomari);
        return true;
    }

    private String toinenPelaaja() {
        return tekoaly == null ? "Toisen pelaajan siirto: " : "Tietokone valitsi: ";
    }

    private boolean jatkuu(String ekanSiirto, String tokanSiirto) {
        return onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto);
    }

    private boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    private String toinenVastaus() {
        String vastaus = tekoaly == null ? scanner.nextLine() : tekoaly.annaSiirto();
        if (tekoaly != null) System.out.println(vastaus);
        return vastaus;
    }

}
