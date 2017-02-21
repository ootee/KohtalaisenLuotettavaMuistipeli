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
        this.lukija = new Scanner(System.in);
        this.pelaajat = new ArrayList<>();
        this.loydetyt = new ArrayList<>();
        this.vuoro = 0;
        this.parejaJaljella = 32;
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

    public void lisaaPelaaja() {
        pelaajat.add(new Pelaaja("Pelaaja " + pelaajat.size() + 1));
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
            if (ekaKortti.equals(tokaKortti)) {
                vuorossaOleva().loysiParin();
                pariLoydetty();
                paivitettava.asetaTeksti("Hyvä " + vuorossaOleva().getNimi() + ", löysit parin!");
            } else {
                paivitettava.asetaTeksti("Ei paria, parempi tuuri ensi vuorolla.");
            }
        } else {
            paivitettava.kaannaKorttiPiiloon(ekanIndeksi);
            paivitettava.kaannaKorttiPiiloon(tokanIndeksi);
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
//        while (parejaOnVielaJaljella()) {
//            
//
//        }
//            System.out.println("Vuorossa: " + vuorossaOleva().getNimi());
//            System.out.println("");
//
//            System.out.print("Valitse ensimmäinen kortti. ");
//            int kortti1 = Integer.parseInt(lukija.nextLine());
//            System.out.println(kortit.get(kortti1));
//
//            System.out.print("Valitse toinen kortti. ");
//            int kortti2 = Integer.parseInt(lukija.nextLine());
//            System.out.println(kortit.get(kortti2));
//
//            if (kortit.get(kortti1).equals(kortit.get(kortti2))) {
//                vuorossaOleva().loysiParin();
//
//                System.out.println("Hyvä " + vuorossaOleva().getNimi() + ", löysit parin.");
//                System.out.println("Sinulla on " + vuorossaOleva().pareja());
//
//                parejaJaljella--;
//                
//                loydetyt.add(kortit.get(kortti1));
//                
//                System.out.println("Pareja jäljellä " + parejaJaljella);
//            }
//            vuoro++;
//
//        }
//        
//        System.out.println("Peli loppu.");
//        for (Pelaaja p : pelaajat) {
//            System.out.println(p);
//        }
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

    public void luoPelaajat(int lkm) {
        for (int i = 0; i < lkm; i++) {
            lisaaPelaaja();
        }
    }

    public Pelaaja vuorossaOleva() {
        return pelaajat.get(vuoro % pelaajat.size());
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

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public Kortti getEkaKortti() {
        return ekaKortti;
    }

    public Kortti getTokaKortti() {
        return tokaKortti;
    }

}
