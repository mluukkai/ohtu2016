package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPS{

  
    @Override
    public void peliKierros(String ekanSiirto,Tuomari tuomari){
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = KPS.scanner.nextLine();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = KPS.scanner.nextLine();
            
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = KPS.scanner.nextLine();
        }
    }
}