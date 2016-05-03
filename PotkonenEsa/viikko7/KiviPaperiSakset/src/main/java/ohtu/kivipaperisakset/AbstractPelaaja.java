/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Esa Potkonen
 */
public abstract class AbstractPelaaja implements Pelaaja {
    protected Scanner scanner = new Scanner(System.in);
    protected Tuomari tuomari;
    protected Aly tekoaly;
    public AbstractPelaaja(Tuomari tuomari, Aly tekoaly) {
        this.tuomari = tuomari;
        this.tekoaly = tekoaly;
    }
    public abstract void pelaa();
    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
}
