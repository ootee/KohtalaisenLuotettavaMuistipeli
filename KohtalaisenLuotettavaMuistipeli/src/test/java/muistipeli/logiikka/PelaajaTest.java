package muistipeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    public PelaajaTest() {
    }

    @Before
    public void setUp() {
//        Peli peli = new Peli();
//        peli.luoKortit();
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
    public void testParejaToimiiOikeinYhdellaParilla() {
        Pelaaja p = new Pelaaja("Matti");
        p.loysiParin();
        assertEquals("Sinulla on 1 pari.", p.pareja());
    }
    
    @Test
    public void testParejaToimiiOikeinNOllallaParilla() {
        Pelaaja p = new Pelaaja("Matti");
        assertEquals("Sinulla on 0 paria.", p.pareja());
    }
}
