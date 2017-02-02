
package muistipeli.logiikka;

public class Pelaaja {
    private String nimi;
    private int parit;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.parit = 0;
    }

    @Override
    public String toString() {
        if (parit == 1) {
            return nimi + ": " + parit + " pari";
        }
        return nimi + ": " + parit + " paria";
    }

    public String getNimi() {
        return nimi;
    }
    
    public String pareja() {
        if (parit == 1) {
            return "Sinulla on " + parit + " pari.";
        }
        return "Sinulla on " + parit + " paria.";
    }
    
    public int getParit() {
        return parit;
    }

    public void loysiParin() {
        parit++;
    }
    
    
    
    
    
    
}
