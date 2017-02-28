package muistipeli.logiikka;

import java.util.*;
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
    public void testVaihdaKortitEiVaihdaKortteja() {
        Random stub = new RandomStub(1, 2);
        Vaihtaja v = new Vaihtaja(stub);
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        v.vaihdaKortit(kortit, loydetyt, stub);
        assertEquals("A", kortit.get(0).getTunnus());
    }
    
    @Test
    public void testVaihdaKortitVaihtaaKortit() {
        Random stub = new RandomStub(0, 1, 2);
        Vaihtaja v = new Vaihtaja(stub);
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        v.vaihdaKortit(kortit, loydetyt, stub);
        assertEquals("B", kortit.get(0).getTunnus());
    }
    
    @Test
    public void testJosArvottuIndeksiOnSamaArvotaanKunnesEri() {
        Random stub = new RandomStub(0, 0, 0, 0, 0, 0, 1);
        Vaihtaja v = new Vaihtaja(stub);
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        v.vaihdaKortit(kortit, loydetyt, stub);
        assertEquals("B", kortit.get(0).getTunnus());
    }
    
    @Test
    public void testJosEnsimmainenKorttiOnJoLoydettyArvotaanUusi() {
        Random stub = new RandomStub(0, 1, 2, 0, 1, 2);
        Vaihtaja v = new Vaihtaja(stub);
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        loydetyt.add(new Kortti("A"));
        kortit = v.vaihdaKortit(kortit, loydetyt, stub);
        assertEquals("C", kortit.get(1).getTunnus());
    }
    
    @Test
    public void testJosToinenKorttiOnJoLoydettyArvotaanUusi() {
        Random stub = new RandomStub(0, 1, 2, 0, 1, 2);
        Vaihtaja v = new Vaihtaja(stub);
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        kortit.add(new Kortti("A"));
        kortit.add(new Kortti("B"));
        kortit.add(new Kortti("C"));
        loydetyt.add(new Kortti("B"));
        kortit = v.vaihdaKortit(kortit, loydetyt, stub);
        assertEquals("C", kortit.get(0).getTunnus());
    }
    
    @Test
    public void testJosKortitOnTyhjaPalautetaanTyhja() {
        Random random = new RandomStub(1, 2, 3);
        Vaihtaja v = new Vaihtaja(random);
        List<Kortti> kortit = new ArrayList<>();
        List<Kortti> loydetyt = new ArrayList<>();
        v.vaihdaKortit(kortit, loydetyt, random);
        assertEquals("[]", kortit.toString());
    }
    
}
