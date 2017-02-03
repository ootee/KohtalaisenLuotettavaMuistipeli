package muistipeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    public PeliTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPelaajaLisataanOikein() {
        Peli peli = new Peli();
        peli.lisaaPelaaja("Matti");
        assertEquals("Matti", peli.getPelaajat().get(0).getNimi());
    }
    
    
}