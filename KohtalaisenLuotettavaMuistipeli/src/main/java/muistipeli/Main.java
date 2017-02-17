package muistipeli;

import javax.swing.SwingUtilities;
import muistipeli.kayttoliittyma.Kayttoliittyma;
import muistipeli.logiikka.Peli;

public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
    }

}
