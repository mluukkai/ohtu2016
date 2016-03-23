package ohtu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ohtu.verkkokauppa.IKauppa;
import ohtu.verkkokauppa.IKirjanpito;
import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;

public class Main {

    public static void main(String[] args) {
    	ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");

        Kauppa kauppa = (Kauppa)ctx.getBean("Kauppa");    	
        // kirjanpito
        //IKirjanpito kirjanpito = new Kirjanpito();
        //IKauppa kauppa = new Kauppa(new Varasto(kirjanpito), new Pankki(kirjanpito), new Viitegeneraattori());

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        for (String tapahtuma : kauppa.getKirjanpito().getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
