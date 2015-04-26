package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAOInMemory;
import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.ohjaus.Komentotehdas;
import com.mycompany.webkauppa.ohjaus.KomentotehdasFasaadi;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OstoksenLisaysKoriinTest {
    Varasto varasto = new Varasto(new TuoteDAOInMemory());
    Ostoskori kori;    
    long tuoteid = 1;
    Tuote tuote;
    
    Komentotehdas komennot;
    Komento ostoksenLisays;
    
    @Before
    public void setUp() {
        komennot = new KomentotehdasFasaadi(varasto);
        tuote = varasto.etsiTuote(tuoteid);     
        if ( tuote.getSaldo()==0 ) {
            tuote.setSaldo(1);
        } 
        kori = new Ostoskori();            
    }
    
    @Test
    public void koriSisaltaaLisatynTuotteen() {
        ostoksenLisays = komennot.ostoksenLisaysKoriin(kori, tuoteid);
        ostoksenLisays.suorita();
    
        assertEquals(1, kori.tuotteitaKorissa());
        assertEquals(tuote.getHinta(), kori.hinta());
        assertEquals(tuote.getNimi(), kori.ostokset().get(0).tuotteenNimi());
    }
    
    @Test
    public void tuotteenMaaraVahentyy(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
        
        ostoksenLisays = komennot.ostoksenLisaysKoriin(kori, tuoteid);
        ostoksenLisays.suorita();
    
        assertEquals(varastossaAluksi-1, varasto.etsiTuote(tuoteid).getSaldo());
    }
    
    @Test
    public void josTuotteenVarastosaldoNollaEiTuotettaLaitetaOstoskoriin() {
        varasto.etsiTuote(tuoteid).setSaldo(0);
        
        ostoksenLisays = komennot.ostoksenLisaysKoriin(kori, tuoteid);
        ostoksenLisays.suorita();
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size() );
    }
}
