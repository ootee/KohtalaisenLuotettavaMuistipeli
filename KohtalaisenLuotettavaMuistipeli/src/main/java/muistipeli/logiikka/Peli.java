package muistipeli.logiikka;

import java.util.*;

public class Peli {

    private List<Kortti> kortit;
    private List<Boolean> loydetyt;
    private List<Pelaaja> pelaajat;
    private int vuoro;
    private int parejaJaljella;
    private Scanner lukija;

    public Peli() {
        this.lukija = new Scanner(System.in);
        this.kortit = new ArrayList<>();
        this.pelaajat = new ArrayList<>();
        this.loydetyt = new ArrayList<>();
        this.vuoro = 1;
        this.parejaJaljella = 8;
    }

    public void luoKortit() {
        for (int i = 0; i < 8; i++) {
            kortit.add(new Kortti("" + i));
            kortit.add(new Kortti("" + i));
        }

        for (int i = 0; i < 64; i++) {
            loydetyt.add(Boolean.FALSE);
        }
    }

    public void lisaaPelaaja(String nimi) {
        pelaajat.add(new Pelaaja(nimi));
    }
    
    public boolean parejaOnVielaJaljella() {
        if (parejaJaljella == 0) {
            return false;
        }
        return true;
    }

    public void pelaa() {
        luoKortit();
        lisaaPelaaja("Matti");
        lisaaPelaaja("Pekka");
        while (parejaOnVielaJaljella()) {
            int vuorossaOleva = vuoro % pelaajat.size();

            System.out.println("Vuorossa: " + pelaajat.get(vuorossaOleva));
            System.out.println("");

            System.out.print("Valitse ensimmäinen kortti. ");
            int kortti1 = Integer.parseInt(lukija.nextLine());
            System.out.println(kortit.get(kortti1));

            System.out.print("Valitse toinen kortti. ");
            int kortti2 = Integer.parseInt(lukija.nextLine());
            System.out.println(kortit.get(kortti2));

            if (kortit.get(kortti1).equals(kortit.get(kortti2))) {
                pelaajat.get(vuorossaOleva).loysiParin();

                System.out.println("Hyvä " + pelaajat.get(vuorossaOleva).getNimi() + ", löysit parin.");
                System.out.println("Sinulla on " + pelaajat.get(vuorossaOleva).pareja());

                loydetyt.set(kortti1, Boolean.TRUE);
                loydetyt.set(kortti2, Boolean.TRUE);
                
                parejaJaljella--;
                
                System.out.println("Pareja jäljellä " + parejaJaljella);
            }
            vuoro++;

        }
        
        System.out.println("Peli loppu.");
        for (Pelaaja p : pelaajat) {
            System.out.println(p);
        }
    }

    public List<Kortti> getKortit() {
        return kortit;
    }

    public void setKortit(List<Kortti> kortit) {
        this.kortit = kortit;
    }

}
