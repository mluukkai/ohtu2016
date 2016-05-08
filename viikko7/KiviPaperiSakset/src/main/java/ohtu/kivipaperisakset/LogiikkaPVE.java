/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.LinkedList;
import java.util.Random;
import static ohtu.kivipaperisakset.Paaohjelma.io;


/**
 *
 * @author mikromafia
 */
public class LogiikkaPVE implements Logiikka {
    
    private boolean vahvaTekoaly;
    private int kivet;
    private int sakset;
    private int paperit;
    private String etuliite;
    
    
    public LogiikkaPVE(boolean vahvuus) {
        this.vahvaTekoaly=vahvuus;
        if (vahvuus) {
            etuliite="Analyyttinen";
        } else {
            etuliite="Satunnainen";
        }
    }

   @Override
    public String ensimmainenPelaaja() {
        return "Ensimmäinen pelaaja";
    }

    @Override
    public String toinenPelaaja() {
        return etuliite+" Tekoäly";
    }

    @Override
    public boolean ihmisenVuoro() {
        if (Kivipaperisakset.vuoro % 2 == 0) {
            return true;
        }
         return   false;
        
    }

    @Override
    public char seuraavaSiirto(LinkedList<Komento> history) {
        if (ihmisenVuoro()) {
        return io.readLine().charAt(0);
        } else {
            return analysoi(history.getLast().merkki());
            
        }
    }

    @Override
    public String nykyinenPelaaja(int vuoro) {
        if (vuoro%2==0) {
            return ensimmainenPelaaja();
        }
        return toinenPelaaja();
    }
    
    public char analysoi(char pelaajaPelasi) {
        char palautettava = 's';
        
        if (sakset>paperit) {
            palautettava = 'k';
        }
        if (paperit>kivet) {
            palautettava = 's';
        }
        if (kivet>sakset) {
            palautettava = 'p';
        }
        
        
        if (vahvaTekoaly) {
            if (pelaajaPelasi=='s') {
                sakset++;
            }
            else if (pelaajaPelasi=='k') {
                kivet++;
            }
            else if (pelaajaPelasi=='p') {
                paperit++;
            }
        } else {
            Random randomi = new Random();
            sakset = randomi.nextInt(10);
            kivet = randomi.nextInt(10);
            paperit = randomi.nextInt(10);
        }
        
        
        return palautettava;
        
    }

    @Override
    public String konsolilyhenne(int vuoro) {
        if (vuoro%2==0) {
            return ">";
        }
        return ">";
    }
    
}
