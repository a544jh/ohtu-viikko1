/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author axel
 */
public abstract class KPSPeli {

    static final Scanner scanner = new Scanner(System.in);
    Tuomari tuomari;


    public KPSPeli(Tuomari tuomari) {
        this.tuomari = tuomari;
    }

    public void pelaa() {

        String[] siirrot;

        siirrot = lueSiirrot();

        while (onkoOkSiirto(siirrot[0]) && onkoOkSiirto(siirrot[1])) {
            tuomari.kirjaaSiirto(siirrot[0], siirrot[1]);
            System.out.println(tuomari);
            System.out.println();
            siirrot = lueSiirrot();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    abstract String[] lueSiirrot();
}

