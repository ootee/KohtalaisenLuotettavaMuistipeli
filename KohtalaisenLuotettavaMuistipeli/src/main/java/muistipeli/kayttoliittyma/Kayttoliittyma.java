package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import muistipeli.logiikka.Pelaaja;
import muistipeli.logiikka.Peli;

/**
 * Luo pelissä käytettävän peliaslusta ja siihen napit ja viestikentät
 */
public class Kayttoliittyma implements Runnable, Paivitettava {

    private JFrame frame;
    private List<JButton> nappulat;
    private JLabel viestikentta;
    private JLabel pistekentta;
    private NappuloidenKuuntelija kuuntelija;
    private Peli peli;

    /**
     * Luo uuden käyttöliittymän joka saa parametrikseen peliolion
     * @param peli Muistipeli
     */
    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Kohtalaisen luotettava muistipeli");
        Dimension d = new Dimension(600, 650);
        frame.setResizable(false);
        frame.setPreferredSize(d);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
        kuuntelija.setNappulat(nappulat);
        
        peli.setPaivitettava(this);
        
        peli.pelaa();
    }

    private void luoKomponentit(Container container) {
        this.kuuntelija = new NappuloidenKuuntelija(nappulat, peli);

        container.add(luoViestikentta(), BorderLayout.NORTH);

        container.add(luoPistekentta(), BorderLayout.SOUTH);

        container.add(luoNapit(), BorderLayout.CENTER);

    }
    
    private JPanel luoViestikentta() {
        JPanel panel = new JPanel();
        
        this.viestikentta = new JLabel();
        viestikentta.setPreferredSize(new Dimension(580, 15));
        panel.add(viestikentta);
        
        return panel;
    }

    private JPanel luoNapit() {

        JPanel panel = new JPanel(new GridLayout(8, 8));
        this.nappulat = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            JButton nappi = new JButton();
            nappi.setFont(new Font("Sans-Serif", Font.PLAIN, 35));
            nappi.addActionListener(kuuntelija);
            nappulat.add(nappi);
            panel.add(nappi);
        }

        return panel;
    }

    private JPanel luoPistekentta() {

        JPanel panel = new JPanel();

        this.pistekentta = new JLabel();
        pistekentta.setPreferredSize(new Dimension(580, 15));
        panel.add(pistekentta);

        return panel;
    }

    /**
     * Palauttaa käyttöliittymän kehyksen
     * 
     * @return Kehys
     */
    public JFrame getFrame() {
        return frame;
    }

    @Override
    public void kaannaKorttiEsiin(int kortti) {

        nappulat.get(kortti).setText(peli.getKortit().get(kortti).getTunnus());
        
        nappulat.get(kortti).setEnabled(false);
    }

    @Override
    public void kaannaKorttiPiiloon(int kortti) {

        nappulat.get(kortti).setText("");
        
        nappulat.get(kortti).setEnabled(true);
    }

    @Override
    public void poistaKortti(int kortti) {
        nappulat.get(kortti).setText("");
    }

    @Override
    public void asetaTeksti(String teksti) {
        viestikentta.setText(teksti);
    }

    @Override
    public void asetaPisteet(List<Pelaaja> pelaajat) {

        String pisteet = "";

        for (Pelaaja pelaaja : pelaajat) {
            pisteet += pelaaja + "    ";
        }

        pistekentta.setText(pisteet);
    }
    
    
}
