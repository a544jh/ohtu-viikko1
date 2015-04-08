package ohtu.verkkokauppa;

import java.util.*;

<<<<<<< HEAD
public class Varasto {

    private static Varasto instanssi;

    public static Varasto getInstance() {
        if (instanssi == null) {
            instanssi = new Varasto();
        }

        return instanssi;
    }

    private Kirjanpito kirjanpito;
    private HashMap<Tuote, Integer> saldot;

    private Varasto() {
        kirjanpito = Kirjanpito.getInstance();
=======
public class Varasto implements VarastoRajapinta {

    private KirjanpitoRajapinta kirjanpito;
    private HashMap<Tuote, Integer> saldot;

    public Varasto(KirjanpitoRajapinta k) {
        kirjanpito = k;
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
        saldot = new HashMap<Tuote, Integer>();
        alustaTuotteet();
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public Tuote haeTuote(int id){
        for (Tuote t : saldot.keySet()) {
            if ( t.getId()==id) return t;
        }

        return null;
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public int saldo(int id){
        return saldot.get(haeTuote(id));
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public void otaVarastosta(Tuote t){
        saldot.put(t,  saldo(t.getId())-1 );
        kirjanpito.lisaaTapahtuma("otettiin varastosta "+t);
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public void palautaVarastoon(Tuote t){
        saldot.put(t,  saldo(t.getId())+1 );
        kirjanpito.lisaaTapahtuma("palautettiin varastoon "+t);
    }

    private void alustaTuotteet() {
        saldot.put(new Tuote(1, "Koff Portteri", 3), 100);
        saldot.put(new Tuote(2, "Fink Bräu I", 1), 25);
        saldot.put(new Tuote(3, "Sierra Nevada Pale Ale", 5), 30);
        saldot.put(new Tuote(4, "Mikkeller not just another Wit", 7), 40);
        saldot.put(new Tuote(5, "Weihenstephaner Hefeweisse", 4), 15);
    }
}
