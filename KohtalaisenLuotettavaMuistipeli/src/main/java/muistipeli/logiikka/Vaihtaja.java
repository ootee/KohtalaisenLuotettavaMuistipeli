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
     * Metodi vaihtaa kaksi kortit-listan korttia keskenään. Jos kortti on loydetyt-listalla, sitä ei vaihdeta vaan arvotaan uusi.
     * 
     * @param kortit pelin kaikki kortit
     * @param loydetyt löydetyt kortit
     * @param random satunnaislukuolio
     * @return lista jossa kortit vaihdettu
     */
    public List<Kortti> vaihdaKortit(List<Kortti> kortit, List<Kortti> loydetyt, Random random) {
        if (!kortit.isEmpty()) {

            //Arvotaan vaihdettavien korttien indeksit
            int ekanKortinIndeksi = random.nextInt(kortit.size());
            int tokanKortinIndeksi = random.nextInt(kortit.size());
            //Jos sama indeksi, arvotaan kunnes eri
            if (ekanKortinIndeksi == tokanKortinIndeksi) {
                while (ekanKortinIndeksi == tokanKortinIndeksi) {
                    tokanKortinIndeksi = random.nextInt(kortit.size());
                }
            }
            //Jos kortit on jo löydetty, arvotaan uudet
            if (!loydetyt.isEmpty()) {
                if (loydetyt.contains(kortit.get(ekanKortinIndeksi))) {
                    while (loydetyt.contains(kortit.get(ekanKortinIndeksi))) {
                        ekanKortinIndeksi = random.nextInt(kortit.size());
                    }
                }
                if (loydetyt.contains(kortit.get(tokanKortinIndeksi))) {
                    while (loydetyt.contains(kortit.get(tokanKortinIndeksi))) {
                        tokanKortinIndeksi = random.nextInt(kortit.size());
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
