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
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        p.setKortit(kortit);
        p.kaannaKortti(0);
        assertEquals("A", p.getEkaKortti().getTunnus());
    }

    @Test
    public void testPakkaSekoitetaanAlussa() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
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
        p.vuoronLoppu();
        assertEquals("Pelaaja 2", p.vuorossaOleva().getNimi());
    }

    @Test
    public void testParinLoytaminenToimii() {
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("A"));
        p.setKortit(kortit);
        p.kaannaKortti(0);
        p.kaannaKortti(1);
        assertEquals(1, p.getPelaajat().get(0).getParit());
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

}
