package muistipeli;

import javax.swing.SwingUtilities;
import muistipeli.kayttoliittyma.Kayttoliittyma;
import muistipeli.logiikka.Peli;

/**
 * Pelin pääluokka.
 */
public class Main {

    /**
     * Luo uuden pelin ja käyttöliittymän ja ajaa ne.
     * @param args jotain Javan default juttuja
     */
    public static void main(String[] args) {

        Peli peli = new Peli();

        Kayttoliittyma kali = new Kayttoliittyma(peli);

        SwingUtilities.invokeLater(kali);
    }

}
