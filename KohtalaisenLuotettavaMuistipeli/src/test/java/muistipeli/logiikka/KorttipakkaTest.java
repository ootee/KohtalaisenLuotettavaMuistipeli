/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.logiikka;

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
public class KorttipakkaTest {
    
    public KorttipakkaTest() {
    }
    
    @Before
    public void setUp() {
    }
    @Test
    public void testKorttipakanKokoOikea() {
        Korttipakka kp = new Korttipakka();
        assertEquals(64, kp.getKorttipakka().size());
    }
}
