/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import muistipeli.logiikka.Kortti;
import muistipeli.logiikka.Peli;

/**
 *
 * @author otanttu
 */
public class NappuloidenKuuntelija implements ActionListener {

    private Peli peli;
    private List<JButton> nappulat;
    private JLabel viestikentta;
    private JTextField tekstikentta;
    private JButton ok;
    private JFrame frame;

    public NappuloidenKuuntelija(List<JButton> nappulat, JLabel viestikentta, JTextField tekstikentta, JButton ok, JFrame frame, Peli peli) {
        this.nappulat = nappulat;
        this.viestikentta = viestikentta;
        this.tekstikentta = tekstikentta;
        this.ok = ok;
        this.frame = frame;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int kortti = nappulat.indexOf(e.getSource());
        
        nappulat.get(kortti).setText(peli.getKortit().get(kortti).getTunnus());
        
        nappulat.get(kortti).setEnabled(false);

    }

    public void setNappulat(List<JButton> nappulat) {
        this.nappulat = nappulat;
    }

}
