/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author axel
 */
public class KPSTietokone extends KPSPeli {

    Tekoaly tekoaly;

    public KPSTietokone(Tuomari tuomari, Tekoaly tekoaly) {
        super(tuomari);
        this.tekoaly = tekoaly;
    }

    @Override
    String[] lueSiirrot() {
        String[] siirrot = new String[2];
        System.out.print("Ensimmäisen pelaajan siirto: ");
        siirrot[0] = scanner.nextLine();

        siirrot[1] = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirrot[1]);
        tekoaly.asetaSiirto(siirrot[0]);
        
        return siirrot;
    }

}
