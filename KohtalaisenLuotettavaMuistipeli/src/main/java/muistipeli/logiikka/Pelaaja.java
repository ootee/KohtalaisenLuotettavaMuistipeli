
package muistipeli.logiikka;

class Pelaaja {
    private String nimi;
    private int parit;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.parit = 0;
    }

    @Override
    public String toString() {
        return nimi + ": " + parit + "paria";
    }

    public String getNimi() {
        return nimi;
    }
    
    public int getParit() {
        return parit;
    }

    public void loysiParin() {
        parit++;
    }
    
    
    
    
    
    
}
