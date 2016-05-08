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
    private static KPSTekoaly t = new KPSTekoaly();
    
    public static KPSTekoaly createPvAI() {
        return t;
    }
    
    public static KPSTekoaly createPvAImproved() {
        t.vaikea = true;
        return t;
    }
    
    public static KPSTekoaly createPvP() {
        t.pvp = true;
        return t;
    }
    
    
}
