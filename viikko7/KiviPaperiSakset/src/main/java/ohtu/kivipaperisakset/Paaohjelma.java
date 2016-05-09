package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {
        Kayttoliittyma ui = new Kayttoliittyma();
        while (true) {
            ui.tulostaOhjeet();
            KPSPeli kps = KPSTehdas.uusiKPS(ui.lueSyote());
            if (kps == null) {
                break;
            }
            ui.tulostaLopetusohje();
            kps.pelaa(ui);
        }
    }
}
