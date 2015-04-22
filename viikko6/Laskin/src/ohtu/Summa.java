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
public class Summa extends Komento{

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    public void suorita() {
        vanhaTulos = sovellus.tulos();
        int syote = Integer.parseInt(syotekentta.getText());
        sovellus.plus(syote);
        tuloskentta.setText(""+sovellus.tulos());
    }   
    
}
