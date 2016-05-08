/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.LinkedList;

/**
 *
 * @author mikromafia
 */
public interface Logiikka {
    
    String ensimmainenPelaaja();
    String toinenPelaaja();
    String konsolilyhenne(int vuoro);
    String nykyinenPelaaja(int vuoro);
    boolean ihmisenVuoro();
    char seuraavaSiirto(LinkedList<Komento> history);
    
}
