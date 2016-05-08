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
public class Komentotehdas {

    private final HashMap<Character, Komento> komennot;

    public Komentotehdas() {
        komennot = new HashMap<Character, Komento>();
        komennot.put('k', new Kivi());
        komennot.put('p', new Paperi());
        komennot.put('s', new Sakset());
    }

    public Komento hae(char operaatio) {
        Komento komento = komennot.get(operaatio);
//        if (komento == null) {
//            komento = komennot.get("tuntematon");
//        }
        return komento;
    }
}
