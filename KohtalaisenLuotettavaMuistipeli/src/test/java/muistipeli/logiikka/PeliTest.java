package muistipeli.logiikka;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import muistipeli.kayttoliittyma.Kayttoliittyma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    private Peli p;
    private Kayttoliittyma kali;

    public PeliTest() {
    }

    @Before
    public void setUp() {
        this.p = new Peli();
        this.kali = new Kayttoliittyma(p);
        kali.run();
        p.setPaivitettava(kali);

    }

    @Test
    public void testPelaajaLisataanOikein() {
        assertEquals("Pelaaja 1", p.getPelaajat().get(0).getNimi());
    }

    @Test
    public void testParejaJaljellaTrueJosParejaOnJaljella() {
        assertEquals(true, p.parejaOnVielaJaljella());
    }

    @Test
    public void testParejaJaljellaFalseJosParejaEiJaljella() {
        for (int i = 0; i < 31; i++) {
            p.pariLoydetty();
        }
        assertEquals(false, p.parejaOnVielaJaljella());
    }

    @Test
    public void testPelaa() {
        assertEquals("Vuorossa Pelaaja 1, valitse ensimmäinen kortti.", kali.getViestikentta().getText());
        assertEquals("Pelaaja 1: 0 paria    Pelaaja 2: 0 paria    ", kali.getPistekentta().getText());
    }

    @Test
    public void testPakkaSekoitetaanAlussa() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        kortit.add(new Kortti("D"));
        p.setKortit(kortit);
        p.kaannaKortti(0);
        p.kaannaKortti(1);
        assertEquals("B", p.getTokaKortti().getTunnus());
    }

    @Test
    public void testVuorossaOleva1() {
        assertEquals("Pelaaja 1", p.vuorossaOleva().getNimi());
    }

    @Test
    public void testVuorossaOleva2() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        kortit.add(new Kortti("D"));
        List<Kortti> loydetyt = new ArrayList<>();
        p.vuoronLoppu();
        assertEquals("Pelaaja 2", p.vuorossaOleva().getNimi());
    }

    @Test
    public void testParinLoytaminenToimii() {
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("C"));
        kortit.add(new Kortti("D"));
        kortit.add(new Kortti("E"));
        kortit.add(new Kortti("F"));
        p.setKortit(kortit);
        p.kaannaKortti(0);
        p.kaannaKortti(1);
        p.vuoronLoppu();
        assertEquals(1, p.getPelaajat().get(0).getParit());
        assertEquals("", kali.getNappulat().get(0).getText());
        assertEquals("", kali.getNappulat().get(1).getText());
    }

    @Test
    public void testUseammanParinLoytaminenToimii() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        kortit.add(new Kortti("C"));
        p.setKortit(kortit);
        p.kaannaKortti(0);
        p.kaannaKortti(1);
        p.kaannaKortti(10);
        p.kaannaKortti(2);
        p.kaannaKortti(3);
        p.kaannaKortti(10);
        p.kaannaKortti(4);
        p.kaannaKortti(5);
        assertEquals(3, p.getPelaajat().get(0).getParit());
    }

    @Test
    public void testParinEiLoytaminenToimii() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        kortit.add(new Kortti("D"));
        p.kaannaKortti(0);
        p.kaannaKortti(1);
        assertEquals("Ei paria, parempi tuuri ensi vuorolla. Paina mitä tahansa nappulaa.", kali.getViestikentta().getText());
    }

    @Test
    public void testVuoronLoppu() {
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        kortit.add(new Kortti("D"));
        p.kaannaKortti(0);
        p.kaannaKortti(1);
        p.vuoronLoppu();
        assertEquals(1, p.getVuoro());
        assertEquals("Vuorossa Pelaaja 2, valitse ensimmäinen kortti.", kali.getViestikentta().getText());

    }

    @Test
    public void testEkanJaTokanSetteritJaGetterit() {
        p.setEkaKortti(new Kortti("A"));
        p.setTokaKortti(new Kortti("B"));
        assertEquals("A", p.getEkaKortti().getTunnus());
        assertEquals("B", p.getTokaKortti().getTunnus());
    }

    @Test
    public void testEkanJaTokanIndeksinSetteritJaGetterit() {
        p.setEkanIndeksi(0);
        p.setTokanIndeksi(1);
        assertEquals(0, p.getEkanIndeksi());
        assertEquals(1, p.getTokanIndeksi());
    }

    @Test
    public void testKortitOlivatPari() {
        p.kortitOlivatPari();
        assertEquals(30, p.getParejaJaljella());
        assertEquals("Hyvä Pelaaja 1, löysit parin! Saat jatkaa, paina mitä tahansa näppäintä.", kali.getViestikentta().getText());
        assertEquals("Pelaaja 1: 1 pari    Pelaaja 2: 0 paria    ", kali.getPistekentta().getText());
    }

    @Test
    public void testPeliLoppu() {
        for (int i = 0; i < 31; i++) {
            p.pariLoydetty();
        }
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("A"));
        p.kaannaKortti(0);
        p.kaannaKortti(1);
        assertEquals(1, p.vuorossaOleva().getParit());
        assertEquals("Pelaaja 1: 1 pari    Pelaaja 2: 0 paria    ", kali.getPistekentta().getText());
        assertEquals("Peli loppui, onnea voittajalle!", kali.getViestikentta().getText());
    }

    @Test
    public void testKaannaEnsimmainenKortti() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        p.kaannaEnsimmainenKortti(0);
        assertEquals("Vuorossa Pelaaja 1, valitse toinen kortti.", kali.getViestikentta().getText());
    }

    @Test
    public void testPoistKortit() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("A"));
        p.poistaKortit();
        assertEquals("Vuorossa Pelaaja 1, valitse ensimmäinen kortti.", kali.getViestikentta().getText());
    }
}
