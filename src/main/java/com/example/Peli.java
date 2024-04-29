package com.example;

import java.util.Random;

/**
 *
 * @author Niko Mäenpää
 */

 /**
  * Peli-luokka edustaa kivi-paperi-sakset peliä.
  *
  * Refaktorointi:
  * - Pelin logiikkaa on jaettu eri metodeihin.
  * - Voiton tarkistuslogiikkaa on tiivistetty järkevämmäksi ja helpommin ymmärrettäväksi.
  * - Vakiomuuttujat tyypitetty finaleiksi.
  * - Loppujen muuttujien näkyvyys määritelty privatiksi.
  * - Main-metodi siirretty Peli-luokasta Main-luokkaan.
  */

public class Peli {

    private final Pelaaja p1 = new Pelaaja();
    private final Pelaaja p2 = new Pelaaja();

    private boolean peliLoppui = false;
    private int pelatutPelit = 0;
    private int p1Voitot = 0;
    private int p2Voitot = 0;
    private int tasapelit = 0;

    /**
     * pelaa-metodi käynnistää itse pelin ja pitää sen käynnissä kunnes ehdot voitosta täyttyvät.
     * päivittää myös pelin kulkua terminaalissa.
     */

    public void pelaa () {

        Random random = new Random();

        do {
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

            String p1Valinta = p1.pelaajanValinta(random);
            System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1 voitot: " + p1Voitot);

            String p2Valinta = p2.pelaajanValinta(random);
            System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2 voitot: " + p2Voitot);
            
            valitseVoittaja(p1Valinta, p2Valinta);
            pelatutPelit++;

            if ((p1Voitot >= 3) || (p2Voitot >= 3)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
            System.out.println();

        } while (!peliLoppui);

    }

    /**
     * valitseVoittaja-metodi, joka määrittelee voittajan
     * @param p1Valinta Pelaajan 1 valinta
     * @param p2Valinta Pelaajan 2 valinta
     */
    
    private void valitseVoittaja(String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            tasapelit++;
            System.out.println("\n\t\t\t Draw \n");
        } else if ((p1Valinta.equals("kivi") && p2Valinta.equals("paperi"))
                || (p1Valinta.equals("paperi") && p2Valinta.equals("sakset"))
                || (p1Valinta.equals("sakset") && p2Valinta.equals("kivi"))) {
            p2Voitot++;
            System.out.println("Pelaaja 2 voittaa");
        } else {
            p1Voitot++;
            System.out.println("Pelaaja 1 voittaa");
        }
    }

}
