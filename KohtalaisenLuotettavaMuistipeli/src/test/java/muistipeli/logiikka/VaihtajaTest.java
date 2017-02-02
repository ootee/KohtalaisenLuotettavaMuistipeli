package muistipeli.logiikka;

import java.util.*;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VaihtajaTest {

    public VaihtajaTest() {
    }

    @Test
    public void testVaihdetaanVaikeustaso1() {
        Random stubi = new RandomStub(0.76, 0.76);
        Vaihtaja v = new Vaihtaja(stubi);
        assertEquals(true, v.vaihdetaanko(1, stubi));
    }

    @Test
    public void testVaihdetaanVaikeustaso2() {
        Random stubi = new RandomStub(0.51, 0.51);
        Vaihtaja v = new Vaihtaja(stubi);
        assertEquals(true, v.vaihdetaanko(2, stubi));
    }

    @Test
    public void testVaihdetaanVaikeustaso3() {
        Random stubi = new RandomStub(0.26, 0.26);
        Vaihtaja v = new Vaihtaja(stubi);
        assertEquals(true, v.vaihdetaanko(3, stubi));
    }

    @Test
    public void testEiVaihdetaVaikeustaso1() {
        Random stubi = new RandomStub(0.75, 0.75);
        Vaihtaja v = new Vaihtaja(stubi);
        assertEquals(false, v.vaihdetaanko(1, stubi));
    }

    @Test
    public void testEiVaihdetaVaikeustaso2() {
        Random stubi = new RandomStub(0.5, 0.5);
        Vaihtaja v = new Vaihtaja(stubi);
        assertEquals(false, v.vaihdetaanko(2, stubi));
    }

    @Test
    public void testEiVaihdetaVaikeustaso3() {
        Random stubi = new RandomStub(0.25, 0.5);
        Vaihtaja v = new Vaihtaja(stubi);
        assertEquals(false, v.vaihdetaanko(3, stubi));
    }

    @Test
    public void testVaihdaKortitEiVaihdaKortteja() {
        Random stub = new RandomStub(0.1, 0.1, 0.1);
        Vaihtaja v = new Vaihtaja(stub);
        List<Kortti> kortit = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        v.vaihdaKortit(kortit, 1);
        assertEquals("A", kortit.get(0).getTunnus());
    }
}
