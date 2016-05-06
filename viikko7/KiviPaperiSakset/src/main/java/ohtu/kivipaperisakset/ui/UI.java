
package ohtu.kivipaperisakset.ui;

import java.util.Scanner;
import ohtu.kivipaperisakset.logiikka.KPS;


public class UI {
    private Scanner scanner;
    private KPS kps;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    
    public void kaynnista() {
        OUTER:
        while (true) {
            tulostaValikko();
            String vastaus = scanner.nextLine();
            switch (vastaus) {
                case "a":
                    aloitaPvP();
                    break;
                case "b":
                    aloitaPvAI();
                    break;
                case "c":
                    aloitaPvVaikeaAI();
                    break;
                default:
                    break OUTER;
            }
        }
    }
    
    private void tulostaValikko() {
        System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
    }
    
    private void aloitaPvP() {
        this.kps = new KPS(KPS.PvP, this);
        aloita();
    }
    
    private void aloitaPvAI() {
        this.kps = new KPS(KPS.PvAI, this);
        aloita();
    }
    
    private void aloitaPvVaikeaAI() {
        this.kps = new KPS(KPS.PvVaikeaAI, this);
        aloita();
    }
    
    private void aloita() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        kps.pelaa();
    }
    
    public String kysySiirto() {
        return scanner.nextLine();
    }
    
    public void tulosta(String tulostus) {
        System.out.println(tulostus);
    }
}
