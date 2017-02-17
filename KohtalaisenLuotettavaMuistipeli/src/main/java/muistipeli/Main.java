package muistipeli;

import javax.swing.SwingUtilities;
import muistipeli.kayttoliittyma.Kayttoliittyma;
import muistipeli.logiikka.Peli;

public class Main {

    public static void main(String[] args) {

        Peli peli = new Peli();

        Kayttoliittyma kali = new Kayttoliittyma(peli);

        SwingUtilities.invokeLater(kali);
    }

}
