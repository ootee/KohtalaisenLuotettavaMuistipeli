
package muistipeli.logiikka;

import java.util.*;

public class Vaihtaja {
    private Random random;

    public Vaihtaja() {
        this.random = new Random();
    }
    
    public boolean vaihdetaanko(int vaikeustaso) {
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
    
    public List<Kortti> vaihdaKortit(List<Kortti> kortit,int vaikeustaso) {
        //Tarkastetaan vaihdetaanko kortit
        if(!vaihdetaanko(vaikeustaso)) {
            return kortit;
        }
        //Arvotaan vaihdettavien korttien indeksit
        int ekanKortinIndeksi = random.nextInt(64);
        int tokanKortinIndeksi = random.nextInt(64);
        //Jos sama indeksi, arvotaan kunnes eri
        if (ekanKortinIndeksi == tokanKortinIndeksi) {
            while (ekanKortinIndeksi == tokanKortinIndeksi) {
                tokanKortinIndeksi = random.nextInt(64);
            }
        }
        //Vaihdetaan kortit apumuuttujan avulla
        Kortti apu = kortit.get(ekanKortinIndeksi);
        kortit.set(ekanKortinIndeksi, kortit.get(tokanKortinIndeksi));
        kortit.set(tokanKortinIndeksi, apu);
        //Palautetaan korttilista
        return kortit;
    }
    
    
    
}
