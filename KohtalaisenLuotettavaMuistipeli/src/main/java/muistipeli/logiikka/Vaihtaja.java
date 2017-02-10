package muistipeli.logiikka;

import java.util.*;

/**
 * Tarjoaa toiminnallisuuden pelin korttien vaihtamiseen.
 * 
 */
public class Vaihtaja {

    private Random random;

    /**
     * Luo uuden vaihtajaolion, joka saa parametrinään satunnaislukuolion.
     * 
     * @param random satunnaislukuolio
     */
    public Vaihtaja(Random random) {
        this.random = random;
    }

    /**
     * Metodi päättää vaihdetaanko kortteja satunnaisluvun ja vaikeustason perusteella. 
     * 
     * @param vaikeustaso pelin vaikeustaso
     * @param random satunnaislukuolio
     * @return vaihdetaanko kortteja
     */
    public boolean vaihdetaanko(int vaikeustaso, Random random) {
        double todnak = random.nextDouble();
        if (vaikeustaso == 1 && todnak > 0.75) {
            return true;
        }
        if (vaikeustaso == 2 && todnak > 0.5) {
            return true;
        }
        if (vaikeustaso == 3 && todnak > 0.25) {
            return true;
        }
        return false;
    }

    /**
     * Metodi vaihtaa kaksi parametrinään saaman listan korttia keskenään. Jos kortti on jo loydetty, sitä ei vaihdeta vaan arvotaan uusi.
     * 
     * @param kortit pelin kaikki kortit
     * @param loydetyt löydetyt kortit
     * @param random satunnaislukuolio
     * @return lista jossa kortit vaihdettu
     */
    public List<Kortti> vaihdaKortit(List<Kortti> kortit, List<Kortti> loydetyt, Random random) {
        if (!kortit.isEmpty()) {

            //Arvotaan vaihdettavien korttien indeksit
            int ekanKortinIndeksi = random.nextInt(64);
            int tokanKortinIndeksi = random.nextInt(64);
            //Jos sama indeksi, arvotaan kunnes eri
            if (ekanKortinIndeksi == tokanKortinIndeksi) {
                while (ekanKortinIndeksi == tokanKortinIndeksi) {
                    tokanKortinIndeksi = random.nextInt(64);
                }
            }
            //Jos kortit on jo löydetty, arvotaan uudet
            if (!loydetyt.isEmpty()) {
                if (loydetyt.contains(kortit.get(ekanKortinIndeksi))) {
                    while (loydetyt.contains(kortit.get(ekanKortinIndeksi))) {
                        ekanKortinIndeksi = random.nextInt(64);
                    }
                }
                if (loydetyt.contains(kortit.get(tokanKortinIndeksi))) {
                    while (loydetyt.contains(kortit.get(tokanKortinIndeksi))) {
                        tokanKortinIndeksi = random.nextInt(64);
                    }
                }
            }

            //Vaihdetaan kortit apumuuttujan avulla
            Kortti apu = kortit.get(ekanKortinIndeksi);
            kortit.set(ekanKortinIndeksi, kortit.get(tokanKortinIndeksi));
            kortit.set(tokanKortinIndeksi, apu);
            //Palautetaan korttilista
            return kortit;
        }
        return kortit;
    }

}
