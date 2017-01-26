package muistipeli.logiikka;

import java.util.*;

public class Peli {

    private List<Kortti> kortit;
    private List<Pelaaja> pelaajat;
    private int vuoro;

    public Peli() {
        this.kortit = new ArrayList<>();
        this.pelaajat = new ArrayList<>();
        this.vuoro = 1;
    }

    public void luoKortit() {
        for (int i = 0; i < 32; i++) {
            kortit.add(new Kortti("" + i));
            kortit.add(new Kortti("" + i));
        }
    }

    public void lisaaPelaaja(String nimi) {
        pelaajat.add(new Pelaaja(nimi));
    }

    public void pelaa() {
        luoKortit();
        lisaaPelaaja("Matti");
        lisaaPelaaja("Pekka");
        while (true) {
            System.out.println("Vuorossa: " + pelaajat.get(vuoro % pelaajat.size()));
            vuoro++;
            
        }
    }
}
