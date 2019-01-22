package gaelle.doyourhair.modeles;

/**
 * Created by HP on 22/01/2019.
 */

public class Adresse {

    @PrimaryKey(autoGenerate = true)
    private long idAdresse;
    private int numRue;
    private String nomRue;
    private String ville;
    private int codePostal;
    private String commentaire;


    public Adresse() { }

    public Adresse(int num , String nomRue,String ville , int codePostal) {
        this.numRue = num;
        this.nomRue =nomRue;
        this.ville = ville;
        this.codePostal = codePostal;

    }

    // --- GETTER ---


    // --- SETTER ---


}
