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
public class KPSIhminen extends KPSPeli{

    public KPSIhminen(Tuomari tuomari) {
        super(tuomari);
    }
    
    @Override
    String[] lueSiirrot() {
        String[] siirrot = new String[2];
        System.out.print("Ensimmäisen pelaajan siirto: ");
        siirrot[0] = scanner.nextLine();
        System.out.print("Toisen pelaajan siirto: ");
        siirrot[1] = scanner.nextLine();
        return siirrot;
    }
    
}
