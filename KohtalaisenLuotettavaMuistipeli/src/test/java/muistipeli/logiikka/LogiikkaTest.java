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
    public void testLuodaankoPelaajaOikein() {
        Pelaaja p = new Pelaaja("Matti");
        assertEquals("Matti", p.getNimi());
    }
    
    @Test
    public void testPelaajanParitAlussaNolla() {
        Pelaaja p = new Pelaaja("Matti");
        assertEquals(0, p.getParit());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
