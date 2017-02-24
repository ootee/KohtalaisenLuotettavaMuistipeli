/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

import java.util.List;
import muistipeli.logiikka.Pelaaja;

/**
 * Käyttöliittymän muokkaamiseen käytettävä rajapinta.
 */
public interface Paivitettava {
    
    /**
     * Kääntää kortin esiin.
     * @param kortti Käännettävän kortin indeksi
     */
    public void kaannaKorttiEsiin(int kortti);
    
    /**
     * Kääntää kortin piiloon.
     * @param kortti Käännettävän kortin indeksi
     */
    public void kaannaKorttiPiiloon(int kortti);
    
    /**
     * Poistaa löydetyn kortin pöydältä.
     * @param kortti Poistettavan kortin indeksi
     */
    public void poistaKortti(int kortti);
    
    /**
     * Asettaa viestikenttään tekstin.
     * @param teksti Asetettava teksti
     */
    public void asetaTeksti(String teksti);
    
    /**
     * Asettaa pistekenttään pistetilanteen.
     * @param pelaajat Lista pelaajista
     */
    public void asetaPisteet(List<Pelaaja> pelaajat);
}
