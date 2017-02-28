/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import muistipeli.logiikka.Pelaaja;

public interface Paivitettava {
    
    public void kaannaKorttiEsiin(int kortti);
    
    public void kaannaKorttiPiiloon(int kortti);
    
    public void poistaKortti(int kortti);
    
    public void asetaTeksti(String teksti);
    
    public void asetaPisteet(List<Pelaaja> pelaajat);
    
    public JLabel getViestikentta();
    
    public JLabel getPistekentta();
    
    public List<JButton> getNappulat();
}
