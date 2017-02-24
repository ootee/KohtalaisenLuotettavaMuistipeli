#**Aihe:** Kohtalaisen luotettava muistipeli

**Aihemäärittely**

Toteutetaan muistipeli, jossa lisää vaikeutta tuo satunnainen korttien paikan vaihtuminen. Peliä voi pelata 2 henkilöä ja korttien paikkojen vaihtaminen tapahtuu aina täyden kierroksen jälkeen.

Pelissä käytetään 32 korttiparia, jotka on järjestetty 8 x 8 ruudukkoon. Korttien kuvitukseen käytetään ascii-merkkejä.

**Rakennekuvaus**

Peli-luokka toteuttaa suurimman osan pelin toiminnallisuudesta. Pelaaja-luokan olioilla on nimi ja pisteet. Kortti-olioilla on tunnus, jota käytetään kortin tunnistamiseen. Korttipakka-luokka säilöö korttien merkit ja luo pelissä käytettävän pakan. Vaihtaja-luokka toteuttaa korttien vaihtamisen kierrosten välissä.

Käyttöliittymän tapahtumakuuntelija käyttää peli-luokan metodia välittääkseen löydetyn kortin sijainnin. Peli-luokka muuttaa rajapinnan kautta käyttöliittymän elementtejä pelitilannetta vastaavaksi.

**Pelin säännöt ja käyttöohjeet**

Pelissä on yhteensä 64 korttia, jotka muodostavat 32 paria. Pelaaja valitsee vuorollaan kaksi korttia. Jos korttien kuvat vastaavat toisiaan, on pelaaja löytänyt parin ja saa yhden pisteen. Löydetyt parit poistetaan pelilaudalta. Vuoro kuitataan päätetyksi painamalla vapaata korttia. Pelilaudan yläreunassa näkyy ohjelman viestit ja alareunassa reaaliaikainen pistetilanne.

Kun jokainen pelaaja on saanut vuorollaan kääntää kortit, ennen kuin seuraava kierros alkaa, peli vaihtaa satunnaisesti kahden kortin paikkaa keskenään.Tämän jälkeen alkaa seuraava kierros. Tätä jatketaan kunnes kaikki kortit on löydetty. Pelin voittaa eniten pareja löytänyt pelaaja.

**Käyttäjät** 

* pelaaja

**Pelaajien toiminnot**
  * valitse kortti

**Luokkakaavio**

![Luokkakaavio](Luokkakaavio.png)

**Sekvenssikaaviot**

Pelaaja valitsee ensimmäisen kortin
![Sekvenssikaavio1](sekvenssi1.png)

Pelaaja valitsee toisen kortin ja löytää parin
![Sekvenssikaavio2](sekvenssi2.png)
