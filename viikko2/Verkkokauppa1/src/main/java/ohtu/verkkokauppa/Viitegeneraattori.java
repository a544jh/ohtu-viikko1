package ohtu.verkkokauppa;

<<<<<<< HEAD
public class Viitegeneraattori {

    private static Viitegeneraattori instanssi;

    public static Viitegeneraattori getInstance() {
        if (instanssi == null) {
            instanssi = new Viitegeneraattori();
        }

        return instanssi;
    }
    
    private int seuraava;
    
    private Viitegeneraattori(){
        seuraava = 1;    
    }
    
=======
public class Viitegeneraattori implements ViitegeneraattoriRajapinta {
    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
>>>>>>> c74189ff4c11ba2fc6fd8082398b0d4c833dd73d
    public int uusi(){
        return seuraava++;
    }
}
