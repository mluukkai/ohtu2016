/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author hyttijan
 */
public abstract class KPS {
    
     protected static final Scanner scanner = new Scanner(System.in);
    
    public void pelaa(){
        Tuomari tuomari = new Tuomari();
          System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        this.peliKierros(ekanSiirto,tuomari);
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    public abstract void peliKierros(String ekanSiirto,Tuomari tuomari);
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
