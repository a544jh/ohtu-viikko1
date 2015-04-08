package ohtu.verkkokauppa;

<<<<<<< HEAD
public class Pankki {

    private static Pankki instanssi;

    public static Pankki getInstance() {
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    }
    private Kirjanpito kirjanpito;

    private Pankki() {
        kirjanpito = Kirjanpito.getInstance();
    }

=======
public class Pankki implements PankkiRajapinta {

    private KirjanpitoRajapinta kirjanpito;

    public Pankki(KirjanpitoRajapinta k) {
        kirjanpito = k;
    }

    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
