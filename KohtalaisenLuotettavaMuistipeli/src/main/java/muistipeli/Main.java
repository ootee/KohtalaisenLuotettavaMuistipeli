package muistipeli;

import javax.swing.SwingUtilities;
import muistipeli.kayttoliittyma.Kayttoliittyma;
import muistipeli.logiikka.Peli;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
=======
        Peli peli = new Peli();
        
        Kayttoliittyma kali = new Kayttoliittyma(peli);
        
        kali.run();
        
>>>>>>> 3bcb7d18fc6c5b63e6162c90836e742d3072493a
    }

}
