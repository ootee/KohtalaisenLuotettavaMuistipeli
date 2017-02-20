/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.kayttoliittyma;

/**
 *
 * @author otanttu
 */
public interface Kaannettava {
    
    public void kaannaKorttiEsiin(int kortti);
    
    public void kaannaKorttiPiiloon(int kortti);
    
    public void poistaKortti(int kortti);
    
}
