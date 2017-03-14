package ohtu.kivipaperisakset;
// vastaan vai ei
public class KPSParempiTekoaly extends KPS{

    
   
    @Override
    public void peliKierros(String ekanSiirto,Tuomari tuomari){
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);
        String tokanSiirto;
        tokanSiirto = tekoaly.annaSiirto();
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }
       
    }
   
}
