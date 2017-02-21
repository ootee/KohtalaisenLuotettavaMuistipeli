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

    /**
     * Kääntää kortit esiin ja piiloon ja vertailee ovatko ne samat
     * 
     * @param indeksi Käännettävän kortin indeksi listalla
     */
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

            if (ekaKortti.equals(tokaKortti) && parejaOnVielaJaljella()) {

                vuorossaOleva().loysiParin();
                pariLoydetty();
                paivitettava.asetaTeksti("Hyvä " + vuorossaOleva().getNimi() + ", löysit parin! Saat jatkaa, paina mitä tahansa näppäintä.");
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

            if (ekaKortti.equals(tokaKortti)) {
                paivitettava.poistaKortti(ekanIndeksi);
                paivitettava.poistaKortti(tokanIndeksi);
                paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");
                

            } else {

                paivitettava.kaannaKorttiPiiloon(ekanIndeksi);
                paivitettava.kaannaKorttiPiiloon(tokanIndeksi);
                vuoronLoppu();
                paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");
            }

            ekaKortti = null;
            tokaKortti = null;
            ekanIndeksi = -1;
            tokanIndeksi = -1;

        }
    }

    /**
     * Sekoittaa kortit, luo pelaajat ja alustaa viestikentät
     */
    public void pelaa() {
        Collections.shuffle(kortit);
        lisaaPelaaja("Pelaaja 1");
        lisaaPelaaja("Pelaaja 2");
        paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");
        paivitettava.asetaPisteet(pelaajat);
    }

    /**
     * Valitsee kortin
     * 
     * @param indeksi Kortin indeksi listalla
     * @return Palauttaa listalta valitun kortin
     */
    public Kortti valitseKortti(int indeksi) {
        return kortit.get(indeksi);
    }

    /**
     * Vähentää jäljellä olevien parien muuttujan arvoa yhdellä
     */
    public void pariLoydetty() {
        this.parejaJaljella--;
    }

    /**
     * Palauttaa vuorossa olevan pelaajaolion
     * @return Pelaajaolio
     */
    public Pelaaja vuorossaOleva() {
        return pelaajat.get(vuoro % pelaajat.size());
    }

    /**
     * Palauttaa listan kaikista pelissä olevista korteista.
     *
     * @return lista pelin korteista
     */
    public List<Kortti> getKortit() {
        return kortit;
    }

    /**
     * Palauttaa listan pelaajista
     * 
     * @return lista pelaajista
     */
    public List<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    /**
     * Asettaa käyttöliitymän komponenttien muokkaamiseen tarvittavan rajapinnan
     *
     * @param paivitettava Käyttöliittymä
     */
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    /**
     * Palauttaa vuorolla ensimmäiseksi valitun kortin
     * 
     * @return Kortti
     */
    public Kortti getEkaKortti() {
        return ekaKortti;
    }

    /**
     * Palauttaa vuorolla toisena valitun kortin
     * 
     * @return Kortti
     */
    public Kortti getTokaKortti() {
        return tokaKortti;
    }

    /**
     * Asettaa pelissä käytettävät kortit testejä varten
     * 
     * @param kortit Lista korttiolioista
     */
    public void setKortit(List<Kortti> kortit) {
        this.kortit = kortit;
    }
    
    /**
     * Kasvattaa vuoro-muuttujan arvoa yhdellä vuoron päätteeksi
     */
    public void vuoronLoppu() {
        vuoro++;
    } 
    
}
