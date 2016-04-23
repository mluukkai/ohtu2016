package ohtu.lyyrakortti;

public class Kassapaate {
    private int myytyjaLounaita;
    public static final int HINTA = 5;

    public Kassapaate() {
        this.myytyjaLounaita = 0;
    }
    
    public void lataa(Lyyrakortti kortti, int summa){
        kortti.lataa(Math.min(0, summa));
    }
    
    public void ostaLounas(Lyyrakortti kortti) {
        if(kortti.getSaldo() >= HINTA) {
            kortti.osta(HINTA);
            myytyjaLounaita++;
        }
    }

    public int getMyytyjaLounaita() {
        return myytyjaLounaita;
    }
}
