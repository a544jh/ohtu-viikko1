/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;

/**
 *
 * @author axel
 */
public abstract class Komentotehdas {

    public abstract Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId);

    public abstract Komento ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId);

    public abstract Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori kori);
    
}
