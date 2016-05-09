package ohtu.kivipaperisakset;

public class KPSTehdas {

    public static KPSPeli uusiKPS(String pelimuoto) {
        if (pelimuoto.equals("a")) {
            return new KPSPelaajaVsPelaaja();
        } else if (pelimuoto.equals("b")) {
            return new KPSTekoaly(new Tekoaly());
        } else if (pelimuoto.equals("c")) {
            return new KPSTekoaly(new TekoalyParannettu(20));
        } else {
            return null;
        }
    }
}
