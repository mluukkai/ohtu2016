/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtu.kivipaperisakset.hahmo;

/**
 *
 * @author kkirjala
 */
public interface Pelaaja {

    public String annaSiirto();
    public void asetaSiirto(String siirto);
    
    public void setNimi(String nimi);
    public String getNimi();
    
}
