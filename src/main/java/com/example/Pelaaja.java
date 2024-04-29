
package com.example;

import java.util.Random;

/**
 *
 * @author Niko Mäenpää
 */

 /*
  * Pelaaja-luokka edustaa yksittäistä pelaajaa.
  */
public class Pelaaja {

    int voitot;

    /**
     * pelaajanValinta-metodi suorittaa pelaajan valinnan.
     * @param random Satunnaislukugeneraattori
     * @return Pelaajan valinta (kivi, paperi tai sakset).
     */
    public String pelaajanValinta(Random random) {
        int valintaIndex = random.nextInt(3);
        String[] valinnat = {"kivi", "paperi", "sakset"};
        return valinnat[valintaIndex];
    }
}
