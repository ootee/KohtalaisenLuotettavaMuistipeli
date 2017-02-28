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
    private Vaihtaja vaihtaja;
    private Kortti ekaKortti;
    private Kortti tokaKortti;
    private int ekanIndeksi;
    private int tokanIndeksi;
    private Random random;

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
        this.random = new Random();
        this.vaihtaja = new Vaihtaja(random);
    }

    /**
     * Lisää pelaajan pelaajalistaan.
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
     * Kääntää kortit ja toteuttaa pelivuoron kulun.
     *
     * @param indeksi Käännettävän kortin indeksi listalla
     */
    public void kaannaKortti(int indeksi) {
        if (ekaKortti == null) {
            kaannaEnsimmainenKortti(indeksi);
        } else if (tokaKortti == null) {
            kaannaToinenKortti(indeksi);
            if (ekaKortti.equals(tokaKortti) && parejaOnVielaJaljella()) {
                kortitOlivatPari();
            } else if (parejaOnVielaJaljella()) {
                paivitettava.asetaTeksti("Ei paria, parempi tuuri ensi vuorolla. Paina mitä tahansa nappulaa.");
            } else {
                peliLoppu();
            }
        } else if (ekaKortti.equals(tokaKortti)) {
            poistaKortit();
            nollaaLoydetytKortitJaIndeksit();
        } else {
            vuoronLoppu();
            nollaaLoydetytKortitJaIndeksit();
        }
    }

    /**
     * Pelin loppumetodi.
     */
    public void peliLoppu() {
        vuorossaOleva().loysiParin();
        paivitettava.asetaPisteet(pelaajat);
        paivitettava.asetaTeksti("Peli loppui, onnea voittajalle!");
    }

    /**
     * Kääntää ensimmäisen kortin.
     *
     * @param indeksi käännettävän kortin indeksi
     */
    public void kaannaEnsimmainenKortti(int indeksi) {
        ekanIndeksi = indeksi;
        ekaKortti = valitseKortti(indeksi);
        paivitettava.kaannaKorttiEsiin(ekanIndeksi);
        paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse toinen kortti.");
    }

    /**
     * Kääntää toisen kortin.
     *
     * @param indeksi käännettävän kortin indeksi
     */
    public void kaannaToinenKortti(int indeksi) {
        tokanIndeksi = indeksi;
        tokaKortti = valitseKortti(indeksi);
        paivitettava.kaannaKorttiEsiin(tokanIndeksi);
    }

    /**
     * Merkitsee löydetyt kortit, lisää pelaajalle pisteet ja jatkaa vuoroa.
     */
    public void kortitOlivatPari() {
        vuorossaOleva().loysiParin();
        pariLoydetty();
        paivitettava.asetaTeksti("Hyvä " + vuorossaOleva().getNimi() + ", löysit parin! Saat jatkaa, paina mitä tahansa näppäintä.");
        loydetyt.add(ekaKortti);
        loydetyt.add(tokaKortti);
        paivitettava.asetaPisteet(pelaajat);
    }

    /**
     * Kasvattaa vuoro-muuttujan arvoa yhdellä ja kääntää kortit piiloon vuoron
     * päätteeksi.
     */
    public void vuoronLoppu() {
        vuoro++;
        paivitettava.kaannaKorttiPiiloon(ekanIndeksi);
        paivitettava.kaannaKorttiPiiloon(tokanIndeksi);
        vaihtaja.vaihdaKortit(kortit, loydetyt, random);
        paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");
    }

    /**
     * Asettaa kahden kortin kääntmisen jälkeen kortti ja indeksi muuttujat takaisin alkuarvoihinsa.
     */
    public void nollaaLoydetytKortitJaIndeksit() {
        ekaKortti = null;
        tokaKortti = null;
        ekanIndeksi = -1;
        tokanIndeksi = -1;
    }

    /**
     * Poistaa löydetyt kortit pelistä.
     */
    public void poistaKortit() {
        paivitettava.poistaKortti(ekanIndeksi);
        paivitettava.poistaKortti(tokanIndeksi);
        paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");
    }

    /**
     * Sekoittaa kortit, luo pelaajat ja alustaa viestikentät.
     */
    public void pelaa() {
        Collections.shuffle(kortit);
        lisaaPelaaja("Pelaaja 1");
        lisaaPelaaja("Pelaaja 2");
        paivitettava.asetaTeksti("Vuorossa " + vuorossaOleva().getNimi() + ", valitse ensimmäinen kortti.");
        paivitettava.asetaPisteet(pelaajat);
    }

    /**
     * Valitsee kortin.
     *
     * @param indeksi Kortin indeksi listalla
     * @return Palauttaa listalta valitun kortin
     */
    public Kortti valitseKortti(int indeksi) {
        return kortit.get(indeksi);
    }

    /**
     * Vähentää jäljellä olevien parien muuttujan arvoa yhdellä.
     */
    public void pariLoydetty() {
        this.parejaJaljella--;
    }

    /**
     * Palauttaa vuorossa olevan pelaajaolion.
     *
     * @return Pelaajaolio
     */
    public Pelaaja vuorossaOleva() {
        return pelaajat.get(vuoro % pelaajat.size());
    }

    public List<Kortti> getKortit() {
        return kortit;
    }

    public List<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
    public Kortti getEkaKortti() {
        return ekaKortti;
    }

    public Kortti getTokaKortti() {
        return tokaKortti;
    }

    public void setKortit(List<Kortti> kortit) {
        this.kortit = kortit;
    }

    public int getEkanIndeksi() {
        return ekanIndeksi;
    }

    public int getTokanIndeksi() {
        return tokanIndeksi;
    }

    public void setEkanIndeksi(int ekanIndeksi) {
        this.ekanIndeksi = ekanIndeksi;
    }

    public void setTokanIndeksi(int tokanIndeksi) {
        this.tokanIndeksi = tokanIndeksi;
    }

    public int getVuoro() {
        return vuoro;
    }

    public void setEkaKortti(Kortti ekaKortti) {
        this.ekaKortti = ekaKortti;
    }

    public void setTokaKortti(Kortti tokaKortti) {
        this.tokaKortti = tokaKortti;
    }

    public int getParejaJaljella() {
        return parejaJaljella;
    }
}
