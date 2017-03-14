/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtu.kivipaperisakset.pelityyppi;

/**
 *
 * @author kkirjala
 */
public class PeliCreator {
    
    public static KiviPaperiSakset luoPeli(int peliTyyppi) {
        
        switch(peliTyyppi) {
                case 1:
                    return new KPSPelaajaVsPelaaja();
                case 2:
                    return new KPSTekoaly();
                case 3:
                    return new KPSParempiTekoaly();
        }
        
        return null;
    }
    
}
