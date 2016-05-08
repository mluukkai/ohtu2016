/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import static ohtu.kivipaperisakset.Paaohjelma.io;

/**
 *
 * @author mikromafia
 */
public class Ilmoitus {
    
    public static void valitsePelitila() {
           io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) satunnaista tekoälyä vastaan"
                    + "\n (c) analyyttistä tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan\n");

    }
    
    public static void varoitaVirheellisistaSiirroista() {
            io.print("Anna komento k, p tai s. Peli kestää 20 kierrosta.\n");
    }
}
