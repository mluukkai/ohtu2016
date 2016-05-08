/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.pelaajat;

import java.util.Scanner;

/**
 *
 * @author oskar
 */
public class IhmisPelaaja extends Pelaaja {

    private static final Scanner scanner = new Scanner(System.in);

    public IhmisPelaaja() {
        super(true);
    }
    
    @Override
    public String otaSiirto() {
        return IhmisPelaaja.scanner.nextLine();
    }
    
}
