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
public class KorttiTest {

    public KorttiTest() {
    }

    @Before
    public void setUp() {
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

}
