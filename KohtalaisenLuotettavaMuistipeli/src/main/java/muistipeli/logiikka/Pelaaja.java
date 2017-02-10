
package muistipeli.logiikka;

/**
 * Luokka tarjoaa pelissä käytettävät pelaajaoliot.
 * 
 */
public class Pelaaja {
    private String nimi;
    private int parit;

    /**
     * Luo pelaajaolion, jolla on 0 löydettyä paria.
     * 
     * @param nimi pelaajan nimi
     */
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

    /**
     * 
     * @return
     */
    public String getNimi() {
        return nimi;
    }
    
    /**
     * Palauttaa pelaajan löytämät parit merkkijonoesityksenä.
     * 
     * @return parit merkkijonona
     */
    public String pareja() {
        if (parit == 1) {
            return "Sinulla on " + parit + " pari.";
        }
        return "Sinulla on " + parit + " paria.";
    }
    
    /**
     * 
     * @return
     */
    public int getParit() {
        return parit;
    }

    /**
     * Lisää pelaajan löytämien parien määrää yhdellä.
     */
    public void loysiParin() {
        parit++;
    }
    
    
    
    
    
    
}
