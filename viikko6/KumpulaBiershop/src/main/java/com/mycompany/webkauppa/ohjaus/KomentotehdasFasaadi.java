/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAOInMemory;
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Pankki;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.Toimitusjarjestelma;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.ToimitusjarjestelmaFasaadi;

/**
 *
 * @author axel
 */
public class KomentotehdasFasaadi extends Komentotehdas{

    private Varasto varasto;
    private Toimitusjarjestelma t;
    private Pankki p;

    public KomentotehdasFasaadi(Varasto v) {
        this.varasto = v;
        this.t = new ToimitusjarjestelmaFasaadi();
        this.p = new PankkiFasaadi();
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
