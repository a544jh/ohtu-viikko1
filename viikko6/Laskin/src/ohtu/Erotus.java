/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author axel
 */
public class Erotus extends Komento{

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    void suorita() {
        vanhaTulos = sovellus.tulos();
        int syote = Integer.parseInt(syotekentta.getText());
        sovellus.miinus(syote);
        tuloskentta.setText(""+sovellus.tulos());
    }
    
}
