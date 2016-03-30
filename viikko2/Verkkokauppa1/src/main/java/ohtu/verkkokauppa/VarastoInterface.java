package ohtu.verkkokauppa;

/**
 * Created by mremes on 28/03/16.
 */
public interface VarastoInterface {
    Tuote haeTuote(int id);

    int saldo(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);
}
