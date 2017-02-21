package muistipeli.logiikka;

import java.util.*;
import muistipeli.kayttoliittyma.Kayttoliittyma;
import muistipeli.kayttoliittyma.NappuloidenKuuntelija;
import muistipeli.kayttoliittyma.Paivitettava;

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
    private Korttipakka korttipakka;
    private Paivitettava paivitettava;
    private Kortti ekaKortti;
    private Kortti tokaKortti;
    private int ekanIndeksi;
    private int tokanIndeksi;

    /**
     * Alustaa pelin.
     */
    public Peli() {
        this.pelaajat = new ArrayList<>();
        this.loydetyt = new ArrayList<>();
        this.vuoro = 0;
        this.parejaJaljella = 31;
        this.korttipakka = new Korttipakka();
        this.kortit = korttipakka.getKorttipakka();

    }

    /**
     * Luo pelissä käytettävät kortit ja asettaa niille tunnukset.
     */
    /**
     * Lisää pelaajan pelaajalistaan
     *
     * @param nimi Pelaajan nimi
     */
    public void lisaaPelaaja(String nimi) {
        pelaajat.add(new Pelaaja(nimi));
    }

    /**
     * Tarkastaa onko kaikki parit jo löydetty.
     *
     * @return onko löytämättömiä pareja jäljellä
     */
    public boolean parejaOnVielaJaljella() {

        return parejaJaljella != 0;
    }

    public void kaannaKortti(int indeksi) {
        
        if (ekaKortti == null) {
            ekanIndeksi = indeksi;
            ekaKortti = valitseKortti(ekanIndeksi);
            paivitettava.kaannaKorttiEsiin(ekanIndeksi);
            paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse toinen kortti.");
            
        } else if (tokaKortti == null) {
            
            tokanIndeksi = indeksi;
            tokaKortti = valitseKortti(tokanIndeksi);
            paivitettava.kaannaKorttiEsiin(tokanIndeksi);
            
            if (onkoPari(ekaKortti, ekaKortti) && parejaOnVielaJaljella()) {
                
                vuorossaOleva().loysiParin();
                pariLoydetty();
                paivitettava.asetaTeksti("Hyvä " + vuorossaOleva().getNimi() + ", löysit parin! Paina mitä tahansa nappulaa.");
                loydetyt.add(ekaKortti);
                loydetyt.add(tokaKortti);
                paivitettava.asetaPisteet(pelaajat);
                
            } else if (parejaOnVielaJaljella()) {
                
                paivitettava.asetaTeksti("Ei paria, parempi tuuri ensi vuorolla. Paina mitä tahansa nappulaa.");
                
            } else {
                
                vuorossaOleva().loysiParin();
                paivitettava.asetaPisteet(pelaajat);
                paivitettava.asetaTeksti("Peli loppui, onnea voittajalle!");
            }
            
        } else {
            
            if (onkoPari(ekaKortti, ekaKortti)) {
                paivitettava.poistaKortti(ekanIndeksi);
                paivitettava.poistaKortti(tokanIndeksi);
                
            } else {
                
                paivitettava.kaannaKorttiPiiloon(ekanIndeksi);
                paivitettava.kaannaKorttiPiiloon(tokanIndeksi);
            }
            
            ekaKortti = null;
            tokaKortti = null;
            ekanIndeksi = -1;
            tokanIndeksi = -1;
            vuoro++;
            paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");

        }
    }

    /**
     * Pelimoottori, työn alla
     */
    public void pelaa() {
        Collections.shuffle(kortit);
        lisaaPelaaja("Pelaaja 1");
        lisaaPelaaja("Pelaaja 2");
        paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");
        paivitettava.asetaPisteet(pelaajat);
    }

    public Kortti valitseKortti(int indeksi) {
        return kortit.get(indeksi);
    }

    public boolean onkoPari(Kortti yksi, Kortti kaksi) {
        return yksi.equals(kaksi);
    }

    public void pariLoydetty() {
        this.parejaJaljella--;
    }

    public Pelaaja vuorossaOleva() {
        return pelaajat.get(vuoro % pelaajat.size());
    }

    /**
     *
     * @param kortit
     */
    public void setKortit(List<Kortti> kortit) {
        this.kortit = kortit;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public Object getKortit() {
        return kortit;
    }
}
