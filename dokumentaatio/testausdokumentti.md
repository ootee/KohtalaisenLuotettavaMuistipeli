# Testausdokumentti

Peliä pyrittiin testaamaan mahdollisimman kattavasti JUnit-testeillä. Kaikkia rivejä ja mutaatioita ei kuitenkaan saatu testeillä katettua. 

Kortti-luokan hashCode-metodi jäi testaamatta, koska siinä käytetään suoraan Javan hashCode-funktiota.
Kortti-luokan rivikattavuudeksi saatiin 94 % ja mutaatiokattavuudeksi 83 %.

Peli-luokan kaannaKortti-metodista jäi testaamatta osittain if-lauseen kaksi viimeistä haaraa. Myös paivitettava-rajapinnan metodeja käyttävät kaannaKorttiEsiin- ja poistaKortti-metodit jäivät testaamatta, koska niiden toiminta onhelppo todeta myös manuaalisesti. Käytännössä näiden toimivuus voidaan todeta siitä, että korttien kuvat kääntyvät esiin ja piiloon ja viestikentän teksti vaihtuu pelitilannetta kulloinkin vastaavaksi.
Peli-luokan rivikattavuudeksi saatiin 98 % ja mutaatiokattavuudeksi 84 %.

Korttipakka-, Pelaaja- ja Vaihtaja-luokan rivi- ja mutaatiokattavuudeksi saatiin täydet 100 %.

Koko ohjelman rivikattavuus oli 98 % ja mutaatiokattavuus 88 %.

Vaihtaja-luokan toimivuutta testattiin automaattisten testien lisäksi itse pelissä kääntämllä kortteja esiin ja pitämällä kirjaa niiden paikoista. Todettiin että paikat vaihtuvat kuten oli odotettu. Peli myös pelattiin läpi ja löydettyjä ja pelistä poistettuja kortteja ei vaihtunut enää mukaan peliin, kuten oli tarkoituskin.

Bugeja pelistä ei testauksen seurauksena löydetty. Ohjelman käyttöliittymässä on pyritty minimoimaan käyttäjän tekemien virheiden mahdollisuus.

Pelin vaikeustaso todettiin korttien vaihtumisen ja pelilaudan suuren koon vuoksi erittäin haastavaksi.
