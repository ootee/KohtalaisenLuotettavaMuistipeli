package muistipeli.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import muistipeli.logiikka.Peli;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private List<JButton> nappulat;
    private JLabel viestikentta;
    private JTextField tekstikentta;
    private JButton ok;
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
        
        peli.pelaa();
    }

    private void luoKomponentit(Container container) {
        this.kuuntelija = new NappuloidenKuuntelija(nappulat, viestikentta, tekstikentta, ok, frame, peli);

        this.viestikentta = new JLabel("Tähän tulee ohjelman antamat viestit.");
        
        viestikentta.setPreferredSize(new Dimension(600, 50));
        
        container.add(viestikentta, BorderLayout.NORTH);

//        container.add(luoTekstikentta(), BorderLayout.SOUTH);

        container.add(luoNapit(), BorderLayout.CENTER);

    }

    private JPanel luoNapit() {
        JPanel panel = new JPanel(new GridLayout(8, 8));
        this.nappulat = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            JButton nappi = new JButton();
            nappi.setFont(new Font("Arial", Font.PLAIN, 35));
            nappi.addActionListener(kuuntelija);
            nappulat.add(nappi);
            panel.add(nappi);
        }
        return panel;
    }

    private JPanel luoTekstikentta() {
        JPanel panel = new JPanel();

        this.tekstikentta = new JTextField();
        tekstikentta.setPreferredSize(new Dimension(500, 30));
        tekstikentta.addActionListener(kuuntelija);
        panel.add(tekstikentta, BorderLayout.WEST);

        this.ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(80, 30));
        ok.addActionListener(kuuntelija);
        panel.add(ok, BorderLayout.EAST);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
