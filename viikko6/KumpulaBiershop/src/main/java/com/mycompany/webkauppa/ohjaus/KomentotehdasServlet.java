/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Pankki;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Toimitusjarjestelma;

/**
 *
 * @author axel
 */
public class KomentotehdasServlet extends Komentotehdas {
    
    private Varasto varasto;
    private Toimitusjarjestelma t;
    private Pankki p;

    public KomentotehdasServlet(Varasto varasto, Toimitusjarjestelma t, Pankki p) {
        this.varasto = varasto;
        this.t = t;
        this.p = p;
    }
    
    public Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        return new OstoksenLisaysKoriin(varasto, ostoskori, tuoteId);
    }
    
    public Komento ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
        return new OstoksenPoistoKorista(varasto, ostoskori, tuoteId);
    }
            
    public Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori) {
        return new OstoksenSuoritus(varasto, p, t, nimi, osoite, luottokorttinumero, kori);
    }
}
