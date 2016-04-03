package ohtu.verkkokauppa;


public class Pankki implements PankkiInterface {

//    private static Pankki instanssi;
//
//    public static Pankki getInstance() {
//        if (instanssi == null) {
//            instanssi = new Pankki();
//        }
//
//        return instanssi;
//    }
    private KirjanpitoInterface kirjanpitoInterface;

    public Pankki(KirjanpitoInterface ki) {
        kirjanpitoInterface = ki;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpitoInterface.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}