/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.pelaajat.IhmisPelaaja;
import ohtu.kivipaperisakset.pelaajat.ParempiTekoalyPelaaja;
import ohtu.kivipaperisakset.pelaajat.Pelaaja;
import ohtu.kivipaperisakset.pelaajat.TekoalyPelaaja;

/**
 *
 * @author oskar
 */
public class PeliFactory {
    
    Pelaaja pelaaja1;
    
    public static PeliFactory ihminenVs() {
        PeliFactory factory = new PeliFactory();
        factory.pelaaja1 = new IhmisPelaaja();
        return factory;
    }
    
    public PeliFactoryPelaaja ihminen() {
        return new PeliFactoryPelaaja(new Peli(pelaaja1, new IhmisPelaaja()));
    }
    
    public PeliFactoryPelaaja tekoaly() {
        return new PeliFactoryPelaaja(new Peli(pelaaja1, new TekoalyPelaaja()));
    }
    
    public PeliFactoryPelaaja paremiTekoaly() {
        return new PeliFactoryPelaaja(new Peli(pelaaja1, new ParempiTekoalyPelaaja(20)));
    }
    
    public class PeliFactoryPelaaja {
        final private Peli peli;

        public PeliFactoryPelaaja(Peli peli) {
            this.peli = peli;
        }
        
        public void pelaa() {
            this.peli.pelaa();
        }
    }
}
