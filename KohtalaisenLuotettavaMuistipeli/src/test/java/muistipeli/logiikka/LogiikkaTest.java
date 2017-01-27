package muistipeli.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import muistipeli.logiikka.Pelaaja;
import muistipeli.logiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author otanttu
 */
public class LogiikkaTest {

    public LogiikkaTest() {
    }

    @Before
    public void setUp() {
        Peli peli = new Peli();
        peli.luoKortit();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testToimiikoPelaajanNimiOikein() {
        Pelaaja p = new Pelaaja("Matti");
        assertEquals("Matti", p.getNimi());
    }

    @Test
    public void testPelaajanParitAlussaNolla() {
        Pelaaja p = new Pelaaja("Matti");
        assertEquals(0, p.getParit());
    }

    @Test
    public void testYksiLoydettyPariLisaaParienLkm() {
        Pelaaja p = new Pelaaja("Matti");
        p.loysiParin();
        assertEquals(1, p.getParit());
    }

    @Test
    public void testUseampiLoydettyPariLisaaParienLkmOikein() {
        Pelaaja p = new Pelaaja("Matti");
        p.loysiParin();
        p.loysiParin();
        p.loysiParin();
        assertEquals(3, p.getParit());
    }

    @Test
    public void testToStringToimiiOikeinOikeinYhdellaParilla() {
        Pelaaja p = new Pelaaja("Matti");
        p.loysiParin();
        assertEquals("Matti: 1 pari", p.toString());
    }

    @Test
    public void testToStringToimiiOikeinUseammallaParilla() {
        Pelaaja p = new Pelaaja("Matti");
        p.loysiParin();
        p.loysiParin();
        assertEquals("Matti: 2 paria", p.toString());
    }

    @Test
    public void testKorttiTunnusToimiiOikein() {
        Kortti k = new Kortti("kana");
        assertEquals("kana", k.getTunnus());
    }

    @Test
    public void testKorttiToStringToimiiOikein() {
        Kortti k = new Kortti("kana");
        assertEquals("kana", k.toString());
    }

    @Test
    public void testKorttiEqualsToimiiJosSamatKortit() {
        Kortti k = new Kortti("kana");
        Kortti l = new Kortti("kana");
        assertEquals(true, k.equals(l));
    }
    
    @Test
    public void testKorttieEqualsToimiiJosVerrattavaEiObjekti() {
        Kortti k = new Kortti("kana");
        assertEquals(false, k.equals(0));
    }
    
    @Test
    public void testKorttiEqualsToimiiJosVerrattavaNull() {
        Kortti k = new Kortti("kana");
        Kortti l = null;
        assertEquals(false, k.equals(l));
    }
    
    @Test
    public void testKorttiEqualsToimiiJosEriLuokka() {
        Kortti k = new Kortti("kana");
        String l = "moi";
        assertEquals(false, k.equals(l));
    }
    
    @Test
    public void testKorttiEqualsToimiiJosEriTunnus() {
        Kortti k = new Kortti("kana");
        Kortti l = new Kortti("kukko");
        assertEquals(false, k.equals(l));
    }

    @Test
    public void testKorttiHashCodeToimii() {
        Kortti k = new Kortti("kana");
        Kortti l = new Kortti("kana");
        assertEquals(k.hashCode(), l.hashCode());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
