/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

/**
 *
 * @author jkostet
 */
public interface VarastoInterface {

    TuoteInterface haeTuote(int id);

    void otaVarastosta(TuoteInterface t);

    void palautaVarastoon(TuoteInterface t);

    int saldo(int id);
    
}
