/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.LinkedList;
import static ohtu.kivipaperisakset.Paaohjelma.io;

/**
 *
 * @author mikromafia
 */
public class LogiikkaPVP implements Logiikka {

    @Override
    public String ensimmainenPelaaja() {
        return "Ensimmäinen pelaaja";
    }

    @Override
    public String toinenPelaaja() {
        return "Toinen pelaaja";
    }

    @Override
    public boolean ihmisenVuoro() {
        return true;
    }

    @Override
    public char seuraavaSiirto(LinkedList<Komento> history) {
        return io.readLine().charAt(0);
    }

    @Override
    public String nykyinenPelaaja(int vuoro) {
        if (vuoro%2==0) {
            return ensimmainenPelaaja();
        }
        return toinenPelaaja();
    }
    
    @Override
    public String konsolilyhenne(int vuoro) {
        if (vuoro%2==0) {
            return "<1P>";
        }
        return "<2P>";
    }
}
