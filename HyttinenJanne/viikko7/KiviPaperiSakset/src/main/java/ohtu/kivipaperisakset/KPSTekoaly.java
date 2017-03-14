package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS{
    
    @Override
    public void peliKierros(String ekanSiirto,Tuomari tuomari){
        String tokanSiirto;
        Tekoaly tekoaly = new Tekoaly();
        tokanSiirto = tekoaly.annaSiirto();
         System.out.println("Tietokone valitsi: " + tokanSiirto);
         while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
         tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
         System.out.println(tuomari);
         System.out.println();

         System.out.print("Ensimmäisen pelaajan siirto: ");
         ekanSiirto = KPS.scanner.nextLine();

         tokanSiirto = tekoaly.annaSiirto();
         System.out.println("Tietokone valitsi: " + tokanSiirto);
         tekoaly.asetaSiirto(ekanSiirto);
         }
    }
   
}