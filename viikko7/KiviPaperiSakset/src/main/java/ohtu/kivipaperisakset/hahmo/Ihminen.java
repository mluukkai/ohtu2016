package ohtu.kivipaperisakset.hahmo;

import java.util.Scanner;

public class Ihminen implements Pelaaja {
    
    private Scanner lukija;    
    private String nimi;
    
    // TODO: System.outin/Scannerin päälle abstraktio
    public Ihminen(String nimi) {
        this(new Scanner(System.in), nimi);
    }

    public Ihminen(Scanner lukija, String nimi) {
        this.lukija = lukija;
        this.nimi = nimi;
    }       
    
    
    @Override
    public String annaSiirto() {
        
        System.out.print(this.getNimi() + " siirto: ");
        return this.lukija.nextLine();
        
    }

    
    @Override
    public void asetaSiirto(String siirto) {
       
    }

    @Override
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    
    
    
}
