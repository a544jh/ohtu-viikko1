
package ohtu.verkkokauppa;

import java.util.ArrayList;

<<<<<<< HEAD
public class Kirjanpito {
    private static Kirjanpito instance;

    public static Kirjanpito getInstance() {
        if ( instance==null) {
            instance = new Kirjanpito();
        }

        return instance;
    }

    private ArrayList<String> tapahtumat;

    private Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }

=======
public class Kirjanpito implements KirjanpitoRajapinta {

    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }

    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }
}
