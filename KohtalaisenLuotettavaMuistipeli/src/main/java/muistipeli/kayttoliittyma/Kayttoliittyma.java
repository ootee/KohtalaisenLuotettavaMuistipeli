package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import muistipeli.logiikka.Peli;

public class Kayttoliittyma implements Runnable, Paivitettava {

    private JFrame frame;
    private List<JButton> nappulat;
    private JLabel viestikentta;
    private JTextField pistekentta;
    private JButton seuraava;
    private NappuloidenKuuntelija kuuntelija;
    private Peli peli;

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
        this.kuuntelija = new NappuloidenKuuntelija(nappulat, viestikentta, pistekentta, seuraava, frame, peli);

        this.viestikentta = new JLabel();
        
        viestikentta.setPreferredSize(new Dimension(600, 50));
        
        container.add(viestikentta, BorderLayout.NORTH);

        container.add(luoPistekentta(), BorderLayout.SOUTH);

        container.add(luoNapit(), BorderLayout.CENTER);

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

        this.pistekentta = new JTextField();
        pistekentta.setPreferredSize(new Dimension(500, 30));
        pistekentta.addActionListener(kuuntelija);
        panel.add(pistekentta, BorderLayout.WEST);

//        this.seuraava = new JButton("Seuraava");
//        seuraava.setEnabled(false);
//        seuraava.setPreferredSize(new Dimension(600, 30));
//        seuraava.addActionListener(kuuntelija);
//        panel.add(seuraava, BorderLayout.EAST);

        return panel;
    }

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
    public void seuraavaEnabled() {
        seuraava.setEnabled(true);
    }

    @Override
    public void seuraavaDisabled() {
        seuraava.setEnabled(false);
    }
    
    
}
