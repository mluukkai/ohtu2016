package ohtu.kivipaperisakset;

import java.util.Scanner;

class Pelaaja implements Vastustaja {
    private int pelaajaNro;
    private Scanner scanner;
    
    public Pelaaja(int pelaajaNro) {
        this.pelaajaNro = pelaajaNro;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String siirto() {
        switch(this.pelaajaNro){
            case 1:
                System.out.print("Ensimmäisen pelaajan siirto: ");
                break;
                
            case 2:
                System.out.print("Toisen pelaajan siirto: ");
                break;
            
            default:
                System.out.print("Pelaajan siirto: ");
                break;
        }
        
        return scanner.nextLine();
    }
}
