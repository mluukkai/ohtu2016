/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author jkostet
 */
public abstract class KPS {
    public static KPSTekoaly createPvAI() {
        return new KPSTekoaly();
    }
    
    public static KPSTekoaly createPvAImproved() {
        KPSTekoaly t = new KPSTekoaly();
        t.vaikea = true;
        return t;
    }
    
    public static KPSPelaajaVsPelaaja createPvP() {
        return new KPSPelaajaVsPelaaja();
    }
}
