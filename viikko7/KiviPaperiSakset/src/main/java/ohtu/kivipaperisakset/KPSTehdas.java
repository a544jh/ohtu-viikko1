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
public class KPSTehdas {
    public static KPSPeli KPSPelaajaVsPelaaja(){
        return new KPSIhminen(new Tuomari());
    }
    
    public static KPSPeli KPSTekoaly(){
        return new KPSTietokone(new Tuomari(), new TekoalyHelppo());
    }
    
    public static KPSPeli KPSTekoalyParannettu(){
        return new KPSTietokone(new Tuomari(), new TekoalyParannettu(20));
    }
}
