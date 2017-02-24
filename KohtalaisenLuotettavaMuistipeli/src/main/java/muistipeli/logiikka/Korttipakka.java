package muistipeli.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Luo korttipakan jossa korttien tunnuksina on hienoja merkkejä.
 * 
 */
public class Korttipakka {

    private List<Kortti> korttipakka;
    private List<String> tunnukset;

    /**
     * Luo uuden korttinpakan, jossa kortit saavat tunnuksikseen ASCII-merkkejä.
     */
    public Korttipakka() {
        this.korttipakka = new ArrayList<>();
        this.tunnukset = new ArrayList<>();

        tunnukset.add("☺");
        tunnukset.add("☻");
        tunnukset.add("♥");
        tunnukset.add("♦");
        tunnukset.add("♣");
        tunnukset.add("♠");
        tunnukset.add("•");
        tunnukset.add("◘");
        tunnukset.add("○");
        tunnukset.add("◙");
        tunnukset.add("♂");
        tunnukset.add("♀");
        tunnukset.add("♪");
        tunnukset.add("♫");
        tunnukset.add("☼");
        tunnukset.add("►");
        tunnukset.add("◄");
        tunnukset.add("▲");
        tunnukset.add("▼");
        tunnukset.add("§");
        tunnukset.add("£");
        tunnukset.add("$");
        tunnukset.add("®");
        tunnukset.add("©");
        tunnukset.add("@");
        tunnukset.add("↑");
        tunnukset.add("↓");
        tunnukset.add("→");
        tunnukset.add("←");
        tunnukset.add("░");
        tunnukset.add("▒");
        tunnukset.add("▓");
        
        for (String tunnus : tunnukset) {
            korttipakka.add(new Kortti(tunnus));
            korttipakka.add(new Kortti(tunnus));
        }
    }
    
    /**
     * Palauttaa luodun korttipakan.
     * @return korttipakka Valmis korttipakka
     */
    public List<Kortti> getKorttipakka() {
        return korttipakka;
    }
    

}
