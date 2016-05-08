/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author mikromafia
 */
 
public class Paperi implements Komento {
    

    @Override
    public char merkki() {
        return 'p';
    }

    @Override
    public char voittaa() {
        return 'k';
    }
    
    @Override
    public String toString() {
        return "PAPERI";
    }
    
    
    
}