/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.HashMap;

/**
 *
 * @author mikromafia
 */
public class Logiikkatehdas {
    

    private final HashMap<Character, Logiikka> logiikat;

    public Logiikkatehdas() {
        logiikat = new HashMap<Character, Logiikka>();
        logiikat.put('a', new LogiikkaPVP());
        logiikat.put('b', new LogiikkaPVE(false));
        logiikat.put('c', new LogiikkaPVE(true));
        
    }

    public Logiikka hae(char operaatio) {
        Logiikka logiikka = logiikat.get(operaatio);
        if (logiikka == null) {
            logiikka = logiikat.get("tuntematon");
        }
        return logiikka;
    }
}


