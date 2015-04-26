/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ulkoiset_rajapinnat;

import com.mycompany.webkauppa.sovelluslogiikka.Ostos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author axel
 */
public interface Toimitusjarjestelma {

    void kirjaatoimitus(String nimi, String osoite, List<Ostos> ostokset);

    ArrayList<String> toimitukset();
    
}
