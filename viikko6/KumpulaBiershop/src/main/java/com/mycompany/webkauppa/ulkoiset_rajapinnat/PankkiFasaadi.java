package com.mycompany.webkauppa.ulkoiset_rajapinnat;

import java.util.ArrayList;
import java.util.Date;

public class PankkiFasaadi implements Pankki {

//    private static PankkiFasaadi instance;
//
//    public static PankkiFasaadi getInstance() {
//        if (instance == null) {
//            instance = new PankkiFasaadi();
//        }
//
//        return instance;
//    }

    public PankkiFasaadi() {
        maksut = new ArrayList<String>();
    }
    
    private ArrayList<String> maksut;

    @Override
    public boolean maksa(String nimi, String luottokortti, int hinta) {
        if (luottokortti.length() < 2) {
            return false;
        }

        maksut.add( new Date() + " " + nimi + " " + luottokortti + " " + hinta );

        return true;
    }
    
    @Override
    public ArrayList<String> maksut() {
        return maksut;
    }
}
