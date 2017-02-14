package muistipeli.logiikka;

import java.util.*;

/**
 * Luokka toteuttaa pelin perustoiminnallisuuden.
 * 
 */
public class Peli {

    private List<Kortti> kortit;
    private List<Kortti> loydetyt;
    private List<Pelaaja> pelaajat;
    private int vuoro;
    private int parejaJaljella;
    private Scanner lukija;

    /**
     * Alustaa pelin.
     */
    public Peli() {
        this.lukija = new Scanner(System.in);
        this.kortit = new ArrayList<>();
        this.pelaajat = new ArrayList<>();
        this.loydetyt = new ArrayList<>();
        this.vuoro = 1;
        this.parejaJaljella = 8;
    }

    /**
     * Luo pelissä käytettävät kortit ja asettaa niille tunnukset.
     */
    public void luoKortit() {
        for (int i = 0; i < 64; i++) {
            kortit.add(new Kortti("" + i));
            kortit.add(new Kortti("" + i));
        }

    }

    /**
     * Lisää pelaajan pelaajalistaan
     * 
     * @param nimi Pelaajan nimi
     */
    public void lisaaPelaaja(String nimi) {
        pelaajat.add(new Pelaaja(nimi));
    }
    
    public void lisaaPelaaja() {
        pelaajat.add(new Pelaaja("Pelaaja " + pelaajat.size() + 1));
    }
    
    /**
     * Tarkastaa onko kaikki parit jo löydetty.
     * 
     * @return onko löytämättömiä pareja jäljellä
     */
    public boolean parejaOnVielaJaljella() {
        
        return parejaJaljella == 0;
    }

    /**
     * Pelimoottori, työn alla
     */
    public void pelaa() {
        luoKortit();
        lisaaPelaaja("Matti");
        lisaaPelaaja("Pekka");
        while (parejaOnVielaJaljella()) {
            int vuorossaOleva = vuoro % pelaajat.size();

            System.out.println("Vuorossa: " + pelaajat.get(vuorossaOleva));
            System.out.println("");

            System.out.print("Valitse ensimmäinen kortti. ");
            int kortti1 = Integer.parseInt(lukija.nextLine());
            System.out.println(kortit.get(kortti1));

            System.out.print("Valitse toinen kortti. ");
            int kortti2 = Integer.parseInt(lukija.nextLine());
            System.out.println(kortit.get(kortti2));

            if (kortit.get(kortti1).equals(kortit.get(kortti2))) {
                pelaajat.get(vuorossaOleva).loysiParin();

                System.out.println("Hyvä " + pelaajat.get(vuorossaOleva).getNimi() + ", löysit parin.");
                System.out.println("Sinulla on " + pelaajat.get(vuorossaOleva).pareja());

                parejaJaljella--;
                
                loydetyt.add(kortit.get(kortti1));
                
                System.out.println("Pareja jäljellä " + parejaJaljella);
            }
            vuoro++;

        }
        
        System.out.println("Peli loppu.");
        for (Pelaaja p : pelaajat) {
            System.out.println(p);
        }
    }
    
    public Kortti valitseKortti(int kortinNumero) {
        return kortit.get(kortinNumero);
    }
    
    public boolean onkoPari(Kortti yksi, Kortti kaksi) {
        return yksi.equals(kaksi);
    }
    
    public void pariLoydetty() {
        this.parejaJaljella--;
    }
    
    public void luoPelaajat(int lkm) {
        for (int i = 0; i < lkm; i++) {
            lisaaPelaaja();
        }
    }

    /**
     *  
     * 
     * @return
     */
    public List<Kortti> getKortit() {
        return kortit;
    }

    /**
     *
     * @param kortit
     */
    public void setKortit(List<Kortti> kortit) {
        this.kortit = kortit;
    }
    
    /**
     *
     * @return
     */
    public List<Pelaaja> getPelaajat() {
        return pelaajat;
    }

}
