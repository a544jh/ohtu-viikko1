package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(OLETUSKAPASITEETTI,OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti,OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko väärin");//heitin vaan jotain :D
        }
        alkiot = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            alkiot[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % alkiot.length == 0) {
                kasvataTaulukko();
            }
            return true;
        }
        return false;
    }

    private void kasvataTaulukko() {
        int[] taulukkoOld = new int[alkiot.length];
        kopioiTaulukko(alkiot, taulukkoOld);
        alkiot = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, alkiot);
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = etsiLuku(luku);
        return poistaIndeksista(kohta);
    }

    private boolean poistaIndeksista(int kohta) {
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                alkiot[j] = alkiot[j + 1];
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private int etsiLuku(int luku) {
        int kohta;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                return kohta;
            }
        }
        return -1;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            s += alkiot[i];
            s += ", ";
        }
        s += alkiot[alkioidenLkm - 1];
        s += "}";
        return s;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(alkiot, 0, taulu, 0, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aAlkiot = a.toIntArray();
        for (int i = 0; i < aAlkiot.length; i++) {
            if (b.kuuluu(aAlkiot[i])) {
                leikkaus.lisaa(aAlkiot[i]);
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aAlkiot = a.toIntArray();
        for (int i = 0; i < aAlkiot.length; i++) {
            if (!b.kuuluu(aAlkiot[i])) {
                erotus.lisaa(aAlkiot[i]);
            }
        }
        return erotus;
    }

}
